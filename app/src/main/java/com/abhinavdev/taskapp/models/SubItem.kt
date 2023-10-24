package com.abhinavdev.taskapp.models


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SubItem(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("minimum")
    val minimum: Int? = null,
    @SerializedName("maximum")
    val maximum: Int? = null,
    @SerializedName("addon_values")
    val addonValues: List<AddonValue?>? = null
): Serializable