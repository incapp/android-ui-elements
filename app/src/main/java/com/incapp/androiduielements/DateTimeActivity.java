package com.incapp.androiduielements;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeActivity extends AppCompatActivity {

    SimpleDateFormat simpleDateFormat;
    SimpleDateFormat simpleTimeFormat;

    Button buttonDate, buttonTime;
    TextView textViewDate, textViewTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.US);
        simpleTimeFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);

        buttonDate = findViewById(R.id.button_date);
        buttonTime = findViewById(R.id.button_time);
        textViewDate = findViewById(R.id.textView_date);
        textViewTime = findViewById(R.id.textView_time);

        //For Date
        buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();

                final DatePickerDialog datePickerDialog = new DatePickerDialog(
                        DateTimeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                Date date = new Date(
                                        year - 1900,
                                        month,
                                        dayOfMonth
                                );
                                textViewDate.setText(simpleDateFormat.format(date));
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );

                datePickerDialog.show();
            }
        });

        //For Time
        buttonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();

                final TimePickerDialog timePickerDialog = new TimePickerDialog(
                        DateTimeActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Date date = new Date(
                                        calendar.get(Calendar.YEAR),
                                        calendar.get(Calendar.MONTH),
                                        calendar.get(Calendar.DAY_OF_MONTH),
                                        hourOfDay,
                                        minute,
                                        calendar.get(Calendar.SECOND));
                                textViewTime.setText(simpleTimeFormat.format(date));
                            }
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true
                );

                timePickerDialog.show();
            }
        });
    }
}
