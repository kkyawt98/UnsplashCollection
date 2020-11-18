package com.kyawt.mycollection.service.model.usersCollections


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoverPhotoX(
    @SerializedName("alt_description")
    val altDescription: String,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("color")
    val color: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("current_user_collections")
    val currentUserCollections: List<String>,
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
    val links: LinksXXX,
    @SerializedName("promoted_at")
    val promotedAt: String,
    @SerializedName("sponsorship")
    val sponsorship: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("urls")
    val urls: UrlsXX,
    @SerializedName("user")
    val user: UserX,
    @SerializedName("width")
    val width: Int
):Parcelable