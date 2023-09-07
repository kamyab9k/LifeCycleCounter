package com.example.lifecyclecounter

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import com.example.lifecyclecounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var onStartCounter = 0
    var onCreateCounter = 0
    var onResumeCounter = 0
    var onRestartCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Log.i(TAG, "onCreate")



        onCreateCounter++
        binding.onCreateCounter.text = onCreateCounter.toString()

        binding.transitionButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "onStart")
        onStartCounter++
        binding.onStartCounter.text = onStartCounter.toString()

    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "onResume")
        onResumeCounter++
        binding.onResumeCounter.text = onResumeCounter.toString()

    }


    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "onRestart")
        onRestartCounter++
        binding.onRestartCounter.text = onRestartCounter.toString()

    }

}