package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class ValueX(
    @SerializedName("date")
    val date: String,
    @SerializedName("value")
    val value: Int
)