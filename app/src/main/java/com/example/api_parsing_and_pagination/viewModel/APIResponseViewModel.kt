package com.example.api_parsing_and_pagination.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_parsing_and_pagination.model.APIRepository
import com.example.api_parsing_and_pagination.model.APIResponse
import com.example.api_parsing_and_pagination.network.data_url
import kotlinx.coroutines.launch

/**
 * Created by Ratna Srivastava on 02-12-2024.
 */
class APIResponseViewModel: ViewModel() {
    private val apiResponseRepository = APIRepository()
    private val _apiResponse = MutableLiveData<List<APIResponse>>()
    val apiResponse: LiveData<List<APIResponse>> get() = _apiResponse

    fun fetchResponse() {
        viewModelScope.launch {
            val data = apiResponseRepository.getPaginatedData(data_url, 10)
            _apiResponse.value = data
        }
    }
}