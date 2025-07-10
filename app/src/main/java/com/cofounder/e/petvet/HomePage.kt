package com.cofounder.e.petvet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val btnDrPurr = findViewById<Button>(R.id.btnDrPurr)
        btnDrPurr.setOnClickListener {
            val intent = Intent(this, DrPurr::class.java)
            startActivity(intent)
        }
    }
}
