package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class Views(
    @SerializedName("historical")
    val historical: HistoricalXX,
    @SerializedName("total")
    val total: Int
)