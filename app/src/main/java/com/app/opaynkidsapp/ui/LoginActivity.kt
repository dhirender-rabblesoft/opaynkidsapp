package com.app.opaynkidsapp.ui

 import android.os.Bundle
import android.util.Log
 import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityLoginBinding
import com.app.opaynkidsapp.utils.Keys
import com.app.opaynkidsapp.utils.TrackContent
import com.app.opaynkidsapp.utils.Utils
import com.app.opaynkidsapp.viewmodel.LoginSignViewModel


class LoginActivity : KotlinBaseActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginSignViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        TrackContent.LOGIN.customToString()
        viewModel = ViewModelProvider(this).get(LoginSignViewModel::class.java)
        viewModel.setBinder(binding, this)

        setUrl()
    }

    private  fun setUrl()
    {
        preferencemanger.getString(Keys.SAVE_URL_KEY).let {
            if (it == null || it.toString().isEmpty())
            {
                //    APP_BASE_URL= Keys.STAGINGBASEURL
                //  Utils.WEBURL=Keys.STAGINGBASEURL
                Log.e("loginurl1", Utils.WEBURL)
            }
            else
            {
                //APP_BASE_URL= it
                Utils.WEBURL=it
                Log.e("loginurl", Utils.WEBURL)
            }

        }
    }


    override fun onDestroy()
    {

        super.onDestroy()
    }





    override fun onResume() {
        super.onResume()

    }

}