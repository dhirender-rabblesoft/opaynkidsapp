package com.app.opaynkidsapp.network

import com.google.gson.JsonObject
 import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET
import java.util.ArrayList


interface APIInterface {

//    @Headers("Accept: application/json")
//    @POST
//    fun login(@Url url: String, @Body jsonObject: JsonObject?): Call<SignupModel>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun splashcontent(@Url url: String?): Call<SplashJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun sendEmail(@Url url: String?, @Body jsonObject: JsonObject?): Call<OtpJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun signup(@Url url: String?, @Body jsonObject: RequestBody?): Call<SignupModel>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun forgot(@Url url: String?, @Body jsonObject: JsonObject?): Call<VerifyJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun resetpassword(@Url url: String, @Body jsonObject: JsonObject?): Call<VerifyJson>?
//
//    @POST
//    fun changepassword(
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Url url: String,
//        @Body jsonObject: JsonObject?
//    ): Call<ResponseBody>?
//
//    @POST
//    fun buycourse(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Body jsonObject: JsonObject?
//    ): Call<BuyCourseJson>?
//
//    @POST
//    fun buyclass(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Body jsonObject: JsonObject?
//    ): Call<BuyLiveClassJson>?
//
//    @POST
//    fun addfav(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Body jsonObject: JsonObject?
//    ): Call<ResponseBody>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun preferences(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String
//    ): Call<NotificationPreferenceJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun emailverify(@Url url: String, @Body jsonObject: JsonObject?): Call<VerifyJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun resendcode(
//        @Url url: String,
//        @Body jsonObject: JsonObject?
//    ): Call<VerifyJson>?
//
//    @GET
//    fun genralcontent(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Query("type") type: String
//    ): Call<ResponseBody>?
//    @Headers("Accept: application/json")
//    @GET
//    fun faq_category(
//        @Url url: String,
//    ): Call<FaqCategoryJson>?
//
//    @GET
//    fun appinfo(
//        @Url url: String,
//        @Header("Accept") accept: String,
//    ): Call<AppUpdateJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun mentorreviews(
//        @Url url: String
//    ): Call<MentorReviews>?
//
//    @Headers("Accept: application/json")
//
//    @GET
//    fun departments(
//        @Url url: String,
//        @Query("type") type: String
//    ):
//            Call<ResponseBody>?
//
//
//    @GET
//    fun wishlist(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Query("type") type: String
//    ): Call<FavlistJson>?
//
//    @POST
//    fun review(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Body jsonObject: JsonObject?
//    ): Call<ResponseBody>?
//
//
//    @Headers("Accept: application/json")
//    @GET
//    fun teams(@Url url: String): Call<TeamJson>?
//
//    @GET
//    fun faq(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String
//    ): Call<FaqJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun sliderListing(@Url url: String): Call<HomeScreenJson>?
//    @Headers("Accept: application/json")
//    @GET
//    fun freeclassListing(@Url url: String): Call<HomeFreeClassesJson>?
//    @Headers("Accept: application/json")
//    @GET
//    fun testimonials(@Url url: String): Call<TestimonialJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun servicedetail(@Url url: String): Call<IeltsPreprationJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun categorydetail(@Url url: String): Call<IeltsReadingJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun testdetail(@Url url: String): Call<QuestionAnserJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun notificationlist(
//        @Url url: String,
//        @Header("Authorization") token: String,
//        @Query("page") page: String
//    ): Call<NotificationJson>?
//
//    @Headers("Accept: application/json")
//    @DELETE
//    fun deletenotification(
//        @Header("Authorization") token: String,
//        @Url url: String
//    ): Call<ResponseBody>?
//    @Headers("Accept: application/json")
//    @GET
//    fun deletereason(
//        @Url url: String
//    ): Call<DeleteReasonJson>?
//
//    @Headers("Accept: application/json")
//    @HTTP(method = "DELETE" , hasBody = true)
//    fun deleteRequestBody(@Url url: String,  @Header("Authorization") token: String,@Body map: RequestBody) : Call<ResponseBody>
//
//
//    @Headers("Accept: application/json")
//    @GET
//    fun coursedetail(@Url url: String, @Query("keyword") type: String): Call<CourseListJson>?
//
//    @Multipart
//    @Headers("Accept: application/json")
//    @POST
//    fun sendmessage(
//        @Url url: String,
//        @Header("Authorization") token: String,
//        @Part fields: ArrayList<MultipartBody.Part>
//    ): Call<ResponseBody>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun messagelisting(
//        @Url url: String,
//        @Header("Authorization") token: String,
//        @Query("course_id") type: String
//    ): Call<ResponseBody>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun onlineclassmessagelisting(
//        @Url url: String, @Header("Authorization") token: String,
//        @Query("online_class_id") type: String,
//        @Query("page") page: String
//    ): Call<ResponseBody>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun couponlisting(
//        @Url url: String,
//        @Header("Authorization") token: String,
//    ): Call<Couponlisting>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun categorylist(
//        @Url url: String,
//        @Header("Authorization") token: String,
//    ): Call<CategoryJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun paymentlist(
//        @Url url: String,
//        @Header("Authorization") token: String
//    ): Call<PaymentListJson2>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun packagesdetail(@Url url: String): Call<PackagesJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun packagecourseListdetail(@Url url: String): Call<PackageCourseListJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun classlist(
//        @Url url: String,
//        @Query("page") page: String,
//        @Query("keyword") keyword: String,
//        @Query("sort_by") sort_by: String,
//        @Query("services") services: String,
//        @Query("min_time") min_time: String,
//        @Query("max_time") max_time: String,
//        @Query("class_shift") class_shift: String,
//        @Query("price") price: String,
//        @Query("rating") rating: String,
//        @Query("timezone") timezone: String
//    ): Call<LiveClassJson>?
// @Headers("Accept: application/json")
//    @GET
//    fun resultlist(
//        @Url url: String,
//        @Header("Authorization") accept: String,
//        @Query("page") page: String,
//        @Query("category") keyword: String
//    ): Call<TestResultJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun classDetail(@Url page: String): Call<LiveClassDetailJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun checkout(
//        @Url page: String,
//        @Header("Authorization") accept: String,
//        @Body jsonObject: JsonObject
//    ): Call<BookJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun paidpackagedetail(@Url url: String): Call<PaidPackDetailJson>?
//
//
//    @GET
//    fun dashboard(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//    ): Call<ResponseBody>?
//
//    @GET
//    fun mypackages(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//    ): Call<MyPackagesJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun courselisting(
//        @Url url: String,
//        @Query("service_id") type: String,
//        @Query("rating") rate: String,
//        @Query("sort_by") sort_by: String,
//        @Query("price") price: String,
//        @Query("keyword") keyword: String,
//    ): Call<CourseListingJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun videodetail(@Url url: String): Call<VideoPlayerJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun filter(@Url url: String): Call<FilterJson>?
//
//    @Headers("Accept: application/json")
//    @GET
//    fun mentordetails(@Url url: String): Call<MentorDetailJson>?
//
//    @Multipart
//    @POST
//    fun updateuser(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Header("Authorization") token: String,
//        @Part fields: ArrayList<MultipartBody.Part>
//    ): Call<SignupModel>
//
//    @Headers("Accept: application/json")
//    @POST
//    fun submtitest(@Url url: String, @Body map: RequestBody): Call<ResponseBody>?
//    @Headers("Accept: application/json")
//    @POST
//    fun savetest(@Url url: String, @Body map: RequestBody): Call<TestSaveJson>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun commonpost(
//        @Url url: String,
//        @Header("Authorization") token: String,
//        @Body jsonObject: JsonObject
//    ): Call<ResponseBody>?
//
//    @Headers("Accept: application/json")
//    @POST
//    fun track(@Body jsonObject: JsonObject): Call<ResponseBody>?
//
//    @Multipart
//    @POST
//    fun submtitestwithimage(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Part fields: ArrayList<MultipartBody.Part>
//    ): Call<TestSaveJson>
//
//    @Multipart
//    @Headers("Accept: application/json")
//    @POST
//    fun contactUs(
//        @Url url: String,
//        @Header("Accept") accept: String,
//        @Part fields: ArrayList<MultipartBody.Part>
//    ): Call<ZohoJson>?

}