package com.app.opaynkidsapp.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.TopicAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivitySubjectSelectionBinding
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.putStrings
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.model.LevelModel
import com.app.opaynkidsapp.ui.*
import com.app.opaynkidsapp.utils.Keys

class SubjectSelectionViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivitySubjectSelectionBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    var keyword = ""
    var getbundle = Bundle()
    fun setBinder(binder: ActivitySubjectSelectionBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this

        getbundle = (baseActivity as Activity).intent.extras!!
        keyword = getbundle.getString(Keys.FROM).toString()
        settoolbar()
        setAdpater()
        setclicks()
    }
    private  fun  setclicks()
    {
        binder.toolbar.icmenu2.gone()
        binder.toolbar.ivback.visible()
        binder.toolbar.ivback.setImageResource(R.drawable.menu)
        binder.toolbar.ivback.setOnClickListener {
            binder.drawerLayout.openDrawer(Gravity.START)
        }

    }


    private fun setAdpater() {

        val levelList = ArrayList<LevelModel>()
        levelList.add(
            LevelModel(
                "Numbers",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.number
            )
        )
        levelList.add(
            LevelModel(
                "Alphabet",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.alphabet
            )
        )
        levelList.add(
            LevelModel(
                "Colors",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.colors
            )
        )
        levelList.add(
            LevelModel(
                "Shapes",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.shapes
            )
        )



        levelList.add(
            LevelModel(
                "Classification",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.hierarchy
            )
        )

        levelList.add(
            LevelModel(
                "Draw Practice",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.father
            )
        )


//        levelList.add(
//            LevelModel(
//                "Testing",
//                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
//                R.drawable.`object`
//            )
//        )
        levelList.add(
            LevelModel(
                "Fill Blanks",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.filldrag
            )
        )

        levelList.add(
            LevelModel(
                "Match Words",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.jigsaw
            )
        )
        levelList.add(
            LevelModel(
                "Drag and Drop Match",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.drag
            )
        )


        val topicAdapter = TopicAdapter(baseActivity) {


            val bundle = Bundle()
            bundle.getString(Keys.FROM, keyword)


            when(levelList[it].title)
            {
                "Draw Practice"->{
                    baseActivity.openA(DrawPractice::class)
                }
                "Colors"->{
                    baseActivity.openA(LineMatching::class)
                }
                "Testing"->{
                    baseActivity.openA(MCQActivity::class)
                }
                "Fill Blanks"->{
                    baseActivity.openA(FillBlankActivity::class)
                }
                "Match Words"->{
                    baseActivity.openA(MatchQAActivity::class)
                }
                "Classification"->{
                    baseActivity.openA(ObjectsA::class)
                }
                "Drag and Drop Match"->{
                    baseActivity.openA(DragandDropMatch::class)
                }
                else->{
                    val bundle2 = Bundle()
                    bundle2.putString(Keys.FROM, levelList[it].title)
                    baseActivity.openA(LearnActivity::class, bundle2)
                }
            }


            //for specfic study
//            if (keyword.equals("Learn")){
//                val bundle2 = Bundle()
//                bundle2.putString(Keys.FROM,levelList[it].title)
//                baseActivity.openA(LearnActivity::class,bundle2)
//            }else if (keyword.equals("Testing")){
//                baseActivity.openA(MCQActivity::class)
//
//            }else if (keyword.equals("Result")){
//
//            }


        }
        topicAdapter.addNewList(levelList)
        binder.rvTopic.adapter = topicAdapter
    }


    private fun settoolbar() {
        binder.toolbar.tvtitle.setText("Topics")
    }


}