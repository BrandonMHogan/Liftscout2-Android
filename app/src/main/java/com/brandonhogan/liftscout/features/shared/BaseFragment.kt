package com.brandonhogan.liftscout.features.shared

import android.support.v4.app.Fragment
import io.reactivex.disposables.Disposable
import timber.log.Timber

/**
 * @Creator         bhogan
 * @Date            2018-01-12
 * @Description     Base fragment in which all fragments inherit from. Handles the
 *  shared logic between all fragments.
 */

abstract class BaseFragment: Fragment() {

    val disposables = ArrayList<Disposable>()

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
}