package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class Statistics(
    @SerializedName("downloads")
    val downloads: Downloads,
    @SerializedName("id")
    val id: String,
    @SerializedName("likes")
    val likes: Likes,
    @SerializedName("views")
    val views: Views
)