package com.example.samsung.p0691_parcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    MyObject myObject;
    TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Log.d(LOG_TAG, getString(R.string.get_parcelable_extra));

        myObject = (MyObject) getIntent().getParcelableExtra(
                MyObject.class.getCanonicalName()        );

        String message = getString(R.string.my_obj) + myObject.s + getString(R.string.comma) + myObject.i;

        tvSecond = (TextView) findViewById(R.id.tvSecond);
        tvSecond.setText(tvSecond.getText().toString() + "\n" + message);

        Log.d(LOG_TAG, message);
    }
}
