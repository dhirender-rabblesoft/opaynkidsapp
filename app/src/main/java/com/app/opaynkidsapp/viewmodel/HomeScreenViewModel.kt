package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import android.os.Bundle
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.KidLevelAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityForgotPasswordBinding
import com.app.opaynkidsapp.databinding.ActivityHomeScreenBinding
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.isEmailValid
import com.app.opaynkidsapp.model.LevelModel
import com.app.opaynkidsapp.ui.*
import com.app.opaynkidsapp.utils.Keys
import kotlinx.android.synthetic.main.common_toolbar.view.*


class HomeScreenViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityHomeScreenBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false

    fun setBinder(binder: ActivityHomeScreenBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()
        setadapterColor()
        setlevelAdapter()
        settoolbar()
    }

    private fun setlevelAdapter() {

        val levelList = ArrayList<LevelModel>()
        levelList.add(LevelModel("Pre Nursery","This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",R.drawable.child1 ))
        levelList.add(LevelModel("Nursery","This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",R.drawable.child2 ))
        levelList.add(LevelModel("LKG","This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",R.drawable.child3 ))
        levelList.add(LevelModel("UKG","This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",R.drawable.child4 ))
        val levelAdapter = KidLevelAdapter(baseActivity) {
//            val bundle = Bundle()
//            bundle.putString(Keys.FROM , levelList[it].title)
//            baseActivity.openA(CommonActivity::class,bundle)

            //for learn,result,testing
//            baseActivity.openA(SelectionScreen::class)

          baseActivity.openA(SubjectSelectionActivity::class)

        }
        levelAdapter.addNewList(levelList)
        binder.rvlevel.adapter = levelAdapter

    }
     private fun settoolbar(){
        binder.toolbar.tvtitle.setText("Learn")
    }


    private fun setadapterColor() {
        HomeScreen.packagecolorlist.add("#1AB0B0")
        HomeScreen.packagecolorlist.add("#8576FD")
        HomeScreen.packagecolorlist.add("#E6F6265F")

        HomeScreen.packagesubcolorlist.add("#80E6E6")
        HomeScreen.packagesubcolorlist.add("#C0B8FF")
        HomeScreen.packagesubcolorlist.add("#FF8DA7")
    }

    private fun setclicks() {


    }


}