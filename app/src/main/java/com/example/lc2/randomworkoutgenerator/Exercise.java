package com.example.lc2.randomworkoutgenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

/**
 * Created by LC2 on 12/03/2015.
 */
public class Exercise extends Activity {
    Chronometer chronometer;
    long elapsedTime;
    boolean started;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        elapsedTime = -1;
        started= false;
    }

    public void onClickStartTimer(View view){
        if(!started) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            started= true;
            elapsedTime= 0;
        }
        else{
            chronometer.stop();
            //Divided by 1000 to go from milliseconds to seconds
            elapsedTime = (SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000;
            started= false;
            //Toast.makeText(this, Long.toString(elapsedTime), Toast.LENGTH_LONG).show();
        }
    }

    public void onClickSaveTime(View view){
        if (elapsedTime == -1){
            Toast.makeText(this, "Start the timer first to record a time", Toast.LENGTH_SHORT).show();
        }
        else if(elapsedTime < 1){
            Toast.makeText(this, "Please stop the timer first", Toast.LENGTH_SHORT).show();
        }
        else {
            //Submit data back to the previous activity
            Intent data = new Intent();
            data.putExtra("time", elapsedTime);
            setResult(RESULT_OK, data);
            finish();
        }
    }
}
