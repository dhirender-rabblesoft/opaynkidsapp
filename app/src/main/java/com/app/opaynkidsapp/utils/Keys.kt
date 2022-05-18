package com.app.opaynkidsapp.utils
object Keys
{

    var isSubmit: Boolean = false
    var startx: Float = 0.0f
    var starty: Float = 0.0f
    var endx: Float = 0.0f
    var endy: Float = 0.0f
    val LIVECLASS: String = "LIVECLASS"
    //http://5f91-210-89-39-70.ngrok.io/opaynly-api/public/api/app-info
//    const val  BASEURL="https://d077-210-89-39-190.ngrok.io/ielts-app/public/api/"
    const val  BASEURL="https://0638-210-89-39-70.ngrok.io/ielts-app/public/api/"
    // const val  BASEURL="http://staging-api.opayl.com/api/"
   // const val  BASEURL="https://api.opayl.com/api/"
    const val  STAGINGBASEURL="http://staging-api.opayl.com/api/"
    const val  LIVEURL="https://api.opayl.com/api/"
    // const val  BASEURL="https://a5ee-210-89-39-70.ngrok.io/ielts-app/public/api/"
    const val  CDNIMAGE_URL="https://d1rl21n2nalbcq.cloudfront.net/assets/"
    var APP_BASE_URL1= BASEURL
    val  IMAGEBASEURL= LIVEURL
    /*RESPONSE CODE*/
    val RESPONSE_SUCESS = 200
    val ERRORCODE = 412
    val UNAUTHoRISE = 401
     /*Fragment Value*/
    val CHECKOUTFRAG=1
    const val  SAVE_URL_KEY="saveurl"
    const val device_id = "device_id"
    const val screen_name = "screen_name"
    const val FROM = "from"
    var email_verify = "email-verify"
    /*End points*/


    /*GUEST KEYS*/
    const val GUEST = "1"
    const val NOTGUEST = "2"

    // to store ielets type   e.g acdamic or genral


    /*saved keys*/
    const val USERDATA = "userdata"
    const val  TOKEN = "token"
    const val GUESTUSER = "guestuser"
    const val USERID = "userid"


    /*parms Keys*/


}
