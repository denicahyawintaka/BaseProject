package com.example.baseproject.data.entity


import com.google.gson.annotations.SerializedName

data class ProvinsiResponse(
    var error: Boolean,
    var message: String,
    var semuaprovinsi: List<Semuaprovinsi>
)