package com.cofounder.e.petvet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cofounder.e.petvet.ui.theme.PetVetTheme
import android.content.Intent
import android.widget.Button
import androidx.compose.material3.Button
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Column


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_start)

        val getStartedButton = findViewById<Button>(R.id.button)
        getStartedButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    /*    setContent {
            PetVetTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        */

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        Text(text = "Hello $name!")

        Button(onClick = {
            val intent = Intent(context, DrPurr::class.java)
            context.startActivity(intent)
        }) {
            Text("DrPurr")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetVetTheme {
        Greeting("Android")
    }
}