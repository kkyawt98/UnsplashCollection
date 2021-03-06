package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("alt_description")
    val altDescription: String,
    @SerializedName("categories")
    val categories: List<Any>,
    @SerializedName("color")
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("current_user_collections")
    val currentUserCollections: List<Any>,
    @SerializedName("description")
    val description: String,
    @SerializedName("downloads")
    val downloads: String,
    @SerializedName("exif")
    val exif: Exif,
    @SerializedName("height")
    val height: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("location")
    val location: Location,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("promoted_at")
    val promotedAt: String,
    @SerializedName("related_collections")
    val relatedCollections: RelatedCollections,
    @SerializedName("sponsorship")
    val sponsorship: Any,
    @SerializedName("tags")
    val tags: List<TagX>,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: UrlsXXXX,
    @SerializedName("user")
    val user: UserXXXX,
    @SerializedName("views")
    val views: String,
    @SerializedName("width")
    val width: String
)