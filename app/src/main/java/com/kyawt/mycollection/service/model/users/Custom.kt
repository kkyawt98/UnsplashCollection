package com.kyawt.mycollection.service.model.users


import com.google.gson.annotations.SerializedName

data class Custom(
    @SerializedName("source")
    val source: SourceX,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)