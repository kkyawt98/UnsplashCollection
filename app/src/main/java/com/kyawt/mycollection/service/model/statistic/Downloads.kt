package com.kyawt.mycollection.service.model.statistic


import com.google.gson.annotations.SerializedName

data class Downloads(
    @SerializedName("historical")
    val historical: Historical,
    @SerializedName("total")
    val total: Int
)