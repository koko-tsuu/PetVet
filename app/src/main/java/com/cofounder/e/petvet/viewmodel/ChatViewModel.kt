package com.cofounder.e.petvet.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.cofounder.e.petvet.network.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.cofounder.e.petvet.BuildConfig
import com.cofounder.e.petvet.model.GeminiRequest
import com.cofounder.e.petvet.model.GeminiResponse
import com.cofounder.e.petvet.model.ChatContent
import com.cofounder.e.petvet.model.Part

data class ChatMessage(val text: String, val isUser: Boolean)

class ChatViewModel : ViewModel() {

    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages = _messages.asStateFlow()
    val apiKey = BuildConfig.GEMINI_API_KEY
    var input = mutableStateOf(TextFieldValue(""))

    fun sendMessage() {
        val userText = input.value.text.trim()
        if (userText.isBlank()) return

        // Add user's message to UI
        _messages.value += ChatMessage(userText, true)

        // Clear input field
        input.value = TextFieldValue("")

        // Construct Gemini request
        val userMessage = ChatContent(
            role = "user",
            parts = listOf(Part(text = userText))
        )
        val request = GeminiRequest(contents = listOf(userMessage))

        // Send to Gemini
        GeminiClient.api.sendMessage(apiKey, request)
            .enqueue(object : Callback<GeminiResponse> {
                override fun onResponse(
                    call: Call<GeminiResponse>,
                    response: Response<GeminiResponse>
                ) {
                    val reply = response.body()
                        ?.candidates?.firstOrNull()
                        ?.content?.parts?.firstOrNull()?.text
                        ?: "Hmm... I didn’t quite get that!"

                    _messages.value += ChatMessage(reply, false)
                }

                override fun onFailure(call: Call<GeminiResponse>, t: Throwable) {
                    _messages.value += ChatMessage("Error: ${t.message}", false)
                }
            })
    }
}
