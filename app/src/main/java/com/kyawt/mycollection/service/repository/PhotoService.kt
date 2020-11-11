package com.kyawt.mycollection.service.repository

import com.kyawt.mycollection.service.model.collection.Collection
import com.kyawt.mycollection.service.model.collectionDetail.CollectionDetail
import com.kyawt.mycollection.service.model.collectionItem.CollectionItem
import com.kyawt.mycollection.service.model.detail.Detail
import com.kyawt.mycollection.service.model.photo.Photo
import com.kyawt.mycollection.service.model.users.Users
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoService {
    @GET("photos/?client_id=LUXItNFXZ3sV5SW_HCtr6olQfgxhBClz0PVWUfHtEBY")
    suspend fun getPhotoList(): Photo

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

}