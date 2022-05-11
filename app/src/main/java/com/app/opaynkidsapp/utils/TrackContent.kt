package com.app.opaynkidsapp.utils

 enum class TrackContent
 {
     SPLASH(1, "splash"),
     WALKTHROUGH(2, "walkthrough"),
     LOGIN(3, "login"),
     SINGUP(4, "signup"),
     FORGOTPASSWORD(5, "forotPassword"),
     OTPVERFICATION(6, "otpVerificaton"),
     HOME(6, "home"),
     aboutUs(7, "aboutUs"),// end of the constants
     FAQ(8, "faq"),// end of the constants
     COURSES(9, "courses"),// end of the constants
     PACKAGES(10, "packages"),// end of the constants
     LIVECLASS(10, "liveClass"),// end of the constants
     FREETRIAL(10, "freeTrial"),// end of the constants
     PROFILe(10, "profile"),// end of the constants
     CHANGEPASSWORD(10, "changePassword"),// end of the constants
     COURSESEARCHRESULT(10, "coursesearchResult"),// end of the constants
     ContactUS(10, "contactUs"),// end of the constants
     CHECKOUT(10, "checkout"),// end of the constants
     WRITETEST(10, "writingTest"),// end of the constants
     READING(10, "readingTest"),// end of the constants
     SPEAKING(10, "speakingTest"),// end of the constants
     LISTENTEST(10, "listenTest"),// end of the constants
     VIDEOPLAY(10, "videoPlay"),// end of the constants
     CAPTURETEST(10, "captureTest"),// end of the constants
     TESTEMAILPOPUP(10, "testEmailPopup"),// end of the constants
     CLOSETEST(10, "closeTest"),// end of the constants
     PURCHASEHISTORY(10, "purchaseHistory"),// end of the constants
     RATEING(10, "rating"),// end of the constants
     FILTER(10, "filters"),// end of the constants
     NOTIFICATIONS(10, "notification"),// end of the constants
     ONLINECLASSDETAILS(10, "onlineClassDetails"),// end of the constants
     DASHBOARD(10, "dashBoard");// end of the constants
     // custom properties with default values
     var dayOfWeek: Int? = null
     var printableName : String? = null
     companion object{
         var screenname=""
     }

     constructor()

     // custom constructors
     constructor(
         dayOfWeek: Int,
         printableName: String
     ) {
         this.dayOfWeek = dayOfWeek
         this.printableName = printableName
         screenname=printableName
     }

     // custom method
     fun customToString(): String {
         screenname= printableName.toString()
         return "[${dayOfWeek}] -> $printableName"
     }
 }