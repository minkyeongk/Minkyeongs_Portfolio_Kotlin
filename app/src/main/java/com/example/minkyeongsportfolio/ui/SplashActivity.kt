package com.example.minkyeongsportfolio.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import android.util.Pair
import com.example.minkyeongsportfolio.R
import kotlinx.android.synthetic.main.activity_main.*

class SplashActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        val action = supportActionBar
        action?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)

            var options : ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    this,
                    Pair.create(profile_img, "profile")
            )
            startActivity(intent, options.toBundle())}, 2500)
    }

    override fun onStop() {
        super.onStop()
        finish()
    }
}
