package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class UrlsXXX(
    @SerializedName("full")
    val full: String,
    @SerializedName("raw")
    val raw: String,
    @SerializedName("regular")
    val regular: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("thumb")
    val thumb: String
)