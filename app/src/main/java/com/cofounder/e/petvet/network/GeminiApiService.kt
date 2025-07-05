package com.cofounder.e.petvet.network

import com.cofounder.e.petvet.model.GeminiRequest
import com.cofounder.e.petvet.model.GeminiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface GeminiApiService {
    @POST("v1beta/models/gemini-2.5-flash:generateContent")
    fun sendMessage(
        @Query("key") apiKey: String,
        @Body request: GeminiRequest
    ): Call<GeminiResponse>

}