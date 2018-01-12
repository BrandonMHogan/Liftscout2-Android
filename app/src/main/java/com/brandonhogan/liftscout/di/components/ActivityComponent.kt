package com.brandonhogan.liftscout.di.components

import com.brandonhogan.liftscout.di.modules.NavigationModule
import com.brandonhogan.liftscout.di.schedulers.SchedulerProvider
import com.brandonhogan.liftscout.di.scopes.ActivityScope
import com.brandonhogan.liftscout.features.shared.main.MainActivity
import com.brandonhogan.liftscout.managers.NavigationManager
import dagger.Component

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Component that injects the presenters into activities
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(NavigationModule::class))
interface ActivityComponent {

    val schedulerProvider: SchedulerProvider
    val navigationManager: NavigationManager


    fun inject(mainActivity: MainActivity)

}