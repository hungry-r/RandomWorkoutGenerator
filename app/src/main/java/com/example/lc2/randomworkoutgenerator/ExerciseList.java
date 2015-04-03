package com.example.lc2.randomworkoutgenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.URI;

/**
 * Created by LC2 on 12/03/2015.
 */

public class ExerciseList extends Activity {
    int request_Code = 1;
    long elapsedTime = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_list);
    }

    public void onClickExercise1(View view){
        Intent intent= new Intent(this, Exercise.class);
        startActivityForResult(intent, request_Code);
    }

    public void onClickExercise2(View view){
        Intent intent= new Intent(this, Exercise.class);
        startActivityForResult(intent, request_Code);
    }

    public void onClickExercise3(View view){
        Intent intent= new Intent(this, Exercise.class);
        startActivityForResult(intent, request_Code);
    }

    public void onClickExercise4(View view){
        Intent intent= new Intent(this, Exercise.class);
        startActivityForResult(intent, request_Code);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == request_Code){
            if(resultCode == RESULT_OK){
                elapsedTime+= data.getLongExtra("time", 0);
                Toast.makeText(this, Long.toString(elapsedTime), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onClickDoneExercising(View view){
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("time", elapsedTime);
        startActivity(intent);
    }
}