package com.app.opaynkidsapp.repository
import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.model.*
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
    fun match(baseActivity: KotlinBaseActivity,   url:String,ishowloader:Boolean=false, itemClick: (MatchJson) -> Unit)
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

            retrofitClient?.match(
                APP_BASE_URL1+url
                )!!.enqueue(object : Callback<MatchJson>
            {
                override fun onResponse(
                    call: Call<MatchJson?>,
                    response: Response<MatchJson?>
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

                override fun onFailure(call: Call<MatchJson?>, t: Throwable)
                {
                    baseActivity.stopProgressDialog()
                 }
            })
        }

    }
    fun onjects(baseActivity: KotlinBaseActivity,   url:String,ishowloader:Boolean=false, itemClick: (ObjectsJson) -> Unit)
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

            retrofitClient?.objects(
                APP_BASE_URL1+url
                )!!.enqueue(object : Callback<ObjectsJson>
            {
                override fun onResponse(
                    call: Call<ObjectsJson?>,
                    response: Response<ObjectsJson?>
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

                override fun onFailure(call: Call<ObjectsJson?>, t: Throwable)
                {
                    baseActivity.stopProgressDialog()
                 }
            })
        }

    }
    fun fillup(baseActivity: KotlinBaseActivity,   url:String,ishowloader:Boolean=false, itemClick: (Fillupjson) -> Unit)
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
            retrofitClient?.fillup(APP_BASE_URL1+url)!!.enqueue(object : Callback<Fillupjson>
            {
                override fun onResponse(
                    call: Call<Fillupjson?>,
                    response: Response<Fillupjson?>
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

                override fun onFailure(call: Call<Fillupjson?>, t: Throwable)
                {
                    baseActivity.stopProgressDialog()
                 }
            })
        }

    }
    fun dragmatch(baseActivity: KotlinBaseActivity,   url:String,ishowloader:Boolean=false, itemClick: (McqJson) -> Unit)
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
            retrofitClient?.dragmatch(APP_BASE_URL1+url)!!.enqueue(object : Callback<McqJson>
            {
                override fun onResponse(
                    call: Call<McqJson?>,
                    response: Response<McqJson?>
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

                override fun onFailure(call: Call<McqJson?>, t: Throwable)
                {
                    baseActivity.stopProgressDialog()
                 }
            })
        }

    }
  fun drawing(baseActivity: KotlinBaseActivity,   url:String,ishowloader:Boolean=false, itemClick: (DrawingJson) -> Unit)
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
            retrofitClient?.drawing(APP_BASE_URL1+url)!!.enqueue(object : Callback<DrawingJson>
            {
                override fun onResponse(
                    call: Call<DrawingJson?>,
                    response: Response<DrawingJson?>
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

                override fun onFailure(call: Call<DrawingJson?>, t: Throwable)
                {
                    baseActivity.stopProgressDialog()
                 }
            })
        }

    }



}