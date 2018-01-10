package com.brandonhogan.liftscout.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.brandonhogan.liftscout.LiftApplication
import com.brandonhogan.liftscout.di.schedulers.AppSchedulerProvider
import com.brandonhogan.liftscout.di.schedulers.SchedulerProvider
import com.brandonhogan.liftscout.di.scopes.AppScope
import com.brandonhogan.liftscout.managers.PrefManager
import dagger.Module
import dagger.Provides

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Contains all the base application injectable classes
 */

@Module
class AppModule(var app: LiftApplication) {

    @AppScope
    @Provides
    fun provideApp(): LiftApplication = app

    @AppScope
    @Provides
    fun provideContext(): Context = app.applicationContext

    @AppScope
    @Provides
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @AppScope
    @Provides
    fun providePreferencesManager(sharedPreferences: SharedPreferences): PrefManager = PrefManager(app, sharedPreferences)

    @AppScope
    @Provides
    fun providerAppSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}