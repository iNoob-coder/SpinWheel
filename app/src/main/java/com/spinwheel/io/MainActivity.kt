package com.spinwheel.io

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.spinwheel.io.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SpinWheel.SpinStatus {

    private lateinit var binding: ActivityMainBinding
    private val prizeArray = arrayOf(5, 1, 8, 2, 10, 3, 5, 4, 10, 5, 2, 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSpin.setOnClickListener {
            SpinWheel().startSpinning(this, binding.spinWheel, prizeArray, 4000)
        }
    }

    override fun onSpinStart() {
        binding.btnSpin.isEnabled = false
    }

    override fun onSpinComplete(prize: Int, spinBlockNumber: Int) {
        binding.btnSpin.isEnabled = true
        Toast.makeText(this, prize.toString(), Toast.LENGTH_SHORT).show()
    }
}