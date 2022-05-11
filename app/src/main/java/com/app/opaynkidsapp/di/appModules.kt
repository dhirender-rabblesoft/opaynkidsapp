package com.app.opaynkidsapp.di

import com.app.opaynkidsapp.utils.NetworkCheck
import com.app.opaynkidsapp.utils.SharedPreferenceManager

import org.koin.android.ext.koin.androidContext
 import org.koin.dsl.module.module


private val dataModule = module {


    single {
        NetworkCheck(androidContext().applicationContext)
    }
    single {
        SharedPreferenceManager(androidContext().applicationContext)
    }

}
val appModules = listOf(dataModule)
