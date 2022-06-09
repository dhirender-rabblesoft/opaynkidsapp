package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.opaynkidsapp.GuessWordAdapter
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.applications.KidsApplication
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.model.Fillupjson
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

        setToolbar()
        callapi()
    }
    private  fun  callapi()
    {
        var url=""
        if (intent.extras?.getString(Keys.FROM).equals("1"))
        {
            url=Keys.FILLBLANKCATEGORY
        }
        else if (intent.extras?.getString(Keys.FROM).equals("2"))
        {
            url=Keys.MULTICATEGORY
        }
        else{
            url=Keys.MATCHCATEGORY
        }
        commonRepository?.fillup(this,url)
        {
            setAdapter(it.data)
        }
    }
    private  fun setToolbar()
    {
        header.ivback.visible()
        header.icmenu2.gone()
        header.tvtitle.text="Guess the word"
        header.ivback.setOnClickListener {
            onBackPressed()
        }
    }
    private  fun setAdapter(list:ArrayList<Fillupjson.Data>)
    {
        val  adapter=GuessWordAdapter(this){
            if (intent.extras?.getString(Keys.FROM).equals("1"))
            {
                var bundle=Bundle()
                bundle.putString(Keys.POSTID,list[it].id.toString())
                openA(FillBlankActivity::class,bundle)
            }
           else  if (intent.extras?.getString(Keys.FROM).equals("2"))
            {
                var bundle=Bundle()
                bundle.putString(Keys.POSTID,list[it].id.toString())
                openA(DragandDropMatch::class,bundle)
            }
            else{
                var bundle=Bundle()
                bundle.putString(Keys.POSTID,list[it].id.toString())
                openA(LineMatching::class,bundle)
            }

        }
        adapter.addNewList(list)
        rvlist.adapter=adapter

    }
}