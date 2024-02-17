package com.spinwheel.io

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import java.util.Random
import kotlin.math.ceil

class SpinWheel {
    fun startSpinning(context: SpinStatus, spinWheel: ImageView, prizeArray: Array<Int>, spinDurationInMilliSec: Long) {
        val random = Random()
        var spinCount = 0
        val maxSpinCount = 1 // Change the number of spins as per your requirement
        val wheelInParts = 360 / prizeArray.size
        val startRotation = spinWheel.rotation % 360
        val endRotation = startRotation + (360 * (maxSpinCount + 1) + random.nextInt(360))

        val animator = ValueAnimator.ofFloat(startRotation, endRotation)
        animator.apply {
            duration = spinDurationInMilliSec
            interpolator = DecelerateInterpolator()
            addUpdateListener { valueAnimator ->
                spinWheel.rotation = valueAnimator.animatedValue as Float
            }
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator) {
                    context.onSpinStart()
                }

                override fun onAnimationEnd(p0: Animator) {
                    // When the spin wheel animation ends:
                    spinCount++
                    // Show the final result after all the spins
                    var floatGetRotation = prizeArray.size - (spinWheel.rotation % 360) / wheelInParts
                    floatGetRotation = ceil(floatGetRotation.toDouble()).toFloat()
                    val prize = prizeArray[floatGetRotation.toInt() - 1]
                    context.onSpinComplete(prize, floatGetRotation.toInt())
                }

                override fun onAnimationCancel(p0: Animator) {}
                override fun onAnimationRepeat(p0: Animator) {}
            })
        }
        animator.start()
    }

    interface SpinStatus {
        fun onSpinStart()
        fun onSpinComplete(prize: Int, spinBlockNumber: Int)
    }
}