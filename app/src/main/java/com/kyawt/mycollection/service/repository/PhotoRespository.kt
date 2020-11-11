package com.kyawt.mycollection.service.repository
import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collectionItem.CollectionItem
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.model.users.Users

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

    suspend fun getCollectionItem(collectionId:String) : CollectionItem {
        return service.getCollectionItems(collectionId)
    }

    suspend fun getUser(username:String) : Users{
        return service.getUsers(username)
    }

}