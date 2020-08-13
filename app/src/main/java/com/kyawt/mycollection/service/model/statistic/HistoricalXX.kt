package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class HistoricalXX(
    @SerializedName("change")
    val change: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("resolution")
    val resolution: String,
    @SerializedName("values")
    val values: List<ValueXX>
)