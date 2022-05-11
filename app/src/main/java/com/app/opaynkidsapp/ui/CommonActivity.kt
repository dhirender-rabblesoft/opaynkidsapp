package com.app.opaynkidsapp.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityCommonBinding
import com.app.opaynkidsapp.utils.Keys

class CommonActivity : KotlinBaseActivity(R.id.container) {
    lateinit var binding: ActivityCommonBinding

    var getbundle = Bundle()
    var keyword = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_common)

        getbundle = intent.extras!!
        keyword = getbundle.getString(Keys.FROM).toString()


    }




}