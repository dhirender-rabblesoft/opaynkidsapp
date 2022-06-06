package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityHomeScreenBinding
import com.app.opaynkidsapp.databinding.ActivityObjectsBinding
import com.app.opaynkidsapp.viewmodel.HomeScreenViewModel
import com.app.opaynkidsapp.viewmodel.ObjectsViewModel

class ObjectsA : KotlinBaseActivity()
{
    lateinit var binding: ActivityObjectsBinding

    lateinit var viewModel: ObjectsViewModel
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_objects)
        viewModel = ViewModelProvider(this).get(ObjectsViewModel::class.java)
        viewModel.setBinder(binding,this)
    }
}