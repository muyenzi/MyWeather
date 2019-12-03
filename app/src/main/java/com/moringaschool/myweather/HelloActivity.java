package com.moringaschool.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.myweather.adapter.WeatherForecastAdapter;

public class HelloActivity extends AppCompatActivity {

    private WeatherForecastAdapter forecastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        Intent intent= getIntent();
        String temp = getIntent().getStringExtra("temp");

        TextView temperature = (TextView)findViewById(R.id.temp);
        temperature.setText(temp);
    }
}
