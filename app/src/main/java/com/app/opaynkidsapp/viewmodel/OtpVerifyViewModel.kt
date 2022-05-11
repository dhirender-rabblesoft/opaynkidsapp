package com.app.opaynkidsapp.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityOtpverifyBinding
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.ui.CongratulationScreen
import com.app.opaynkidsapp.utils.Keys

class OtpVerifyViewModel (application: Application) : AppViewModel(application)
{

    private lateinit var binder: ActivityOtpverifyBinding
    private lateinit var mContext: Context
    lateinit var  baseActivity: KotlinBaseActivity
    var bundle= Bundle()
    var isFlag = false
    var apiurl=Keys.email_verify

    fun setBinder(binder: ActivityOtpverifyBinding,baseActivity: KotlinBaseActivity)
    {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity=baseActivity
        this.binder.viewModel = this
        bundle = (mContext as Activity).intent.extras!!
        setclicks()
    }
    private  fun setclicks()
    {
        binder.loginbutton.setOnClickListener {
            if (validatios())
            {
                baseActivity.openA(CongratulationScreen::class)
            }
        }
        binder.tvreset.setOnClickListener {
//                resendotp()
        }
        binder.llotpcontainer.setOnClickListener {
            baseActivity.hideKeyboard()
        }
    }
    private  fun validatios():Boolean
    {
        if (binder.etcode.text.toString().trim().isEmpty())
        {
            binder.codelayout.error =mContext.getString(R.string.valid_code)
            //   showToast(mContext.getString(R.string.v_code))
            return false
        }
        if (binder.etcode.text.toString().trim().length<4)
        {
            binder.codelayout.error=mContext.getString(R.string.valid_code)
            //   showToast(mContext.getString(R.string.v_code))
            return false
        }
        binder.codelayout.error=null
        return true
    }
}