package com.brandonhogan.liftscout.features.calendar

import android.arch.lifecycle.ViewModel
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

/**
 * @Creator         bhogan
 * @Date            2018-01-10
 * @Description     ViewModel for the menu_calendar activity
 */

class CalendarViewModel : ViewModel() {


    /**
     * State for the calendar view.
     */
    private var calendarState: Int = 0

    /**
     * Private properties for calendar state swapping
     */
    private val CALENDAR_MONTH = 0
    private val CALENDAR_WEEK = 1


    /**
     * Function to setup the calendar defaults and preset values
     */
    fun setCalendar(calendarView: MaterialCalendarView, isMonthView: Boolean = true) {

        calendarState = if (isMonthView) CALENDAR_MONTH else CALENDAR_WEEK

        calendarView.isDynamicHeightEnabled = true
        //calendarView.setTileHeightDp(30)

        calendarView.state().edit()
                .setMinimumDate(CalendarDay.from(2014, 4, 3))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit()
    }


    /**
     * Toggles the calendar view from Month size, to Week size.
     */
    fun onCalendarToggle(calendarView: MaterialCalendarView) {
        when (calendarState) {
            0 -> {
                calendarState = CALENDAR_WEEK
                calendarView.state().edit()
                        .setCalendarDisplayMode(CalendarMode.WEEKS)
                        .commit()
            }
            else -> {
                calendarState = CALENDAR_MONTH
                calendarView.state().edit()
                        .setCalendarDisplayMode(CalendarMode.MONTHS)
                        .commit()

            }
        }
    }

}