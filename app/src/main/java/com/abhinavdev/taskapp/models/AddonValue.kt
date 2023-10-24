package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AddonValue(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("discount_price")
    val discountPrice: Int? = null
):Serializable