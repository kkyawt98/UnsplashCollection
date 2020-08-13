package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class Likes(
    @SerializedName("historical")
    val historical: HistoricalX,
    @SerializedName("total")
    val total: Int
)