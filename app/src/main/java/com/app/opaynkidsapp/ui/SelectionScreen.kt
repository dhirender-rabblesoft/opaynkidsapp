package com.app.opaynkidsapp.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.KidLevelAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivitySelectionScreenBinding
import com.app.opaynkidsapp.model.LevelModel
import com.app.opaynkidsapp.utils.Keys

class SelectionScreen : KotlinBaseActivity() {
    lateinit var binding: ActivitySelectionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_selection_screen)
        setlevelAdapter()
        settoolbar()
    }

    private fun settoolbar() {
        binding.toolbar.tvtitle.setText("Selection")
    }

    private fun setlevelAdapter()
    {

        val levelList = ArrayList<LevelModel>()
        levelList.add(
            LevelModel(
                "Learn",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.child1
            )
        )
        levelList.add(
            LevelModel(
                "Testing",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.child2
            )
        )

        levelList.add(
            LevelModel(
                "Result",
                "This section is used to identity the icon, shapes, and colors and also learn your child of alphabet and numbers and little bit knwolengs of animales",
                R.drawable.child3
            )
        )
        val levelAdapter = KidLevelAdapter(this) {
            val bundle = Bundle()
            bundle.putString(Keys.FROM, levelList[it].title)
//            openA(CommonActivity::class, bundle)

            openA(SubjectSelectionActivity::class,bundle)


        }
        levelAdapter.addNewList(levelList)
        binding.rvlevel.adapter = levelAdapter

    }
}