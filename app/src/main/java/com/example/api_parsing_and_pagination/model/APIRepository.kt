package com.example.api_parsing_and_pagination.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

/**
 * Created by Ratna Srivastava on 02-12-2024.
 */
class APIRepository {
    suspend fun getPaginatedData(apiUrl: String, limit: Int): List<APIResponse> {
        return withContext(Dispatchers.IO) {
            val gson = Gson()
            val results = mutableListOf<APIResponse>()
            var currentPage = 1
            while(true) {
                val urlWithParams = "$apiUrl?_page=$currentPage&_limit=$limit"
                try {
                    val responseText = URL(urlWithParams).readText()
                    // Parse the JSON response to data class
                    val apiResponse = object : TypeToken<List<APIResponse>>() {}.type
                    val apiData: List<APIResponse> = gson.fromJson(responseText, apiResponse)
                    results.addAll(apiData)
                    if (apiData.isEmpty()) {
                        break
                    }
                    currentPage++
                } catch (Exception: Exception) {
                    println("Error: $Exception")
                    break
                }
            }
            results
        }
    }
}
