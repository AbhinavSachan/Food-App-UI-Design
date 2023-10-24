package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VendorsItem(
    @SerializedName("vendor_category_id")
    val vendorCategoryId: Int? = null,
    @SerializedName("vendor_category_name")
    val vendorCategoryName: String? = null,
    @SerializedName("items")
    val items: List<Item>? = null
): Serializable