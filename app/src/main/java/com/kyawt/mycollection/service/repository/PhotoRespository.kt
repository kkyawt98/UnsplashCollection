package com.kyawt.mycollection.service.repository

import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collectionDetail.CollectionDetail
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.Photo

class PhotoRepository {
    val service = ServiceProvider.getService()
    suspend fun getPhotoList(): Photo {
        return service.getPhotoList()
    }

    suspend fun getPhotoDetail(photoId : String): Detail{
        return service.getPhotoDetail(photoId)
    }

    suspend fun getCategories() : Collection{
        return service.getCategories()
    }

    suspend fun getCategory(category_id : String) : CollectionDetail{
        return service.getCategory(category_id)
    }
}