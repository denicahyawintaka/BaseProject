package com.example.baseproject.presentation.main

import androidx.lifecycle.MutableLiveData
import com.example.baseproject.data.entity.ProvinsiResponse
import com.example.baseproject.data.repository.ProvinsiRepository
import com.example.baseproject.presentation.base.BaseViewModel
import com.example.baseproject.utils.UseCaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainfragmentViewModel(private val provinsiRepository: ProvinsiRepository) : BaseViewModel() {


    val showLoading = MutableLiveData<Boolean>()
    val provinsi = MutableLiveData<List<String>>()
    val showError = MutableLiveData<String>()
    val listProvinsi: MutableList<String> = mutableListOf()

    init {
        // Load cats when this ViewModel is instantiated.
        loadProvinsi()
    }

    fun loadProvinsi() {
        showLoading.value = true
        launch {
            val result = withContext(Dispatchers.IO) { provinsiRepository.getProvinsi() }
            showLoading.value = false
            when (result) {
                is UseCaseResult.Success -> {
                    result.data.semuaprovinsi.map {
                        listProvinsi.add(it.nama)
                    }
                    provinsi.value  = listProvinsi
                }
                is UseCaseResult.Error -> showError.value = result.exception.message
            }
        }
    }

}
