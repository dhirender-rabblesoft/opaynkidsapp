package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.databinding.ActivityCongratulationScreenBinding
import com.app.opaynkidsapp.databinding.ActivityGenderSelectionBinding
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.visible

class GenderSelectionActivity : AppCompatActivity() {
    lateinit var binding:ActivityGenderSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_gender_selection)
        setClick()

    }
    private fun setClick(){

        binding.clboycontainer.setOnClickListener {
            binding.rvGirltick.gone()
            binding.rvboytick.visible()
        }
        binding.clgirlcontainer.setOnClickListener {
            binding.rvGirltick.visible()
            binding.rvboytick.gone()
        }

    }
}