package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class LinksXXX(
    @SerializedName("html")
    val html: String,
    @SerializedName("photos")
    val photos: String,
    @SerializedName("related")
    val related: String,
    @SerializedName("self")
    val self: String
)