package com.example.group08_finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchFunction extends AppCompatActivity {
    private EditText start;
    private EditText dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_function);

        start = (EditText) findViewById(R.id.editText);
        dest = (EditText) findViewById(R.id.editText2);
    }

    public void readInfo(View view) {
        String s = start.getText().toString();
        String d = dest.getText().toString();

        
    }
}
