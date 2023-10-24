package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Review(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("comment")
    val comment: String? = null,
    @SerializedName("rating")
    val rating: Int? = null
): Serializable