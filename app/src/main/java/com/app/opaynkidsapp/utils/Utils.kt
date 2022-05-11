package com.app.opaynkidsapp.utils

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.provider.Settings
import android.text.Html
import android.text.Layout
import android.text.Spanned
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


object Utils
{
    var ABOUTUS = 1
    var PRIVACY = 2
    var TERMS = 3
    var FAQ = 4
    var HEADERTOPMARGIN=35
    const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34
    const val DATETIMEFORMAT="yyyy-MM-dd HH:mm:ss"
    const val DATETIMEFORMAT2="yyyy-MM-dd"
    const val TIMEFORMAT="hh:mm aa"
    const val TIMEFORMAT2="hh:mm:ss"
    const val DATEFORMAT="dd-MMM-yyyy"
    const val DATEFORMAT2="yyyy-MM-dd"
    const val DATEFORMAT3="dd-MMM-yyyy"
    const val DATEFORMAT4="dd MMM"
    const val MONTHNAME="MMM"
    const val IELSTS_PREPRATIONID=7
    const val Writing="writing"
    const val Intro="intro"
    const val CueCard="cue_card"
    const val Discussion="discussion"
    const val Listenings="listening"
    const val Speaking="speaking"
    const val APPLICATIONJSON="application/json"
    const val VIDEORESOUCE="video/mp4"
    const val AUDIORESOUCE="audio/mpeg"
    const val APPLICATIONPDF="application/pdf"
    const val PDFRESOUCE="pdf"
    var AUTHTOKEN=""
    var TRACK=""
    var CHECKUSER=""
    var MCQQUESTION=1
    var TRUEFALSEQUESTION=2
    var FIILLUPQUESTION=3
    var SINGLECHOICE=4
    var TYPE = "type"
    var tokens = ""
    var RAZORPAY_ID="rzp_test_T8kQTg09rXvlEi"
    var IOSPACKAGE="com.opayl"
    var FIREBASEPREFIX="https://opayl.page.link"
    var APPDOMAIN="https://www.opayl.com/?share="
    var WEBURL=""

