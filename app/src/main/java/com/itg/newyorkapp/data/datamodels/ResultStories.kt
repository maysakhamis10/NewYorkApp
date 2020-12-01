package com.example.newyorktimes.data.datamodels

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "top_stories")
data class ResultStories(



    @PrimaryKey val uid: Int,


    @SerializedName("abstract")
    @ColumnInfo(name = "abstract") val `abstract`: String,


    @SerializedName("byline")
    @ColumnInfo(name = "byline")  val byline: String,


    @SerializedName("created_date")
    @ColumnInfo(name = "created_date") val created_date: String,


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
    @ColumnInfo(name = "published_date") val published_date: String,

    @SerializedName("section")
    @ColumnInfo(name = "section") val section: String,

    @SerializedName("short_url")
    @ColumnInfo(name = "short_url")  val short_url: String,

    @SerializedName("subsection")
    @ColumnInfo(name = "subsection") val subsection: String,

    @SerializedName("title")
    @ColumnInfo(name = "title")  val title: String,

    @SerializedName("updated_date")
    @ColumnInfo(name = "updated_date") val updated_date: String,

    @SerializedName("uri")
    @ColumnInfo(name = "uri") val uri: String,

    @SerializedName("url")
    @ColumnInfo(name = "url") val url: String
)