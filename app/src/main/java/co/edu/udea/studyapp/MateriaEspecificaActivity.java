package co.edu.udea.studyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sickmartian.calendarview.CalendarView;
import com.sickmartian.calendarview.MonthView;
import com.sickmartian.calendarview.WeekView;

import java.util.Calendar;

public class MateriaEspecificaActivity extends AppCompatActivity {

    private static final String DAY_PARAMETER = "day";
    private  static final String MONTH_PARAMETER = "month";
    private  static final String YEAR_PARAMETER = "year";
    private static final String FIRST_DAY_OF_WEEK_PARAMETER = "firstDay";

    CalendarView mCalendarView;

    private int mYear;
    private int mDay;
    private int mMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_especifica);
        mCalendarView = (CalendarView) findViewById(R.id.monthView);
        int firstDayOfWeek = CalendarView.SUNDAY_SHIFT;
        setDateByStateDependingOnView();
        mCalendarView.setFirstDayOfTheWeek(firstDayOfWeek);
        mCalendarView.setCurrentDay(getCalendarForState());

    }

    public void setStateByCalendar(Calendar cal) {
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH) + 1; // We use base 1 months..
        // You should use joda time or a sane Calendar really
        mDay = cal.get(Calendar.DATE);
    }
    private void setDateByStateDependingOnView() {
        // The window of data shown depends on the view,
        // so there isn't a shared interface for this
        if (mCalendarView instanceof MonthView) {
            ((MonthView)mCalendarView).setDate(mMonth, mYear);
        } else {
            ((WeekView)mCalendarView).setDate(new CalendarView.DayMetadata(mYear, mMonth, mDay));
        }
    }

    private Calendar getCalendarForState() {
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setMinimalDaysInFirstWeek(1);
        newCalendar.setFirstDayOfWeek(Calendar.SUNDAY);
        newCalendar.set(Calendar.YEAR, mYear);
        newCalendar.set(Calendar.MONTH, mMonth - 1);
        newCalendar.set(Calendar.DATE, mDay);
        newCalendar.set(Calendar.HOUR_OF_DAY, 0);
        newCalendar.set(Calendar.MINUTE, 0);
        newCalendar.set(Calendar.SECOND, 0);
        newCalendar.set(Calendar.MILLISECOND, 0);
        return newCalendar;
    }
}
