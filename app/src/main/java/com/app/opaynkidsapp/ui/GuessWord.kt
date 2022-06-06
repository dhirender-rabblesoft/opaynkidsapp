package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.opaynkidsapp.GuessWordAdapter
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.applications.KidsApplication
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.model.ModelClass
import com.app.opaynkidsapp.repository.CommonRepository
import com.app.opaynkidsapp.utils.Keys
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_guess_word.*
import kotlinx.android.synthetic.main.common_toolbar.view.*

class GuessWord : KotlinBaseActivity() {
     var commonRepository: CommonRepository?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_word)
        commonRepository= CommonRepository(KidsApplication.myApp!!)
        setAdapter()
        setToolbar()
    }
    private  fun  callapi()
    {
        commonRepository?.fillup(this, Keys.FILLUP)
        {

        }
    }
    private  fun setToolbar()
    {
        header.ivback.visible()
        header.icmenu2.gone()
        header.ivback.setOnClickListener {
            onBackPressed()
        }
    }
    private  fun setAdapter()
    {
        val  adapter=GuessWordAdapter(this){

        }
        rvlist.adapter=adapter

    }
}