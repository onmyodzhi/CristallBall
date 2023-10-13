package com.example.cristallball



import android.content.Context

class CrystalBallController(private val context: Context) {
    fun getRetosh(): String {
        return context.resources.getStringArray(R.array.retosh)[randomNumber()]
    }

    private fun randomNumber(): Int {
        val size = context.resources.getStringArray(R.array.retosh).size - 1
        return (0..size).random()
    }
}