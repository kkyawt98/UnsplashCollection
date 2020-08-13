package com.kyawt.mycollection.service.model.random


import com.google.gson.annotations.SerializedName

data class Position(
    @SerializedName("latitude")
    val latitude: Any,
    @SerializedName("longitude")
    val longitude: Any
)