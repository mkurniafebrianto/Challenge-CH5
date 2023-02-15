package com.example.gamesuit.splashpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.example.gamesuit.databinding.ActivitySplashScreenBinding
import com.example.gamesuit.landingpage.LandingPageActivity

class SplashScreenActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").centerCrop()
            .into(binding.ivSplashScreen1)

        Handler().postDelayed({
            val intent = Intent(this, LandingPageActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}