package com.example.modernandroidapp.data.repository


import com.example.modernandroidapp.data.dataSources.local.ImageDao
import com.example.modernandroidapp.data.dataSources.remote.ImagesService
import com.example.modernandroidapp.data.mappers.toImageEntity
import com.example.modernandroidapp.domain.mappers.toCharacterModel
import com.example.modernandroidapp.utils.coroutines.IoDispatcher
import com.example.modernandroidapp.utils.wrapper.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class ImagesRepositoryImpl @Inject constructor(
    private val networkDataSource: ImagesService,
    private val localDataSource: ImageDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : IImagesRepository {
    override fun getImages() = flow {

        val localData = localDataSource.getAll()
        val response = networkDataSource.getCharacters()

        emit(Resource.Loading(true))

        /**
         * If the network call is successful update database with any new images
         * and emit local database as single source of truth.
         */

        if (response.isSuccessful) {
            response.body()?.results?.map { imageDto ->
                imageDto.toImageEntity()
            }?.let { localDataSource.saveImages(it) }
            emit(
                Resource.Success(
                    localData.map { imageEntity ->
                        imageEntity.toCharacterModel()
                    })
            )
        }
        /**
         * If there is an error fetching remote database and the local database is not empty
         * emit local data.
         */
        else if (localData.isNotEmpty()) {
            emit(Resource.Success(localData.map { imageEntity ->
                imageEntity.toCharacterModel()
            }))
        } else {
            /**
             * If theres is both an error with remote and local is empty emit error reason,
             * empty data will be handled in the view model.
             */
            emit(
                Resource.Error(
                    "Local data is empty and network call failed " +
                            "with error ${response.code()}"
                )
            )
        }

        emit(Resource.Loading(false))
    }.flowOn(ioDispatcher)
}
