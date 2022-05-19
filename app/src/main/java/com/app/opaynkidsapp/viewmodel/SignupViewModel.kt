package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivitySignupBinding
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.isEmailValid
 import com.app.opaynkidsapp.ui.OTPVerify
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.lang.StringBuilder

class SignupViewModel (application: Application) : AppViewModel(application)  {

    private lateinit var binder: ActivitySignupBinding
    lateinit var baseActivity: KotlinBaseActivity
    private lateinit var mContext: Context

    val job = SupervisorJob()
    private val isjobset by lazy { CoroutineScope(job + Dispatchers.IO) }
    fun setBinder(binder: ActivitySignupBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()


    }

    private fun setclicks() {


        binder.loginbutton.setOnClickListener {
            if (validations()) {
            baseActivity.openA(OTPVerify::class)

            }
        }
        binder.llogin.setOnClickListener {
            baseActivity.onBackPressed()
        }

        binder.llsignupcontainer.setOnClickListener {
            baseActivity.hideKeyboard()
        }
    }

    private fun validations(): Boolean
    {
        binder.namelayout.error=null
        binder.emaillayout.error=null
        binder.passwordlayout.error=null
        binder.confirmpasswordlayout.error=null
        if (binder.etusername.text.toString().trim().isEmpty()) {
            binder.namelayout.error=mContext.getString(R.string.v_username)
            //     showToast(mContext.getString(R.string.v_username))
            return false
        }
        if (binder.etemail.text.toString().trim().isEmpty()) {
            binder.emaillayout.error=mContext.getString(R.string.v_email)
            //  showToast(mContext.getString(R.string.v_email))
            return false
        }
        if (!isEmailValid(binder.etemail.text!!.trim().toString())) {
            binder.emaillayout.error=mContext.getString(R.string.v_validemail)
            //  showToast(mContext.getString(R.string.v_validemail))
            return false
        }

        if (binder.etpassword.text.toString().trim().isEmpty()) {
            binder.passwordlayout.error=mContext.getString(R.string.v_password)

            // showToast(mContext.getString(R.string.v_password))
            return false
        }

        if (binder.etphone.text.toString().trim().isEmpty()) {
            binder.passwordlayout.error=mContext.getString(R.string.enter_phone_number)

            // showToast(mContext.getString(R.string.v_password))
            return false
        }

        if (binder.etphone.text.toString().trim().length < 10) {
            binder.passwordlayout.error=mContext.getString(R.string.phonelength)

            // showToast(mContext.getString(R.string.passwordlength))
            return false
        }
        if (binder.etpassword.text.toString().trim().length < 6) {
            binder.passwordlayout.error=mContext.getString(R.string.passwordlength)

            // showToast(mContext.getString(R.string.passwordlength))
            return false
        }
        if (binder.etconfirmpassword.text.toString().trim().isEmpty()) {
            binder.confirmpasswordlayout.error=mContext.getString(R.string.v_confirmpassword)

            //   showToast(mContext.getString(R.string.v_password))
            return false
        }
//        if (binder.etconfirmpassword.text.toString().trim().length < 6) {
//            binder.confirmpasswordlayout.error=mContext.getString(R.string.passwordlength)
//
//           // showToast(mContext.getString(R.string.passwordlength))
//            return false
//        }
        if (!binder.etconfirmpassword.text.toString().trim()
                .equals(binder.etpassword.text.toString().trim())
        ) {
            binder.confirmpasswordlayout.error=mContext.getString(R.string.passwordnotmatch)
            //   showToast(mContext.getString(R.string.passwordnotmatch))
            return false
        }
        return true
    }



}