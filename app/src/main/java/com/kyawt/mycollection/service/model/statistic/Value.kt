package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class Value(
    @SerializedName("date")
    val date: String,
    @SerializedName("value")
    val value: Int
)