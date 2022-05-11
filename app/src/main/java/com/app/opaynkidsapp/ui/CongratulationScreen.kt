package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityCongratulationScreenBinding

class CongratulationScreen : KotlinBaseActivity() {
    lateinit var binding: ActivityCongratulationScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_congratulation_screen)
        setClick()

    }

    private fun setClick() {
        binding.btAddchild.setOnClickListener {
            openA(GenderSelectionActivity::class)
        }
    }

}