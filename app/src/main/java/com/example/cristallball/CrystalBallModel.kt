package com.example.cristallball

import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.cristallball.databinding.ActivityMainBinding
import kotlin.math.ceil

class CrystalBallModel(context: Context) {

    private val cristalBallController: CrystalBallController = CrystalBallController(context)
    private var timer: CountDownTimer? = null
    private val waitingProcessList = mutableListOf(
        WaitingTime.PREDICTING_THE_FUTURE.getProcess(),
        WaitingTime.GOING_TO_THE_GADALKA.getProcess(),
        WaitingTime.ASKING_THE_SPIRITS.getProcess(),
        WaitingTime.LISTENING_TO_THE_STARS.getProcess(),
        WaitingTime.GET_AN_ANSWER.getProcess()
    )

    fun startCountDownTimer(timeMillis: Long, binding:ActivityMainBinding) {
        timer?.cancel()

        var processIndex = 0

        timer = object : CountDownTimer(timeMillis, 1000) {
            override fun onTick(timeM: Long) {
                binding.tvTimer.text = ceil(timeM/ 1000.0).toInt().toString()
                if (processIndex < waitingProcessList.size) {
                    binding.predView.text = waitingProcessList.get(processIndex)
                    processIndex++
                }
            }

            override fun onFinish() {
                binding.tvTimer.text = WaitingTime.ZERO.getProcess()
                val handler = Handler(Looper.getMainLooper())
                handler.postDelayed({
                    binding.tvTimer.visibility = View.INVISIBLE
                    binding.predView.text = cristalBallController.getRetosh()
                }, 1000L)
                handler.postDelayed({
                    binding.Bask.visibility = View.VISIBLE
                    binding.predView.text = WaitingTime.ASKING.getProcess()
                }, 2500L)
            }

        }.start()
    }
}