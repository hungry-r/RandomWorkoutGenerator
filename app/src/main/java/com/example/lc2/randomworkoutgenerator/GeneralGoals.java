package com.example.lc2.randomworkoutgenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by LC2 on 18/02/2015.
 */
public class GeneralGoals extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_goals);
    }

    public void onClickLoseWeight(View view){
        Intent intent = new Intent(this, ExerciseList.class);
        startActivity(intent);
    }

    public void onClickIncreaseEndurance(View view){
        Intent intent = new Intent(this, ExerciseList.class);
        startActivity(intent);
    }

    public void onClickIncreaseStrength(View view){
        Intent intent = new Intent(this, ExerciseList.class);
        startActivity(intent);
    }
}
