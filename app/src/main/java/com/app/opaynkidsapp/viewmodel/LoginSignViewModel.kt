package com.app.opaynkidsapp.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
 import com.app.opaynkidsapp.databinding.ActivityLoginBinding
import com.app.opaynkidsapp.extensions.isEmailValid
import com.app.opaynkidsapp.ui.ForgotPassword
import com.app.opaynkidsapp.ui.Signup

class LoginSignViewModel(application: Application) : AppViewModel(application)
{
    private lateinit var binder: ActivityLoginBinding
    private lateinit var mContext: Context
    lateinit var  baseActivity: KotlinBaseActivity
    var isFlag=false
    var bundle=Bundle()
    var tokens2=""
    fun setBinder(binder: ActivityLoginBinding,baseActivity: KotlinBaseActivity)
    {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity=baseActivity
        this.binder.viewModel = this
        setclicks()
//        bundle = (mContext as Activity).intent.extras!!
    }

    private  fun setclicks()
    {
        binder.loginbutton.setOnClickListener {
            if (validatios())
            {

            }
        }
        binder.llsignup.setOnClickListener {
            baseActivity.openA(Signup::class)
        }
        binder.tvforgotpasssword.setOnClickListener {
            baseActivity.openA(ForgotPassword::class)
        }

    }

    private  fun validatios():Boolean
    {
        binder.passwordlayout.error=null
        binder.emaillayout.error=null

        if (binder.etemail.text.toString().trim().isEmpty())
        {
            binder.emaillayout.error=mContext.getString(R.string.v_validemail)

            //showToast(mContext.getString(R.string.v_validemail))
            return false
        }
        if (!isEmailValid(binder.etemail.text!!.trim().toString())){
            binder.emaillayout.error=mContext.getString(R.string.v_validemail)
            //  showToast(mContext.getString(R.string.v_validemail))
            return false
        }
        if (binder.etpassword.text.toString().trim().isEmpty())
        {
            binder.passwordlayout.error=mContext.getString(R.string.v_password)
            //   showToast(mContext.getString(R.string.v_password))
            return false
        }

        return true
    }



}