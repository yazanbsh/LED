package com.example.yazan.led;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class Colors extends AppCompatActivity {
    int redValue=0,greenValue=0,blueValue=0;
    String RGB="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final TextView ledsColorTV= (TextView) findViewById(R.id.ledsColorTV);
        SeekBar redSeekBar= (SeekBar) findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar= (SeekBar) findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar= (SeekBar) findViewById(R.id.blueSeekBar);

        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue=progress;
                ledsColorTV.setTextColor(Color.rgb(redValue,greenValue,blueValue));
                RGB=redValue+","+greenValue+","+blueValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue=progress;
                ledsColorTV.setTextColor(Color.rgb(redValue,greenValue,blueValue));
                RGB=redValue+","+greenValue+","+blueValue;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue=progress;
                ledsColorTV.setTextColor(Color.rgb(redValue,greenValue,blueValue));
                RGB=redValue+","+greenValue+","+blueValue;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void applyBtnOnClick(View view) {
        Toast.makeText(getBaseContext(),"values: "+RGB,Toast.LENGTH_LONG).show();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",RGB);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

    public void backBtnOnClick(View view) {
        finish();
    }

}
