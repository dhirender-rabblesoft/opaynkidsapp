package com.app.opaynkidsapp.repository
import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.model.NumberJson
import com.app.opaynkidsapp.network.APIInterface
import com.app.opaynkidsapp.network.RetrofitClient
import com.app.opaynkidsapp.utils.Keys
import com.app.opaynkidsapp.utils.Keys.APP_BASE_URL1

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CommonRepository(private val baseActivity: Application)
{
    var retrofitClient: APIInterface? = null
    private val mutableLiveData = MutableLiveData<ResponseBody>()

    fun getnumbers(baseActivity: KotlinBaseActivity,   url:String,ishowloader:Boolean=false, itemClick: (NumberJson) -> Unit)
    {

        if (!baseActivity.networkcheck.isNetworkAvailable())
        {
            baseActivity.nointernershowToast()
        }
        else{
            if (ishowloader)
            {

                baseActivity.startProgressDialog()
            }
            retrofitClient = RetrofitClient.with(this.baseActivity)?.client?.create(
                APIInterface::class.java
            )

            retrofitClient?.getnumbers(
                APP_BASE_URL1+url
                )!!.enqueue(object : Callback<NumberJson>
            {
                override fun onResponse(
                    call: Call<NumberJson?>,
                    response: Response<NumberJson?>
                ) {
                    baseActivity.stopProgressDialog()
                    when(response.code())
                    {
                        Keys.RESPONSE_SUCESS->{
                            response.body()?.let { itemClick(it) }
                         }
                        Keys.ERRORCODE->{
                            baseActivity.parseError(response)
                        }
                        Keys.UNAUTHoRISE->{
                             // faqmutableLiveData.setValue(response.body())
                        }
                        in 500..512->{
                            baseActivity.customSnackBar(baseActivity.getString(R.string.somthingwentwrong),true)
                        }
                    }

                }

                override fun onFailure(call: Call<NumberJson?>, t: Throwable)
                {
                    baseActivity.stopProgressDialog()
                 }
            })
        }

    }



}