package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMcqactivityBinding
import com.app.opaynkidsapp.viewmodel.MCQViewModel
import kotlinx.android.synthetic.main.activity_otpverify.*

class MCQActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityMcqactivityBinding
    lateinit var viewModel:MCQViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mcqactivity)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mcqactivity)
        viewModel = ViewModelProvider(this).get(MCQViewModel::class.java)
        viewModel.setBinder(binding,this)
    }
}