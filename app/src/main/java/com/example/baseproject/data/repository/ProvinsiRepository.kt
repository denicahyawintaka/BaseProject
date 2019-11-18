package com.example.baseproject.data.repository

import com.example.baseproject.data.ApiInterface
import com.example.baseproject.data.entity.ProvinsiResponse
import com.example.baseproject.utils.UseCaseResult



interface ProvinsiRepository {
    suspend fun getProvinsi(): UseCaseResult<ProvinsiResponse>
}

class ProvinsiRepositoryImpl(private val apiInterface: ApiInterface) : ProvinsiRepository {
    override suspend fun getProvinsi(): UseCaseResult<ProvinsiResponse> {
        return try {
            val result = apiInterface.getProvinsi().await()
            UseCaseResult.Success(result)
        } catch (ex: Exception) {
            UseCaseResult.Error(ex)
        }
    }
}