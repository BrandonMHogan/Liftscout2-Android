package com.brandonhogan.liftscout.features.calendar

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brandonhogan.liftscout.R
import com.brandonhogan.liftscout.features.shared.BaseFragment
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import kotlinx.android.synthetic.main.frag_calendar.*


class CalendarFragment : BaseFragment() {

    lateinit var model: CalendarViewModel

    companion object {
        fun newInstance(): CalendarFragment {
            return CalendarFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProviders.of(this).get(CalendarViewModel::class.java)

        calendar_view.state().edit()
                .setMinimumDate(CalendarDay.from(2014, 4, 3))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit()

        model.calendarState = 0

        button.setOnClickListener {

            when(model.calendarState) {
                0 -> {
                    model.calendarState = 1
                    calendar_view.state().edit()
                            .setCalendarDisplayMode(CalendarMode.WEEKS)
                            .commit()
                }
                else -> {
                    model.calendarState = 0
                    calendar_view.state().edit()
                            .setCalendarDisplayMode(CalendarMode.MONTHS)
                            .commit()

                }
            }
        }
    }
}
