package com.example.api_parsing_and_pagination.model

/**
 * Created by Ratna Srivastava on 30-11-2024.
 */
data class APIResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)