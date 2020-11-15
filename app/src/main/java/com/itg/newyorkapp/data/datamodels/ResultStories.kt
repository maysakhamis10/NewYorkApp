package com.example.newyorktimes.data.datamodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResultStories(

    @SerializedName("abstract")
    val `abstract`: String,


    @SerializedName("byline")
    val byline: String,


    @SerializedName("created_date")
    val created_date: String,


    @SerializedName("des_facet")
    val des_facet: List<String>,

    @SerializedName("geo_facet")
    val geo_facet: List<String>,

    @SerializedName("item_type")
    val item_type: String,

    @SerializedName("kicker")
    val kicker: String,

    @SerializedName("material_type_facet")
    val material_type_facet: String,

    @SerializedName("multimedia")
    val multimedia: List<Multimedia>,

    @SerializedName("org_facet")
    val org_facet: List<String>,


    @SerializedName("per_facet")
    val per_facet: List<String>,

    @SerializedName("published_date")
    val published_date: String,

    @SerializedName("section")
    val section: String,

    @SerializedName("short_url")
    val short_url: String,

    @SerializedName("subsection")
    val subsection: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("updated_date")
    val updated_date: String,

    @SerializedName("uri")
    val uri: String,

    @SerializedName("url")
    val url: String
)