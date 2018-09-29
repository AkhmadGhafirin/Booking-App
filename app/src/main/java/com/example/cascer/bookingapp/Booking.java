package com.example.cascer.bookingapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Booking implements Parcelable {

    private String mName, mClass, mPrice, mStation, mTime;
    private boolean mFull = false;

    public Booking(String mName, String mClass, String mPrice, String mStation, String mTime, boolean mFull) {
        this.mName = mName;
        this.mClass = mClass;
        this.mPrice = mPrice;
        this.mStation = mStation;
        this.mTime = mTime;
        this.mFull = mFull;
    }

    public String getmName() {
        return mName;
    }

    public String getmClass() {
        return mClass;
    }

    public String getmPrice() {
        return mPrice;
    }

    public String getmStation() {
        return mStation;
    }

    public String getmTime() {
        return mTime;
    }

    public boolean ismFull() {
        return mFull;
    }

    public static Creator<Booking> getCREATOR() {
        return CREATOR;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "mName='" + mName + '\'' +
                ", mClass='" + mClass + '\'' +
                ", mPrice='" + mPrice + '\'' +
                ", mStation='" + mStation + '\'' +
                ", mTime='" + mTime + '\'' +
                ", mFull=" + mFull +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mClass);
        dest.writeString(this.mPrice);
        dest.writeString(this.mStation);
        dest.writeString(this.mTime);
        dest.writeByte(this.mFull ? (byte) 1 : (byte) 0);
    }

    protected Booking(Parcel in) {
        this.mName = in.readString();
        this.mClass = in.readString();
        this.mPrice = in.readString();
        this.mStation = in.readString();
        this.mTime = in.readString();
        this.mFull = in.readByte() != 0;
    }

    public static final Creator<Booking> CREATOR = new Creator<Booking>() {
        @Override
        public Booking createFromParcel(Parcel source) {
            return new Booking(source);
        }

        @Override
        public Booking[] newArray(int size) {
            return new Booking[size];
        }
    };
}
