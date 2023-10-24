package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Area(
    @SerializedName("vendor_area_id")
    val vendorAreaId: String? = null,
    @SerializedName("area_id")
    val areaId: String? = null,
    @SerializedName("name_en")
    val nameEn: String? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null
): Serializable