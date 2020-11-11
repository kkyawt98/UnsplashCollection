package com.kyawt.mycollection.service.model.users


import com.google.gson.annotations.SerializedName

data class SubcategoryX(
    @SerializedName("pretty_slug")
    val prettySlug: String,
    @SerializedName("slug")
    val slug: String
)