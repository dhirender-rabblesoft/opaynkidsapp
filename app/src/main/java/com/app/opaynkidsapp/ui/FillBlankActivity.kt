package com.app.opaynkidsapp.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityFillBlankBinding
import com.app.opaynkidsapp.viewmodel.FillBlankTestViewModel

class FillBlankActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityFillBlankBinding
    lateinit var viewModel: FillBlankTestViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fill_blank)
        viewModel = ViewModelProvider(this).get(FillBlankTestViewModel::class.java)
        viewModel.setBinder(binding, this)
    }
}