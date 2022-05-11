package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityLearnBinding
import com.app.opaynkidsapp.viewmodel.LearnViewModel
import kotlinx.android.synthetic.main.activity_otpverify.*

class LearnActivity : KotlinBaseActivity() {
    lateinit var binding:ActivityLearnBinding
    lateinit var viewModel:LearnViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_learn)
        viewModel = ViewModelProvider(this).get(LearnViewModel::class.java)
        viewModel.setBinder(binding,this)
    }
}