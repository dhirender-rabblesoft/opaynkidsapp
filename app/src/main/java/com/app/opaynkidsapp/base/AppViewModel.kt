package com.app.opaynkidsapp.base

 import android.app.Application

import android.content.Context
 import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
 import com.google.gson.JsonObject
 import com.app.opaynkidsapp.network.APIInterface
 import com.app.opaynkidsapp.network.RetrofitClient

 import okhttp3.ResponseBody
 import retrofit2.Call
 import retrofit2.Callback
  import android.provider.Settings;
 import com.app.opaynkidsapp.utils.Keys
 import com.app.opaynkidsapp.utils.NetworkCheck
 import com.app.opaynkidsapp.utils.TrackContent
 import com.app.opaynkidsapp.utils.Utils


// import com.opayl.utils.TrackContent

 import retrofit2.Response





open class AppViewModel : AndroidViewModel
{

    internal lateinit var toast: Toast
    constructor(application: Application) : super(application)
    {
        initToast()
        val jsonobj= JsonObject()
        jsonobj.addProperty(Keys.device_id,getAndroidID(getContext()))
        jsonobj.addProperty(Keys.screen_name, TrackContent.screenname)

//
//        if (Home.USERID.isNotNull() &&!Home.USERID.isEmpty())
//        {
//            jsonobj.addProperty(Keys.user_id,Home.USERID)
//        }
//        trackpost(getContext(),Utils.WEBURL+Keys.track,jsonobject = jsonobj){
//
//        }



    }


    fun initToast()
    {
        toast = Toast.makeText(getContext(), "", Toast.LENGTH_LONG)

    }
    open fun getAndroidID(context: Context):String {
        val android_id: String = Settings.System.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        )
        println(android_id)
        return android_id
    }

    fun trackpost(baseActivity: Context, url:String, jsonobject: JsonObject, itemClick: (ResponseBody) -> Unit)
    {
        if (NetworkCheck(context = baseActivity).isNetworkAvailable())
        {
            val retrofitClient = RetrofitClient.with(this.getContext())?.client?.create(
                APIInterface::class.java
            )
//            retrofitClient?.commonpost(url, Utils.AUTHTOKEN,jsonobject)!!.enqueue(object : Callback<ResponseBody>
//            {
//                override fun onResponse(
//                    call: Call<ResponseBody?>,
//                    response: Response<ResponseBody?>
//                ) {
//
//                    when(response.code())
//                    {
//                        Keys.RESPONSE_SUCESS->{
//
//                        }
//                        Keys.ERRORCODE->{
//
//                        }
//                        Keys.UNAUTHoRISE->{
//                            //signupmutableLiveData.setValue(response.body())
//                        }
//                    }
//
//                }
//
//                override fun onFailure(call: Call<ResponseBody?>, t: Throwable)
//                {
//
//                    // signupmutableLiveData.setValue(null)
//                }
//            })

        }



    }
    fun getContext(): Context {
        return (getApplication() as Application).applicationContext
    }





    fun getLabelText(resId: Int): String {
        return getContext().getString(resId)
    }


//    fun isLocationPermissionAllowed(context: Context): Boolean {
//        val list = listOf<String>(
//                Manifest.permission.INTERNET,
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//        )
//        val managePermissions = ManagePermissionsImp((context as MainActivity), list, 0)
//        if (managePermissions.isPermissionsGranted() == 0) {
//            return true
//        }
//        return false
//    }

}
