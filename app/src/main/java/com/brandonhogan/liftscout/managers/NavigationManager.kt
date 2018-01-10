package com.brandonhogan.liftscout.managers

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.brandonhogan.liftscout.R
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @Creator         bhogan
 * @Date            2018-01-06
 * @Description     Navigation manager to handle navigation logic for whatever fragment manager
 * is provided to it.
 */

class NavigationManager @Inject constructor(var fragmentManager: FragmentManager) {

    /**
     * These values are used for passing extras between fragments
     */
    val EXTRA_ID = "extraId"


    /**
     * Handles any deinit logic needed when an activity is swapped
     */
    fun onDestroy() {
    }

    /**
     * Handles fragment changes, using a basic animation.
     * @param f the new fragment that is to be displayed
     * @param cleanStack set to true if you want to clear the backstack before adding the new fragment
     * @param addFragment set to true if you want to add the fragment instead of replace
     */
    fun changeFragment(f: Fragment, cleanStack: Boolean = false, addFragment: Boolean = false) {

        fragmentManager?.let {
            it
        }


        val ft = fragmentManager.beginTransaction()

        if (cleanStack) {
            clearBackStack()
        }
//        ft.setCustomAnimations(
//                R.anim.fade_in, R.anim.fade_out, R.anim.popup_enter, R.anim.popup_exit)


        if (addFragment)
            ft.add(R.id.fragment_manager, f)
        else
            ft.replace(R.id.fragment_manager, f)


        ft.addToBackStack(null)
        ft.commit()
    }

    /**
     * Helper function for clearing the backstack
     */
    private fun clearBackStack() {

        if (fragmentManager.backStackEntryCount > 0) {
            val first = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    /**
     * Pops the backstack of the current fragment manager if the stack is larger then one.
     *  Returns true if you have reached the bottom of the stack (pos 1)
     */
    fun onBackPressed(): Observable<Boolean> {

        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStack()
        } else {
            return Observable.just(true)
        }

        return Observable.just(false)
    }

    fun isOnRoot(): Observable<Boolean> {
        return Observable.just(fragmentManager.backStackEntryCount == 1)
    }


    /**
     * Helper functions to keep any setup logic in one place when swapping to different fragments
     */


    /**
     * User data management
     */

//    fun showSettings() {
//        changeFragment(SettingsFragment.newInstance(), false)
//    }


}