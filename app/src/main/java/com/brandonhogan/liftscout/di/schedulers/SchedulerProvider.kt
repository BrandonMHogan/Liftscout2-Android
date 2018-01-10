package com.brandonhogan.liftscout.di.schedulers

import io.reactivex.Scheduler

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Interface used for passing the scheduler into presenters and managers
 */

interface SchedulerProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}