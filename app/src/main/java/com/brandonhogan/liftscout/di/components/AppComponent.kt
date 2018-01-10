package com.brandonhogan.liftscout.di.components

import com.brandonhogan.liftscout.di.modules.AppModule
import com.brandonhogan.liftscout.di.modules.DatabaseModule
import com.brandonhogan.liftscout.di.modules.ManagerModule
import com.brandonhogan.liftscout.di.schedulers.SchedulerProvider
import com.brandonhogan.liftscout.di.scopes.AppScope
import dagger.Component

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Component that injects the main application modules
 */

@AppScope
@Component(modules = arrayOf(AppModule::class, DatabaseModule::class))
interface AppComponent {

    val schedulerProvider: SchedulerProvider

}