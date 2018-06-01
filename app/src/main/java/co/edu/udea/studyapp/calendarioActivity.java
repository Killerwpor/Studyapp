package co.edu.udea.studyapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.desai.vatsal.mydynamiccalendar.MyDynamicCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import co.edu.udea.studyapp.data.ApunteContract;
import co.edu.udea.studyapp.data.Materia;
import co.edu.udea.studyapp.data.MateriaContract;
import co.edu.udea.studyapp.data.dbHelper;

public class calendarioActivity extends AppCompatActivity {


    MyDynamicCalendar myCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        myCalendar= new MyDynamicCalendar(this);
        myCalendar.setCalendarBackgroundColor("#eeeeee");
        myCalendar.setHeaderBackgroundColor("#454265");
        myCalendar.setHeaderTextColor("#ffffff");
        myCalendar.setNextPreviousIndicatorColor("#245675");
        myCalendar.setWeekDayLayoutBackgroundColor("#965471");
        myCalendar.setWeekDayLayoutTextColor("#246245");
        myCalendar.setExtraDatesOfMonthBackgroundColor("#324568");
        myCalendar.setExtraDatesOfMonthTextColor("#756325");
        myCalendar.setDatesOfMonthBackgroundColor("#145687");
        myCalendar.setDatesOfMonthTextColor("#745632");
        myCalendar.setCurrentDateBackgroundColor(R.color.black);
        myCalendar.setCurrentDateTextColor("#00e600");
        myCalendar.setBelowMonthEventTextColor("#425684");
        myCalendar.setBelowMonthEventDividerColor("#635478");
        myCalendar.setEventCellBackgroundColor("#852365");
        myCalendar.setEventCellTextColor("#425684");
       // myCalendar.addEvent("2-06-2018", "8:00", "8:15", "Foto"); //de aquí se agrega un evento


      //  Log.d("FECHA","Fecha: "+date);
        dbHelper db = new dbHelper(getApplicationContext());
        Cursor c=db.obtenerTodosLasFechasApuntes();

        while (c.moveToNext()) { //se marca en el calendario la fecha del apunte tomado //se pintan todas las fechas del calendario con algun apunte en esa fecha
           String fecha = c.getString(c.getColumnIndex(ApunteContract.ApunteEntry.FECHA));
            String titulo = c.getString(c.getColumnIndex(ApunteContract.ApunteEntry.TITULO));
            myCalendar.addEvent(fecha, "8:00", "8:15", titulo);
        }
        myCalendar.showMonthView();
    }
}
