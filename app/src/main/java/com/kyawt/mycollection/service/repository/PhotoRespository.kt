package com.kyawt.mycollection.service.repository
import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collectionItem.CollectionItem
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.model.users.Users
import com.kyawt.mycollection.service.model.usersCollections.UsersCollections
import com.kyawt.mycollection.service.model.usersLiked.UsersLiked
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotos

class PhotoRepository {
    val service = ServiceProvider.getService()
    suspend fun getPhotoList(page :Int): Photo {
        return service.getPhotoList(page)
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

    suspend fun getUserPhotos(username: String) : UsersPhotos{
        return service.getUsersPhotos(username)
    }

    suspend fun getUserLikes(username: String) : UsersLiked{
        return service.getUsersLikes(username)
    }

    suspend fun getUserCollections(username: String) : UsersCollections{
        return service.getUsersCollections(username)
    }

}