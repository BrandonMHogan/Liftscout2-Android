package com.brandonhogan.liftscout.di.modules

import android.support.v4.app.FragmentManager
import com.brandonhogan.liftscout.di.scopes.ActivityScope
import com.brandonhogan.liftscout.managers.NavigationManager
import dagger.Module
import dagger.Provides

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Module for the navigation manager
 */

@Module
class NavigationModule(var fragmentManager: FragmentManager) {

    @ActivityScope
    @Provides
    fun navigationManager(): NavigationManager {
        return NavigationManager(fragmentManager)
    }

}