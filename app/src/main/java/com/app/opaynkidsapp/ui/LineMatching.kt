package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityLineMatchingBinding
import com.app.opaynkidsapp.utils.TrackContent
import com.app.opaynkidsapp.viewmodel.LineMatchViewModel
import com.app.opaynkidsapp.viewmodel.LoginSignViewModel

class LineMatching : KotlinBaseActivity() {
    lateinit var binding:ActivityLineMatchingBinding
    lateinit var viewModel:LineMatchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_matching)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_line_matching)
         viewModel = ViewModelProvider(this).get(LineMatchViewModel::class.java)
        viewModel.setBinder(binding, this)
    }
}