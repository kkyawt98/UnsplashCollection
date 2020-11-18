package com.kyawt.mycollection.service.model.usersCollections


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ancestry(
    @SerializedName("category")
    val category: Category,
    @SerializedName("subcategory")
    val subcategory: Subcategory,
    @SerializedName("type")
    val type: Type
):Parcelable