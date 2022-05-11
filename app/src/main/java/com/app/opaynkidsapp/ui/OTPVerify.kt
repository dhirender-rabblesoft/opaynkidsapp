package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityOtpverifyBinding
import com.app.opaynkidsapp.utils.TrackContent
import com.app.opaynkidsapp.viewmodel.OtpVerifyViewModel

class OTPVerify : KotlinBaseActivity() {


    lateinit var  binding:ActivityOtpverifyBinding
    lateinit var viewModel: OtpVerifyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otpverify)
        TrackContent.OTPVERFICATION.customToString()
        viewModel = ViewModelProvider(this).get(OtpVerifyViewModel::class.java)
        viewModel.setBinder(binding,this)
    }
}