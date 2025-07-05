package com.cofounder.e.petvet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cofounder.e.petvet.ui.screens.ChatScreen
import com.cofounder.e.petvet.ui.theme.PetVetTheme

class DrPurr : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetVetTheme {
                ChatScreen()
            }
        }
    }
}
