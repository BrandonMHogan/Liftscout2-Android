package com.brandonhogan.liftscout.di.scopes

import javax.inject.Scope

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Scope used for fragment wide retention
 */

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope