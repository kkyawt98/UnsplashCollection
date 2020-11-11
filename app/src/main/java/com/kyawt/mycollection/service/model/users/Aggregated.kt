package com.kyawt.mycollection.service.model.users


import com.google.gson.annotations.SerializedName

data class Aggregated(
    @SerializedName("source")
    val source: Source,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)