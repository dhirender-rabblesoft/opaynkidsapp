package com.app.opaynkidsapp.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityForgotPasswordBinding
import com.app.opaynkidsapp.utils.TrackContent
import com.app.opaynkidsapp.viewmodel.ForgotViewModel

class ForgotPassword : KotlinBaseActivity() {

    lateinit var binding: ActivityForgotPasswordBinding
    lateinit var viewModel: ForgotViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)
        TrackContent.FORGOTPASSWORD.customToString()
        viewModel = ViewModelProvider(this).get(ForgotViewModel::class.java)
        viewModel.setBinder(binding, this)
    }
}