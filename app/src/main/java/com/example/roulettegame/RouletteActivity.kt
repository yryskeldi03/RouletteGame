package com.example.roulettegame

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

private const val FACTOR = 4.736842105263158f

class RouletteActivity : AppCompatActivity() {
    private lateinit var tvScore: TextView
    private lateinit var btnSpin: Button
    private lateinit var roulette: ImageView
    private val random: Random = Random()
    private var degree = 0
    private var degreeOld = 0
    private var text = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette)
        initViews()

        btnSpin.setOnClickListener {
            spin()
        }

    }

    private fun spin() {
        degreeOld = degree % 360
        degree = random.nextInt(360) + 720
        val rotate = RotateAnimation(
            degreeOld.toFloat(),
            degree.toFloat(),
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = 3600
        rotate.fillAfter = true
        rotate.interpolator = DecelerateInterpolator()
        tvScore.text = getString(R.string.score, App.score.toString())
        rotate.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                currentNumber(360f - (degree.toFloat() % 360f))
                tvScore.text = getString(R.string.score, App.score.toString())
                Toast.makeText(this@RouletteActivity, text.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })
        roulette.startAnimation(rotate)
    }

    private fun currentNumber(degrees: Float): Int {
        if (degrees >= (FACTOR * 1f) && degrees < (FACTOR * 3f)) {
            text = 3
        } else if (degrees >= (FACTOR * 3f) && degrees < (FACTOR * 5f)) {
            text = 26
        } else if (degrees >= (FACTOR * 5f) && degrees < (FACTOR * 7f)) {
            text = 0
        } else if (degrees >= (FACTOR * 7f) && degrees < (FACTOR * 9f)) {
            text = 32
        } else if (degrees >= (FACTOR * 9f) && degrees < (FACTOR * 11f)) {
            text = 15
        } else if (degrees >= (FACTOR * 11f) && degrees < (FACTOR * 13f)) {
            text = 19
        } else if (degrees >= (FACTOR * 13f) && degrees < (FACTOR * 15f)) {
            text = 4
        } else if (degrees >= (FACTOR * 15f) && degrees < (FACTOR * 17f)) {
            text = 21
        } else if (degrees >= (FACTOR * 17f) && degrees < (FACTOR * 19f)) {
            text = 2
        } else if (degrees >= (FACTOR * 19f) && degrees < (FACTOR * 21f)) {
            text = 25
        } else if (degrees >= (FACTOR * 21f) && degrees < (FACTOR * 23f)) {
            text = 17
        } else if (degrees >= (FACTOR * 23f) && degrees < (FACTOR * 25f)) {
            text = 34
        } else if (degrees >= (FACTOR * 25f) && degrees < (FACTOR * 27f)) {
            text = 6
        } else if (degrees >= (FACTOR * 27f) && degrees < (FACTOR * 29f)) {
            text = 27
        } else if (degrees >= (FACTOR * 29f) && degrees < (FACTOR * 31f)) {
            text = 13
        } else if (degrees >= (FACTOR * 31f) && degrees < (FACTOR * 33f)) {
            text = 36
        } else if (degrees >= (FACTOR * 33f) && degrees < (FACTOR * 35f)) {
            text = 11
        } else if (degrees >= (FACTOR * 35f) && degrees < (FACTOR * 37f)) {
            text = 30
        } else if (degrees >= (FACTOR * 37f) && degrees < (FACTOR * 39f)) {
            text = 8
        } else if (degrees >= (FACTOR * 39f) && degrees < (FACTOR * 41f)) {
            text = 23
        } else if (degrees >= (FACTOR * 41f) && degrees < (FACTOR * 43f)) {
            text = 10
        } else if (degrees >= (FACTOR * 43f) && degrees < (FACTOR * 45f)) {
            text = 5
        } else if (degrees >= (FACTOR * 45f) && degrees < (FACTOR * 47f)) {
            text = 24
        } else if (degrees >= (FACTOR * 47f) && degrees < (FACTOR * 49f)) {
            text = 16
        } else if (degrees >= (FACTOR * 49f) && degrees < (FACTOR * 51f)) {
            text = 33
        } else if (degrees >= (FACTOR * 51f) && degrees < (FACTOR * 53f)) {
            text = 1
        } else if (degrees >= (FACTOR * 53f) && degrees < (FACTOR * 55f)) {
            text = 20
        } else if (degrees >= (FACTOR * 55f) && degrees < (FACTOR * 57f)) {
            text = 14
        } else if (degrees >= (FACTOR * 57f) && degrees < (FACTOR * 59f)) {
            text = 31
        } else if (degrees >= (FACTOR * 59f) && degrees < (FACTOR * 61f)) {
            text = 9
        } else if (degrees >= (FACTOR * 61f) && degrees < (FACTOR * 63f)) {
            text = 22
        } else if (degrees >= (FACTOR * 63f) && degrees < (FACTOR * 65f)) {
            text = 5
        } else if (degrees >= (FACTOR * 65f) && degrees < (FACTOR * 67f)) {
            text = 18
        } else if (degrees >= (FACTOR * 67f) && degrees < (FACTOR * 69f)) {
            text = 29
        } else if (degrees >= (FACTOR * 69f) && degrees < (FACTOR * 71f)) {
            text = 7
        } else if (degrees >= (FACTOR * 71f) && degrees < (FACTOR * 73f)) {
            text = 28
        } else if (degrees >= (FACTOR * 73f) && degrees < (FACTOR * 75f)) {
            text = 12
        } else if (degrees >= (FACTOR * 75f) && degrees < (FACTOR * 77f)) {
            text = 35
        }else if (degrees >= (FACTOR * 77f) && degrees < (FACTOR * 79f)) {
            text = 0
        }
        App.score += text
        return text
    }

    private fun initViews() {
        tvScore = findViewById(R.id.tv_score)
        btnSpin = findViewById(R.id.btn_spin)
        roulette = findViewById(R.id.iv_roulette_wheel)
    }

    override fun onResume() {
        super.onResume()
        tvScore.text = getString(R.string.score, App.score.toString())
    }
}