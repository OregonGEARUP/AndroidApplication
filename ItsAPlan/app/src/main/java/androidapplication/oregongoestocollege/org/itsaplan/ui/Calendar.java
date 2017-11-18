package androidapplication.oregongoestocollege.org.itsaplan.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.util.Log;
import android.widget.TextView;


import androidapplication.oregongoestocollege.org.itsaplan.R;

/**
 * Created by Bikram Maharjan on 11/15/17.
 */

public class Calendar extends AppCompatActivity{
    private static final String TAG = "CalendarUI";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mDisplayDate = (TextView)  findViewById(R.id.selectDate);


        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);

            }
        });
    }


}
