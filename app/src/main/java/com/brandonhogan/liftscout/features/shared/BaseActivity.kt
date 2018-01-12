package com.brandonhogan.liftscout.features.shared

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.brandonhogan.liftscout.LiftApplication
import com.brandonhogan.liftscout.di.components.ActivityComponent
import com.brandonhogan.liftscout.di.components.DaggerActivityComponent
import com.brandonhogan.liftscout.di.modules.NavigationModule
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2018-01-12
 * @Description     Base Activity components and shared logic between the activities
 */

abstract class BaseActivity : AppCompatActivity() {

    lateinit var activityComponent: ActivityComponent
        private set

    val disposables = ArrayList<Disposable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityComponent()
    }

    /**
     * Will loop through and dispose of any subscribes still in use
     *  Should be called from the presenter's onDestroyView
     */
    override fun onPause() {
        super.onPause()

        for(disposable in disposables) {
            disposable.dispose()
            Timber.d("Subscribe was disposed ${disposable.isDisposed}")
        }
    }

    /**
     * Initializes the activity component for dagger 2, which allows
     * the injection of the presenter
     */
    private fun initActivityComponent() {
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as LiftApplication).appComponent)
                .navigationModule(NavigationModule(supportFragmentManager))
                .build()
    }
}