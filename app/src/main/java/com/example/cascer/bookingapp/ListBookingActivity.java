package com.example.cascer.bookingapp;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListBookingActivity extends AppCompatActivity {

    @BindView(R.id.rv_listbooking)
    RecyclerView mRecyclerView;

    BookingAdapter bookingAdapter;
    ArrayList<Booking> bookingList;

    PemesananFragment pemesananFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_booking);
        ButterKnife.bind(this);

        pemesananFragment = new PemesananFragment();

        bookingList = new ArrayList<>();
        bookingList.add(new Booking("GajahWong", "Ekonomi", "IDR 220.000"
                , "PSE - LPN", "06:45 - 15:00", false));
        bookingList.add(new Booking("Taksaka", "Eksekutif", "IDR 380.000"
                , "GMR - YK", "08:00 -15:39", false));
        bookingList.add(new Booking("Bima", "Eksekutif", "IDR 390.000"
                , "GMR - YK", "16:30 -00:40", false));
        bookingList.add(new Booking("Singasari", "Ekonomi", "IDR 225.000"
                , "PSE - LPN", "12:25 - 21:23", false));
        bookingList.add(new Booking("Bogowonto", "Ekonomi", "IDR 220.000"
                , "PSE - LPN", "21:45 - 05:52", false));
        bookingList.add(new Booking("Mataram Premium", "Ekonomi", "Penuh"
                , "PSE - LPN", "21:15 - 05:17", true));
        bookingList.add(new Booking("Gajayana", "Eksekutif", "Penuh"
                , "GMR - YK", "17:40 - 01:47", true));
        bookingList.add(new Booking("Bengawan", "Ekonomi", "Penuh"
                , "PSE - LPN", "11:45 - 19:00", true));
        bookingList.add(new Booking("Progo", "Ekonomi", "Penuh"
                , "PSE - LPN", "22:45 - 06:45", true));
        bookingList.add(new Booking("Jaka Tingkir", "Ekonomi", "Penuh"
                , "PSE - LPN", "12:00 - 20:41", true));


        bookingAdapter = new BookingAdapter(this, new BookingAdapter.onClickListener() {
            @Override
            public void onClick(Booking booking) {

                if (booking.ismFull() == false) {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", booking.getmName());
                    bundle.putString("class", booking.getmClass());
                    bundle.putString("price", booking.getmPrice());
                    bundle.putString("station", booking.getmStation());
                    bundle.putString("time", booking.getmTime());
                    bundle.putBoolean("full", booking.ismFull());
                    pemesananFragment.setArguments(bundle);
                    pemesananFragment.show(getSupportFragmentManager(), pemesananFragment.getTag());
                } else {
                    Toast.makeText(ListBookingActivity.this, "Kereta Penuh",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        mRecyclerView.setAdapter(bookingAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookingAdapter.addAll(bookingList);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
