package com.app.opaynkidsapp.ui

 import android.os.Bundle
 import android.util.Log
 import androidx.databinding.DataBindingUtil
 import androidx.drawerlayout.widget.DrawerLayout
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
        val a = intArrayOf(35, 40, 80, 55, 8, 9)
      // Log.e("getSecondLargest",getSecondLargest(a,6).toString())

    }
    fun getSecondLargest(a: IntArray, total: Int): Int {
        var temp: Int
        for (i in 0 until total) {
            for (j in i + 1 until total) {
                if (a[i] > a[j]) {
                    temp = a[i]
                    a[i] = a[j]
                    a[j] = temp
                }
            }
        }
        return a[total - 2]
    }
}