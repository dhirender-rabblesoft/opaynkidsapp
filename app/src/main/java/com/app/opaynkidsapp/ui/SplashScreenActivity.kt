package com.app.opaynkidsapp.ui

 import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity

class SplashScreenActivity : KotlinBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            openA(HomeScreen::class)

        }, 1000)
    }
}