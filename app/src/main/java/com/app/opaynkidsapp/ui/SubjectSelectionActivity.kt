package com.app.opaynkidsapp.ui

 import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivitySubjectSelectionBinding
import com.app.opaynkidsapp.viewmodel.SubjectSelectionViewModel

class SubjectSelectionActivity : KotlinBaseActivity() {
    lateinit var binding:ActivitySubjectSelectionBinding
    lateinit var viewModel :SubjectSelectionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject_selection)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_subject_selection)
        viewModel = ViewModelProvider(this).get(SubjectSelectionViewModel::class.java)
        viewModel.setBinder(binding,this)
    }
}