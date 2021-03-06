package com.kyawt.mycollection.service.model.detail


import com.google.gson.annotations.SerializedName

data class CoverPhotoXX(
    @SerializedName("alt_description")
    val altDescription: Any,
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
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("liked_by_user")
    val likedByUser: Boolean,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("links")
    val links: LinksXXXXXXX,
    @SerializedName("promoted_at")
    val promotedAt: String,
    @SerializedName("sponsorship")
    val sponsorship: Any,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: UrlsXXX,
    @SerializedName("user")
    val user: UserXXX,
    @SerializedName("width")
    val width: Int
)