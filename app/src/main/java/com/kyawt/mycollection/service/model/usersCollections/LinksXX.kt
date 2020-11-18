package com.kyawt.mycollection.service.model.usersCollections


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LinksXX(
    @SerializedName("html")
    val html: String,
    @SerializedName("photos")
    val photos: String,
    @SerializedName("related")
    val related: String,
    @SerializedName("self")
    val self: String
):Parcelable