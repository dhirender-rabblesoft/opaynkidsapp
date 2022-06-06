package com.app.opaynkidsapp.model

data class RightMatchListingModel(val id: Int,val img_url :String, val name: String, var isRight:Boolean= false, var isSelect:Boolean = false,var matchquestionid:Int=-1,var selectquestionid:Int=-1 )