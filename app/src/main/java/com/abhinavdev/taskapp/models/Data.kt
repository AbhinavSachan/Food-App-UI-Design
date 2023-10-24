package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Data(
    @SerializedName("Vendors_detail")
    val vendorsDetail: VendorsDetail? = null,
    @SerializedName("Reviews")
    val reviews: List<Review>? = null,
    @SerializedName("Vendors_items")
    val vendorsItems: List<VendorsItem>? = null,
    @SerializedName("User_loyalty_points")
    val userLoyaltyPoints: Int? = null
): Serializable