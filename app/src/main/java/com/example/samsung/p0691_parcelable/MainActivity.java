package com.example.samsung.p0691_parcelable;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicButton(View view) {
        MyObject myObject = new MyObject(getString(R.string.text), 1);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MyObject.class.getCanonicalName(), (Parcelable) myObject);
        Log.d(LOG_TAG, getString(R.string.start_activity));
        startActivity(intent);
    }
}
