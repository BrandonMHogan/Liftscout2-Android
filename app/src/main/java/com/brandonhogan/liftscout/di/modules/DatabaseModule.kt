package com.brandonhogan.liftscout.di.modules

import android.content.Context
import com.brandonhogan.liftscout.di.scopes.AppScope
import dagger.Module
import dagger.Provides
import io.realm.Realm

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Modules used in the database layer of the application. The repo classes
 * are responsible for all database CRUD operations for their respected classes
 */

@Module
class DatabaseModule {

    /**
     * Creates an injectable module out of the realm default instance
     */
    @AppScope
    @Provides
    fun provideRealm(context: Context): Realm {
        Realm.init(context)
        return Realm.getDefaultInstance()
    }


//    @AppScope
//    @Provides
//    fun provideCategoryRepo(): CategoryRepo {
//        return CategoryRepoImpl()
//    }

}