package com.example.baseproject.data

import com.example.baseproject.data.entity.ProvinsiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiInterface {
    /* Get route used to retrieve cat images, limit is the number of cats item */
    @GET("daerahindonesia/provinsi")
    fun getProvinsi(): Deferred<ProvinsiResponse>

}