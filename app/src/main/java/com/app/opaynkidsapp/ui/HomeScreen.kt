package com.app.opaynkidsapp.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityHomeScreenBinding
import com.app.opaynkidsapp.utils.TrackContent
import com.app.opaynkidsapp.viewmodel.HomeScreenViewModel

class HomeScreen : KotlinBaseActivity() {
    lateinit var binding: ActivityHomeScreenBinding
    lateinit var viewModel: HomeScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)
        TrackContent.HOME.customToString()
        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)
        viewModel.setBinder(binding, this)
    }

    companion object
    {

        var packagecolorlist=ArrayList<String>()
        var packagesubcolorlist=ArrayList<String>()

    }
}