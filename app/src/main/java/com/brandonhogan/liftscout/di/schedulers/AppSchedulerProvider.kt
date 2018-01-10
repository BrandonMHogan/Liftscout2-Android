package com.brandonhogan.liftscout.di.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Scheduler for the main application, implementing the correct threading scheme
 * so that we can easily set the correct threading strategies for observables
 */

class AppSchedulerProvider : SchedulerProvider {
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun trampoline(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun newThread(): Scheduler {
        return Schedulers.newThread()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }
}