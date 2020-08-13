package com.kyawt.mycollection.service.model.photo


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sponsorship(
    @SerializedName("impression_urls")
    val impressionUrls: List<String>,
    @SerializedName("sponsor")
    val sponsor: Sponsor,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("tagline_url")
    val taglineUrl: String
):Parcelable