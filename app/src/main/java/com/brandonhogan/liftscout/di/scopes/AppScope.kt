package com.brandonhogan.liftscout.di.scopes

import javax.inject.Scope

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Scope used for app wide retention
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope