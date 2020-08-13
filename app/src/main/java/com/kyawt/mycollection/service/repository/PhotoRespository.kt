package com.kyawt.mycollection.service.repository

import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.Photo

class PhotoRepository {
    val service = ServiceProvider.getService()
    suspend fun getPhotoList(): Photo {
        return service.getPhotoList()
    }

    suspend fun getPhotoDetail(movie_id : String): Detail{
        return service.getPhotoDetail(movie_id)
    }

    suspend fun getCategories() : Collection{
        return service.getCategories()
    }
}