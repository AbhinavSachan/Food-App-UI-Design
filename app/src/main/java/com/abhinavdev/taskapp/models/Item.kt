package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("icon")
    val icon: String? = null,
    @SerializedName("vendor_id")
    val vendorId: String? = null,
    @SerializedName("regular_price")
    val regularPrice: Double? = null,
    @SerializedName("service_price")
    val servicePrice: Double? = null,
    @SerializedName("service_discount_price")
    val serviceDiscountPrice: Double? = null,
    @SerializedName("duration")
    val duration: String? = null,
    @SerializedName("is_product")
    val isProduct: Int? = null,
    @SerializedName("is_busy")
    val isBusy: Int? = null,
    @SerializedName("sub_item")
    val subItem: List<SubItem?>? = null,
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("working_days")
    val workingDays: List<WorkingDay?>? = null
): Serializable