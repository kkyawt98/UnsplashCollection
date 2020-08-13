package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class LinksXXXX(
    @SerializedName("download")
    val download: String,
    @SerializedName("download_location")
    val downloadLocation: String,
    @SerializedName("html")
    val html: String,
    @SerializedName("self")
    val self: String
)