package com.kyawt.mycollection.service.repository

import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collectionItem.CollectionItem
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.model.users.Users
import com.kyawt.mycollection.service.model.usersCollections.UsersCollections
import com.kyawt.mycollection.service.model.usersLiked.UsersLiked
import com.kyawt.mycollection.service.model.usersPhotos.UsersPhotos
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {

    @Headers("X-Total: 346")

    @GET("photos/?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getPhotoList(
        @Query("page") page : Int
    ): Photo

    @GET("photos/{id}?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getPhotoDetail(
        @Path("id") photoId : String
    ) : Detail

    @GET("collections/?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getCategories() : Collection

    @GET("collections/{id}/photos?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getCollectionItems(
        @Path("id") category_id : String
    ) : CollectionItem

    @GET("users/{username}?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getUsers(
        @Path("username") userName : String
    ): Users

    @GET("users/{username}/photos?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getUsersPhotos(
        @Path("username") userName: String
    ): UsersPhotos

    @GET("users/{username}/likes?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getUsersLikes(
        @Path("username") userName: String
    ) : UsersLiked

    @GET("users/{username}/collections?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getUsersCollections(
        @Path("username") userName: String
    ) : UsersCollections

}