package com.brandonhogan.liftscout

import android.app.Application
import com.brandonhogan.liftscout.di.components.AppComponent
import com.brandonhogan.liftscout.di.components.DaggerAppComponent
import com.brandonhogan.liftscout.di.modules.AppModule
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     $PARAM$
 */

class LiftApplication: Application() {

    // The main component
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        /**
         * Data injection using dagger 2
         *
         * This is setup for application level module injection
         */
        initGlobalComponents()

        /**
         * Realm database setup
         */
        initRealm()

        /**
         * Timber logging setup
         */
        initTimber()
    }


    /**
     * Logging
     *
     * If in debug, will use a basic debug tree that only prints to the log console.
     *
     */
    private fun initTimber() {

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * Initializes the application level component
     */
    private fun initGlobalComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    /**
     * Builds the realm configuration and initializes the realm database
     */
    private fun initRealm() {
        Realm.init(this)

        // TODO: Swap the migration handling when closer to release
        val config0 = RealmConfiguration.Builder()
                .name("default.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                //.migration(Migration())
                .build()

        Realm.setDefaultConfiguration(config0)
    }

}