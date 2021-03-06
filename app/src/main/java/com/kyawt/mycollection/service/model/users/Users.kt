package com.kyawt.mycollection.service.model.users


import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean,
    @SerializedName("allow_messages")
    val allowMessages: Boolean,
    @SerializedName("badge")
    val badge: Badge,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("followed_by_user")
    val followedByUser: Boolean,
    @SerializedName("followers_count")
    val followersCount: String,
    @SerializedName("following_count")
    val followingCount: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("instagram_username")
    val instagramUsername: String,
    @SerializedName("last_name")
    val lastName: Any,
    @SerializedName("links")
    val links: Links,
    @SerializedName("location")
    val location: String,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("name")
    val name: String,
    @SerializedName("numeric_id")
    val numericId: Int,
    @SerializedName("photos")
    val photos: List<Photo>,
    @SerializedName("portfolio_url")
    val portfolioUrl: String,
    @SerializedName("profile_image")
    val profileImage: ProfileImage,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("total_collections")
    val totalCollections: String,
    @SerializedName("total_likes")
    val totalLikes: String,
    @SerializedName("total_photos")
    val totalPhotos: String,
    @SerializedName("twitter_username")
    val twitterUsername: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("username")
    val username: String
)