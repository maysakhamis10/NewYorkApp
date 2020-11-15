package com.example.newyorktimes.data.datamodels

import com.google.gson.annotations.SerializedName

data class TopStoriesModel(
    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("last_updated")
    val last_updated: String,

    @SerializedName("num_results")
    val num_results: Int,

    @SerializedName("results")
    val results: ArrayList<ResultStories>,

    @SerializedName("section")
    val section: String,

    @SerializedName("status")
    val status: String
)