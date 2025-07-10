package com.cofounder.e.petvet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val signUpBtn = findViewById<TextView>(R.id.tvSignupLink)
        val loginBtn = findViewById<Button>(R.id.btnLogin)

        signUpBtn.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }
}
