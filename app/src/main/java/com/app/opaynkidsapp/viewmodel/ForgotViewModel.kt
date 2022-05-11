package com.app.opaynkidsapp.viewmodel
import android.app.Application
import android.content.Context
 import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityForgotPasswordBinding
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.isEmailValid
import com.app.opaynkidsapp.ui.OTPVerify


class ForgotViewModel(application: Application) : AppViewModel(application)
{
    private lateinit var binder: ActivityForgotPasswordBinding
    private lateinit var mContext: Context
    lateinit var  baseActivity: KotlinBaseActivity
    var isFlag = false

    fun setBinder(binder: ActivityForgotPasswordBinding,baseActivity: KotlinBaseActivity)
    {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity=baseActivity
        this.binder.viewModel = this
        setclicks()

    }
    private  fun setclicks()
    {
        binder.loginbutton.setOnClickListener {
            if (validatios())
            {
                isFlag=false
                baseActivity.openA(OTPVerify::class)

            }
         }
        binder.llforgotpassContainer.setOnClickListener {
            baseActivity.hideKeyboard()
        }
    }
    private  fun validatios():Boolean
    {
        if (binder.etemail.text.toString().trim().isEmpty())
        {
            binder.emaillayout.error=mContext.getString(R.string.v_validemail)
         //   showToast(mContext.getString(R.string.v_validemail))
            return false
        }
        if (!isEmailValid(binder.etemail.text!!.trim().toString())){
            binder.emaillayout.error=mContext.getString(R.string.v_validemail)
          //  showToast(mContext.getString(R.string.v_validemail))
            return false
        }
        binder.emaillayout.error=null
        return true
    }

}