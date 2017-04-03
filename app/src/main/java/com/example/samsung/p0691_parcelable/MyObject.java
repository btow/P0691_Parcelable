package com.example.samsung.p0691_parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by samsung on 03.04.2017.
 */

public class MyObject implements Parcelable {

    final static String LOG_TAG = "myLogs";

    public String s;
    public int i;

    //Обычный конструктор
    public MyObject(String s, int i) {
        Log.d(LOG_TAG, "MyObject(String s, int i)");
        this.s = s;
        this.i = i;
    }
    //Конструктор, считывающий данные из Parcel
    public MyObject(Parcel source) {
        Log.d(LOG_TAG, "MyObject(Parcel source)");
        this.s = source.readString();
        this.i = source.readInt();
    }

    public int describeContents() {
        return 0;
    }
    //Упаковка объекта в Parcel
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(LOG_TAG, "writeToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>() {
        //Распаковка объекта из Parcel
        @Override
        public MyObject createFromParcel(Parcel source) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObject(source);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };
}
