package com.app.opaynkidsapp.viewmodel
import android.app.Application
import android.content.Context
import android.os.Bundle

import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ObjectAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity

import com.app.opaynkidsapp.databinding.ActivityObjectsBinding
import com.app.opaynkidsapp.extensions.gone

import com.app.opaynkidsapp.extensions.visible

import com.app.opaynkidsapp.model.ObjectsJson

import com.app.opaynkidsapp.repository.CommonRepository
import com.app.opaynkidsapp.ui.LearnActivity
import com.app.opaynkidsapp.utils.Keys

import kotlin.collections.ArrayList

class ObjectsViewModel (application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityObjectsBinding
     lateinit var baseActivity: KotlinBaseActivity
    var commonRepository: CommonRepository = CommonRepository(application)
    private lateinit var mContext: Context


    fun setBinder(binder: ActivityObjectsBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
         Keys.isSubmit = false
        settoolbar()
        getobjects()

    }

    private fun settoolbar() {
        binder.header.tvtitle.text = "Classification"
        binder.header.ivback.visible()
        binder.header.icmenu2.gone()
        binder.header.ivback.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        binder.header.ivback.setOnClickListener {
            Keys.isSubmit = false
            baseActivity.onBackPressed()
        }
    }
    private  fun getobjects()
    {
        commonRepository.onjects(baseActivity,Keys.OBJECTS){
            setdadpter(it.data)
        }
    }
    private  fun setdadpter(list:ArrayList<ObjectsJson.Data>)
    {
        val  adapterViewFlipper = ObjectAdapter(baseActivity){
            val bundle2 = Bundle()
            bundle2.putString(Keys.FROM, "Shapes")
            bundle2.putString(Keys.POSTID, list[it].id.toString())
            bundle2.putString(Keys.POSTNAME, list[it].data.toString())
            baseActivity.openA(LearnActivity::class, bundle2)
        }
        adapterViewFlipper.addNewList(list)
        binder. rvTopic.adapter=adapterViewFlipper
    }
}