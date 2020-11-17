package com.kyawt.mycollection.service.model.usersPhotos


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LinksX(
    @SerializedName("followers")
    val followers: String,
    @SerializedName("following")
    val following: String,
    @SerializedName("html")
    val html: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("photos")
    val photos: String,
    @SerializedName("portfolio")
    val portfolio: String,
    @SerializedName("self")
    val self: String
):Parcelable