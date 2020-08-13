package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class ProfileImageXXX(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("small")
    val small: String
)