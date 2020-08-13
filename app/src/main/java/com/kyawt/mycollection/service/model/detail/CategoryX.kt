package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class CategoryX(
    @SerializedName("pretty_slug")
    val prettySlug: String,
    @SerializedName("slug")
    val slug: String
)