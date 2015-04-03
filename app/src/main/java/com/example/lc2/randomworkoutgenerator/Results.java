package com.example.lc2.randomworkoutgenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LC2 on 24/03/2015.
 */
public class Results extends Activity {
    Intent intent= null;
    TextView timeDisplayed= null;
    long results = 0, min = 0, sec = 0;
    String time= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
    }

    public void onStart(){
        super.onStart();

        intent = getIntent();

        //Get the exercise time
        results= intent.getLongExtra("time", 0);

        //Only calculate if time is logged
        if(results > 0) {
            //Store min and seconds
            if (results >= 60) {
                min = results / 60;
                sec = results % 60;
            } else
                sec = results;

            //Format the string to display time properly
            time = Long.toString(min) + " min " + Long.toString(sec) + " s";

            timeDisplayed = (TextView) findViewById(R.id.results);
            timeDisplayed.setText(time);
        }
    }

    public void onClickShareResults(View view){
       //Social media integration
    }
}