    fun setDialogAttributes(dialog: Dialog, height: Int)
    {
        val window = dialog.window ?: return
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, height)
        window.setGravity(Gravity.CENTER)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    fun getAndroidID(context: Context):String
    {
        val android_id: String = Settings.System.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        println(android_id)
        return  android_id
    }
    fun printDifference(sstartDate: String, sendDate: String):Int {
         val simpleDateFormat = SimpleDateFormat(DATETIMEFORMAT)
        val startDate = simpleDateFormat.parse(sstartDate)
        val endDate = simpleDateFormat.parse(sendDate)

        //milliseconds
        var different = endDate.time - startDate.time
        println("startDate : $startDate")
        println("endDate : $endDate")
        println("different : $different")
        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different = different % daysInMilli
        val elapsedHours = different / hoursInMilli
        different = different % hoursInMilli
        val elapsedMinutes = different / minutesInMilli
        different = different % minutesInMilli
        val elapsedSeconds = different / secondsInMilli
        System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n",
            elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds
        )
        return  elapsedDays.toInt()
    }
    fun printmintDifference(sstartDate: String, sendDate: String):Int {
         val simpleDateFormat = SimpleDateFormat(DATETIMEFORMAT)
        val startDate = simpleDateFormat.parse(sstartDate)
        val endDate = simpleDateFormat.parse(sendDate)

        //milliseconds
        var different = endDate.time - startDate.time

        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different = different % daysInMilli
        val elapsedHours = different / hoursInMilli
        different = different % hoursInMilli
        val elapsedMinutes = different / minutesInMilli
        different = different % minutesInMilli
        val elapsedSeconds = different / secondsInMilli
        System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n",
            elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds
        )
        return  elapsedMinutes.toInt()
    }
    fun isTextTruncated(text: String?, textView: AppCompatTextView?): Boolean
    {
        if (textView != null && text != null)
        {
            Log.e("testttttt","testttttt")
            val layout: Layout? = textView.layout
            if (layout != null) {
                val lines: Int = layout.getLineCount()
                if (lines > 0)
                {
                    val ellipsisCount: Int = layout.getEllipsisCount(lines - 1)
                    Log.e("ellipsisCount",ellipsisCount.toString())

                    if (ellipsisCount > 0) {

                        return true
                    }
                }
            }
        }
        return false
    }
    fun minutedifference(sstartDate: String, sendDate: String):Int
    {
         val simpleDateFormat = SimpleDateFormat(DATETIMEFORMAT)
        val startDate = simpleDateFormat.parse(sstartDate)
        val endDate = simpleDateFormat.parse(sendDate)

        //milliseconds
        var different = endDate.time - startDate.time
        println("startDate : $startDate")
        println("endDate : $endDate")
        println("different : $different")
        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different = different % daysInMilli
        val elapsedHours = different /  60000
        different = different % hoursInMilli
        val elapsedMinutes = elapsedHours / minutesInMilli
        different = different % minutesInMilli
        val elapsedSeconds = different / secondsInMilli
        System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n",
            elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds
        )
        return  elapsedHours.toInt()
    }
    fun getcurrentdate():String
    {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(DATEFORMAT2)
        val strDate = sdf.format(c.time)
        return strDate
    }
    fun getonlycurrentdate():String
    {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(DATETIMEFORMAT2)
        val strDate = sdf.format(c.time)
        return strDate
    }
    fun getcurrendateandtimeinmilliesonds(givenDateString: String):Long
    {
         var differdates=0L

         val sdf = SimpleDateFormat(DATETIMEFORMAT)
        try {
            val mDate = sdf.parse(givenDateString)
            differdates = mDate.time


        } catch (e: ParseException) {
            e.printStackTrace()

         }
        return differdates
    }
    fun getTimeZone():String
    {
        var timeZone=TimeZone.getDefault()
        return timeZone.id

    }
    fun getcurrentdatetime():String
    {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(DATETIMEFORMAT)
       // sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        val strDate = sdf.format(c.time)
        return strDate
    }
    fun getcurrentdatetimewithutc():String
    {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat(DATETIMEFORMAT)
       // sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        val strDate = sdf.format(c.time)
        return strDate
    }


    fun hideKeyBoard(c: Context, v: View) {
        val imm = c
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)


    }
    fun String.toSpanned(): Spanned {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            return Html.fromHtml(this)
        }
    }
    //time conversion
    fun timerConversion(value: Long): String? {
        val audioTime: String
        val dur = value.toInt()
        val hrs = dur / 3600000
        val mns = dur / 60000 % 60000
        val scs = dur % 60000 / 1000
        audioTime = if (hrs > 0) {
            String.format("%02d:%02d:%02d", hrs, mns, scs)
        } else {
            String.format("%02d:%02d", mns, scs)
        }
        return audioTime
    }
    fun datedifference(date:String,sdate:String):String
    {

        val date1: Date
        val date2: Date
        var differdates=""
        val dates = SimpleDateFormat(DATEFORMAT2)
        try {
            //Setting dates
             date1 = dates.parse(date)
            date2 = dates.parse(sdate)
            //Comparing dates
            val difference = Math.abs(date1.time - date2.time)
            val differenceDates = difference / (24 * 60 * 60 * 1000)

            //Convert long to String
            differdates = java.lang.Long.toString(differenceDates)

        }
        catch (e:Exception)
        {
        }

        return  differdates



    }
    fun gethours(date:String,sdate:String):String
    {

        val date1: Date
        val date2: Date
        var differdates=""
        val dates = SimpleDateFormat(DATETIMEFORMAT)
        try {
            //Setting dates
             date1 = dates.parse(date)
            date2 = dates.parse(sdate)
            var cal=Calendar.getInstance()
            //Comparing dates

            val difference = date1.time - date2.time
            val seconds = difference / 1000
            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24
            differdates=hours.toString()


        }
        catch (e:Exception)
        {
        }

        return  differdates



    }
    fun getminutes(date:String,sdate:String):String
    {

        val date1: Date
        val date2: Date
        var differdates=""
        val dates = SimpleDateFormat(DATETIMEFORMAT)
        try {
            //Setting dates
            date1 = dates.parse(date)
            date2 = dates.parse(sdate)
            var cal=Calendar.getInstance()
            //Comparing dates

            val difference = date1.time - date2.time

            val seconds = difference / 1000

            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24
            differdates=minutes.toString()


        }
        catch (e:Exception)
        {
        }

        return  differdates



    }
     fun datedifferencewithdays(date:String,sdate:String):String
    {

        val date1: Date
        val date2: Date
        var differdates=""
        val dates = SimpleDateFormat(DATEFORMAT2)
        try
        {
            //Setting dates
             date1 = dates.parse(date)
            date2 = dates.parse(sdate)
            //Comparing dates
            val difference = Math.abs(date1.time - date2.time)
            val differenceDates = difference / (24 * 60 * 60 * 1000)
            //Convert long to String
            differdates = java.lang.Long.toString(differenceDates)
        }
        catch (e:Exception)
        {

        }
        if (differdates.equals("0"))
        {
          //  return  "1 Day"
            return  ""
        }
        else{
            var d1=differdates.toInt()
            val diffdate=++d1
            // TODO: chnage by  Project Manger (15/03/2022)
            // return  diffdate.toString()+" Days"

            return  "Daily"
        }

    }
    fun getechpoctime(d1:String,d2:String):Long
    {
        val date1: Date
        val date2: Date
        Log.e("testsss",d1+"-->"+d2)
        var differdates=0L
        val dates = SimpleDateFormat(DATETIMEFORMAT)
        try {
            //Setting dates
            date1 = dates.parse(d1)
            date2 = dates.parse(d2)
            //Comparing dates
            differdates = date2.time - date1.time
            //Log.e("diff",diff.toString())

            val difference = Math.abs(date1.time - date2.time)
            val differenceDates = difference / (24 * 60 * 60 * 1000)

            //Convert long to String
          //   differdates = java.lang.Long.toString(differenceDates)

        }catch (e:Exception)
        {

        }
        return  differdates

    }
    fun timedifference(date:String,sdate:String):Boolean
    {

        var  checktimeout=true
        val simpleDateFormat = SimpleDateFormat(DATETIMEFORMAT)
        val date1 = simpleDateFormat.parse(sdate)
        val date2 = simpleDateFormat.parse(date)
        val difference: Long = date2.getTime() - date1.getTime()
        val  days = (difference / (1000 * 60 * 60 * 24))
        val hours = ((difference - 1000 * 60 * 60 * 24 * days) / (1000 * 60 * 60))
        val min= (difference - 1000 * 60 * 60 * 24 * days - 1000 * 60 * 60 * hours)   / (1000 * 60)
        // hours = if (hours < 0) -hours else hours
         if (days<0 && min<0&&hours<0)
        {
            checktimeout=false

        }


        return checktimeout
    }
    fun getMultiPart(key: String?, file: String?): MultipartBody.Part?
    {
        return MultipartBody.Part.createFormData(key!!, file!!)
    }
    fun getMultiPart(key: String?, file: Any?): MultipartBody.Part?
    {
        return MultipartBody.Part.createFormData(key!!, file!!.toString())
    }
    fun getMultiPart(key: String?, file: File): MultipartBody.Part?
    {
        val requestFile = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(key!!, file.name, requestFile)
    }
    fun servertime( datew:String):String
    {
        val dateStr = datew
        val df = SimpleDateFormat(DATETIMEFORMAT, Locale.ENGLISH)
        df.timeZone = TimeZone.getTimeZone("UTC")
         val tz = TimeZone.getDefault()
        System.out.println(
            "TimeZone   " + tz.getDisplayName(false, TimeZone.SHORT)
                .toString() + " Timezone id :: " + tz.id
        )
        val date = df.parse(dateStr)
        df.timeZone = TimeZone.getDefault()
        val formattedDate = df.format(date)
        return  formattedDate

    }

    @JvmStatic
    fun minuteago(args: String):String
    {
        var data=""
        try {
            val format = SimpleDateFormat(DATETIMEFORMAT)
            val past = format.parse(args)
            val now = Date()
            val seconds: Long = TimeUnit.MILLISECONDS.toSeconds(now.time - past.time)
            val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(now.time - past.time)
            val hours: Long = TimeUnit.MILLISECONDS.toHours(now.time - past.time)
            val days: Long = TimeUnit.MILLISECONDS.toDays(now.time - past.time)
            //
//          System.out.println(TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime()) + " milliseconds ago");
//          System.out.println(TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime()) + " minutes ago");
//          System.out.println(TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime()) + " hours ago");
//          System.out.println(TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime()) + " days ago");
            if (seconds < 60) {
                data="$seconds seconds ago"
                println("$seconds seconds ago")
            } else if (minutes < 60) {
                data="$minutes minutes ago"
                println("$minutes minutes ago")
            } else if (hours < 24) {
                data="$hours hours ago"
                println("$hours hours ago")
            }
            else if (days >= 7) {
                if (days > 360) {
                    val caltime=days/360
                    data = caltime.toString() + " years ago" ;
                } else if (days > 30) {

                    val caltime=days/30
                    data = caltime.toString() + " months ago" ;


                } else {
                    val caltime=days/7

                    data = caltime.toString() + " weeks ago" ;

                }
            }
            else {
                var tempdays=days+1
                data="$tempdays days ago"

                println("$days days ago")
            }
        } catch (j: Exception) {
            j.printStackTrace()
        }
        return  data
    }

    fun formateDateFromstring(inputFormat: String, outputFormat: String, inputDate: String): String {
        var parsed: Date? = null
        var outputDate = ""
        var df_input = SimpleDateFormat(inputFormat, Locale.getDefault())
        var df_output = SimpleDateFormat(outputFormat, Locale.getDefault())
        try {
            parsed = df_input.parse(inputDate)
            outputDate = df_output.format(parsed)
        } catch (e: ParseException) {
        }
        return outputDate.replace("am", "AM").replace("pm","PM")
    }

    fun shareintent(context: Context,content:String, msg:String="")
    {
         val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type="text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, msg+"\n"+content);
        context.startActivity(Intent.createChooser(shareIntent,"Share"))
    }
}