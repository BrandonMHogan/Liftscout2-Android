package com.brandonhogan.liftscout.features.calendar

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import com.brandonhogan.liftscout.R
import com.brandonhogan.liftscout.features.shared.base.BaseFragment
import kotlinx.android.synthetic.main.frag_calendar.*

/**
 * @Creator         bhogan
 * @Date            2018-01-10
 * @Description     Displays the day to day exercises and routines in a week or month based
 * display.
 */

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProviders.of(this).get(CalendarViewModel::class.java)
        model.setCalendar(calendar_view)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_calendar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.action_calendar -> {
                model.onCalendarToggle(calendar_view)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
