package com.app.opaynkidsapp.viewmodel
import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log

import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ObjectAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity

import com.app.opaynkidsapp.databinding.ActivityObjectsBinding
import com.app.opaynkidsapp.extensions.gone

import com.app.opaynkidsapp.extensions.visible

import com.app.opaynkidsapp.model.ObjectsJson

import com.app.opaynkidsapp.repository.CommonRepository
import com.app.opaynkidsapp.ui.*
import com.app.opaynkidsapp.utils.Keys

import kotlin.collections.ArrayList

class ObjectsViewModel (application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityObjectsBinding
     lateinit var baseActivity: KotlinBaseActivity
    var commonRepository: CommonRepository = CommonRepository(application)
    private lateinit var mContext: Context
    var getBundle=Bundle()


    fun setBinder(binder: ActivityObjectsBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
         Keys.isSubmit = false
        getBundle = (baseActivity as Activity).intent.extras!!
        settoolbar()


    }

    private fun settoolbar()
    {
        if (getBundle.getString(Keys.FROM)!=null)
        {

            binder.header.tvtitle.text = getBundle.getString(Keys.FROM)
            getobjects(Keys.SUBCATEGORY+getBundle.getString(Keys.POSTID))
        }
        else{

            binder.header.tvtitle.text = "Classification"
            getobjects(Keys.OBJECTS)
        }
        binder.header.ivback.visible()
        binder.header.icmenu2.gone()
        binder.header.ivback.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        binder.header.ivback.setOnClickListener {
            Keys.isSubmit = false
            baseActivity.onBackPressed()
        }
    }
    private  fun getobjects(url:String)
    {
        commonRepository.onjects(baseActivity,url){
            setdadpter(it.data)
        }
    }
    private  fun setdadpter(list:ArrayList<ObjectsJson.Data>)
    {
        val  adapterViewFlipper = ObjectAdapter(baseActivity){
            if (binder.header.tvtitle.text.toString().equals("Practise Test"))
            {
                    when(list[it].data)
                    {

                        "Fill Blanks"->{
                            val bundle2 = Bundle()
                            bundle2.putString(Keys.FROM, "1")
                            bundle2.putString(Keys.POSTNAME, list[it].data)
                            baseActivity.openA(GuessWord::class,bundle2)
                        }
                        "Match Words"->{
                            val bundle2 = Bundle()
                            bundle2.putString(Keys.FROM, "2")
                            bundle2.putString(Keys.POSTNAME, list[it].data)
                            //bundle2.putString(Keys.POSTID, list[it].id.toString())
                            baseActivity.openA(GuessWord::class,bundle2)
                        }
                        "Drag & Drop Match"->{
                            val bundle2 = Bundle()
                            bundle2.putString(Keys.FROM, "3")
                            bundle2.putString(Keys.POSTNAME, list[it].data)
                            //bundle2.putString(Keys.POSTID, list[it].id.toString())
                            baseActivity.openA(GuessWord::class,bundle2)
                        }
                        "Drawing"->{

                            baseActivity.openA(DrawPractice::class)
                        }
                        else->{
                            val bundle2 = Bundle()
                             bundle2.putString(Keys.FROM, list[it].data)
                            baseActivity.openA(LearnActivity::class, bundle2)
                        }

                    }
            }
            else{
                if (list[it].data.equals("Shapes"))
                {
                    Log.e("test1","111")
                    val bundle2 = Bundle()
                    bundle2.putString(Keys.FROM, "Shapes")
                    bundle2.putString(Keys.POSTID, list[it].id.toString())
                    bundle2.putString(Keys.POSTNAME, list[it].data.toString())
                    baseActivity.openA(LearnActivity::class, bundle2)
                }
               else  if (list[it].data.equals("Classifications"))
                {
                    Log.e("test1","111")

                    baseActivity.openA(Classfication::class)

                }
                else{
                    Log.e("test1","111222")
                    if ( binder.header.tvtitle.text.equals("Classification"))
                    {
                        val bundle2 = Bundle()
                         bundle2.putString(Keys.POSTNAME, list[it].data.toString())
                        bundle2.putString(Keys.POSTID, list[it].id.toString())
                         baseActivity.openA(LearnActivity::class, bundle2)
                    }
                    else{

                        val bundle2 = Bundle()
                        bundle2.putString(Keys.FROM, list[it].data)
                        baseActivity.openA(LearnActivity::class, bundle2)
                    }

                }

            }

        }
        adapterViewFlipper.addNewList(list)
        binder. rvTopic.adapter=adapterViewFlipper
    }
}