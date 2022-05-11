package com.app.opaynkidsapp.viewmodel
import android.app.Application
import android.content.Context
 import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityFillBlankBinding
import com.app.opaynkidsapp.databinding.ActivityForgotPasswordBinding
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.isEmailValid
import com.app.opaynkidsapp.ui.OTPVerify


class FillBlankTestViewModel(application: Application) : AppViewModel(application)
{
    private lateinit var binder: ActivityFillBlankBinding
    private lateinit var mContext: Context
    lateinit var  baseActivity: KotlinBaseActivity
    var isFlag = false

    fun setBinder(binder: ActivityFillBlankBinding,baseActivity: KotlinBaseActivity)
    {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity=baseActivity
        this.binder.viewModel = this
        setclicks()

    }
    private  fun setclicks()
    {

    }


}