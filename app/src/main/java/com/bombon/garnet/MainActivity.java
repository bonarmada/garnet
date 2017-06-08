package com.bombon.garnet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // assign singleton instances to fields
        // We need to cast to `MyApp` in order to get the right method

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
