package com.kyawt.mycollection.service.model.users


import com.google.gson.annotations.SerializedName

data class Tags(
    @SerializedName("aggregated")
    val aggregated: List<Aggregated>,
    @SerializedName("custom")
    val custom: List<Custom>
)