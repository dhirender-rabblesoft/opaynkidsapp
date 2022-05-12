package com.app.opaynkidsapp.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.viewmodel.MatchQAViewModel

class MatchQAActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityMatchQaactivityBinding
    lateinit var viewModel: MatchQAViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_qaactivity)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_qaactivity)
        viewModel = ViewModelProvider(this).get(MatchQAViewModel::class.java)
        viewModel.setBinder(binding, this)
    }
}