package com.brandonhogan.liftscout.features.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.brandonhogan.liftscout.R
import com.brandonhogan.liftscout.features.shared.BaseActivity
import com.brandonhogan.liftscout.managers.NavigationManager
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2018-01-12
 * @Description     $PARAM$
 */

class MainActivity : BaseActivity(), FragmentManager.OnBackStackChangedListener {

    lateinit var model: MainViewModel

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        if(savedInstanceState == null) {
            navigationManager.showCalendar()
        }
    }

    override fun onBackPressed() {
        navigationManager.onBackPressed()
                .subscribe { shouldFinish ->
                    if(shouldFinish)
                        finish()
                }
    }

    override fun onBackStackChanged() {
//        if(supportFragmentManager.backStackEntryCount > 1) {
//
//            drawer?.actionBarDrawerToggle!!.isDrawerIndicatorEnabled = false
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)// show back button
//            main_toolbar.setNavigationOnClickListener{ onBackPressed() }
//
//        }
//        else {
//
//            //show hamburger
//            drawer?.actionBarDrawerToggle!!.isDrawerIndicatorEnabled = true
//            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
//            drawer?.actionBarDrawerToggle!!.syncState()
//
//            resetTitle()
//            main_toolbar.setNavigationOnClickListener {
//
//                if(drawer!!.isDrawerOpen)
//                    drawer!!.closeDrawer()
//                else
//                    drawer!!.openDrawer()
//            }
//
//        }
    }
}
