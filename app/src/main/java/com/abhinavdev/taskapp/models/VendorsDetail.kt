package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VendorsDetail(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("vendor_policy")
    val vendorPolicy: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("delivery_time")
    val deliveryTime: String? = null,
    @SerializedName("service_charges")
    val serviceCharges: String? = null,
    @SerializedName("area")
    val area: String? = null,
    @SerializedName("logo")
    val logo: String? = null,
    @SerializedName("min_order_amount")
    val minOrderAmount: String? = null,
    @SerializedName("destination_id")
    val destinationId: String? = null,
    @SerializedName("avg_rating")
    val avgRating: String? = null,
    @SerializedName("total_ratings")
    val totalRatings: String? = null,
    @SerializedName("is_busy")
    val isBusy: String? = null,
    @SerializedName("start_time")
    val startTime: String? = null,
    @SerializedName("end_time")
    val endTime: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("banner")
    val banner: String? = null,
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("vendor_categories")
    val vendorCategories: List<String?>? = null,
    @SerializedName("working_day")
    val workingDay: String? = null,
    @SerializedName("is_24")
    val is24: String? = null,
    @SerializedName("is_open")
    val isOpen: Int? = null,
    @SerializedName("areas")
    val areas: List<Area?>? = null
): Serializable