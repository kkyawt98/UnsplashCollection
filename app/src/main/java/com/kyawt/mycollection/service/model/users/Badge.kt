package com.kyawt.mycollection.service.model.users


import com.google.gson.annotations.SerializedName

data class Badge(
    @SerializedName("link")
    val link: String,
    @SerializedName("primary")
    val primary: Boolean,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("title")
    val title: String
)