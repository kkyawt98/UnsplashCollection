package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class TagX(
    @SerializedName("source")
    val source: SourceX,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)