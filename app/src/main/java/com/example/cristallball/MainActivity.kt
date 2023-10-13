package com.example.cristallball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cristallball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model = CrystalBallModel(this)
    private val controller = CrystalBallController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Bask.setOnClickListener {
            binding.Bask.visibility = View.INVISIBLE
            binding.tvTimer.visibility = View.VISIBLE
            model.startCountDownTimer(5000, binding)
            binding.predView.text = controller.getRetosh()
        }
    }
}