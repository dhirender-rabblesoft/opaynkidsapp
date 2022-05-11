package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivitySignupBinding
import com.app.opaynkidsapp.utils.TrackContent
import com.app.opaynkidsapp.viewmodel.SignupViewModel

class Signup : KotlinBaseActivity() {
    lateinit var  binding: ActivitySignupBinding
    lateinit var viewModel: SignupViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        TrackContent.SINGUP.customToString()
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        viewModel.setBinder(binding,this)

    }
}