package com.example.lc2.randomworkoutgenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.List;
import android.widget.ArrayAdapter;


public class MainActivity extends Activity {
        private WorkoutsDataSource datasource;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            datasource = new WorkoutsDataSource(this);
            datasource.open();

            List<Workouts> values = datasource.getAllComments();

            if (values.size()==0 ) {
                // save the new comment to the database
                Workouts w1 = datasource.createWorkout("Workout Test 1");
                Workouts w2 = datasource.createWorkout("Workout Test 2");
                Workouts w3 = datasource.createWorkout("Workout Test 3");
            }
        }

    public void onClickBMI(View view){
        Intent intent = new Intent(this, BMICalc.class);
        startActivity(intent);
    }

    public void onClickGoals(View view){
        Intent intent = new Intent(this, GeneralGoals.class);
        startActivity(intent);
    }
}
