package com.example.cascer.bookingapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.et_setdatepicker)
    EditText etSet;
    @BindView(R.id.btn_search)
    Button btnSerach;

    String tgl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        etSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener mDate = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        int mYear = calendar.get(Calendar.YEAR);
                        int mMonth = calendar.get(Calendar.MONTH) + 1;
                        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
                        etSet.setText(mDay + "-" + mMonth + "-" + mYear);
                        /*etSet.setText(new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault())
                                .format(calendar.getTime()));*/
                        /*Log.d(TAG, "calendar: " + new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault())
                                .format(calendar.getTime()));*/
                    }
                };

                Calendar nowCalendar = Calendar.getInstance();
                int year = nowCalendar.get(Calendar.YEAR);
                int month = nowCalendar.get(Calendar.MONTH);
                int day = nowCalendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this
                        , mDate, year, month, day);

                datePickerDialog.setTitle("Pilih Tanggal");
                datePickerDialog.show();
            }
        });

        tgl = String.valueOf(etSet.getText());

        if (tgl == null) {
            btnSerach.setEnabled(false);
            btnSerach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        } else {
            btnSerach.setEnabled(true);
            btnSerach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, ListBookingActivity.class));
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
