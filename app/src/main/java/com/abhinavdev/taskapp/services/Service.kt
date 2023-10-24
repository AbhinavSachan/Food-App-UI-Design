package com.abhinavdev.taskapp.services

import com.abhinavdev.taskapp.models.Result
import com.abhinavdev.taskapp.utils.API
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET(API.GET_VENDORS)
    fun getData(): Call<Result>
}