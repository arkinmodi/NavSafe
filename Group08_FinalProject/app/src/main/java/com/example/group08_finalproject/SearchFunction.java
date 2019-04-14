package com.example.group08_finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SearchFunction extends AppCompatActivity {
    private EditText start;
    private EditText dest;
    private static final String LOG_TAG = SearchFunction.class.getSimpleName();
    public static boolean press;
    public static String s;
    public static String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_function);

        start = (EditText) findViewById(R.id.editText);
        dest = (EditText) findViewById(R.id.editText2);
        press = false;
    }

    public void readInfo(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        s = start.getText().toString();
        d = dest.getText().toString();

        press = true;
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
