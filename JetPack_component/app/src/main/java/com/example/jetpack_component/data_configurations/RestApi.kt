package com.example.jetpack_component.data_configurations

import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {
    @GET("/walmartproducts/{pageNumber}/{pageSize}")
    fun getProductList(@Path("pageNumber")pageNumber: Int,@Path("pageSize")pageSize: Int)
}