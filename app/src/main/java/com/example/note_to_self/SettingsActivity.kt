package com.example.note_to_self

import android.content.Context
import android.os.Bundle
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {
    private var showDividers: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val switch1 = findViewById<Switch>(R.id.switch1)
        val prefs = getSharedPreferences("Note to self", MODE_PRIVATE)

        showDividers = prefs.getBoolean("dividers", true)

        switch1.isChecked = showDividers

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            showDividers = isChecked
        }


    }

    override fun onPause() {
        super.onPause()

        val prefs = getSharedPreferences("Note to self", Context.MODE_PRIVATE)
        val editor = prefs.edit()

        editor.putBoolean("dividers", showDividers)
        editor.apply()

    }
}