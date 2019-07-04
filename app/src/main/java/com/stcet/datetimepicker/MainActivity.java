package com.stcet.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    private int datePicked, monthPicked, yearPicked, hourPicked, minutePicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();
        textView = findViewById(R.id.dateTimeTextView);
        button = findViewById(R.id.buttonPicker);

        datePicked = calendar.get(Calendar.DAY_OF_MONTH);
        monthPicked = calendar.get(Calendar.MONTH);
        yearPicked = calendar.get(Calendar.YEAR);
        hourPicked = calendar.get(Calendar.HOUR);
        minutePicked = calendar.get(Calendar.MINUTE);

        setDate();

    }

    public void showDatePicker(View view) {

        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                yearPicked = year;
                monthPicked = month;
                datePicked = dayOfMonth;
                showTimePicker(view);
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener, yearPicked, monthPicked, datePicked);
        datePickerDialog.show();
    }

    public void showTimePicker(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hourPicked = hourOfDay;
                minutePicked = minute;
                setDate();
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hourPicked, minutePicked, false);
        timePickerDialog.show();

    }

    public void setDate() {
        textView.setText((datePicked + "/" + (monthPicked + 1) + "/" + yearPicked + " " + hourPicked + ":" + minutePicked));
    }
}
