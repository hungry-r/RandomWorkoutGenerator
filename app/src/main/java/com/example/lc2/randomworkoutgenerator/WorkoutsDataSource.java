package com.example.lc2.randomworkoutgenerator;

/**
 * Created by Hyungryul on 4/1/2015.
 */

    import java.util.ArrayList;
    import java.util.List;

    import android.content.ContentValues;
    import android.content.Context;
    import android.database.Cursor;
    import android.database.SQLException;
    import android.database.sqlite.SQLiteDatabase;

public class WorkoutsDataSource {

        // Database fields
        private SQLiteDatabase database;
        private MySqlLiteHelper dbHelper;
        private String[] allColumns = { MySqlLiteHelper.COLUMN_ID,
                MySqlLiteHelper.COLUMN_COMMENT };

        public WorkoutsDataSource(Context context) {
            dbHelper = new MySqlLiteHelper(context);
        }

        public void open() throws SQLException {
            database = dbHelper.getWritableDatabase();
        }

        public void close() {
            dbHelper.close();
        }

        public Workouts createWorkout(String comment) {
            ContentValues values = new ContentValues();
            values.put(MySqlLiteHelper.COLUMN_COMMENT, comment);
            long insertId = database.insert(MySqlLiteHelper.TABLE_COMMENTS, null,
                    values);
            Cursor cursor = database.query(MySqlLiteHelper.TABLE_COMMENTS,
                    allColumns, MySqlLiteHelper.COLUMN_ID + " = " + insertId, null,
                    null, null, null);
            cursor.moveToFirst();
            Workouts newWorkout = cursorToWorkout(cursor);
            cursor.close();
            return newWorkout;
        }

        public void deleteWorkout(Workouts w1) {
            long id = w1.getId();
            System.out.println("Comment deleted with id: " + id);
            database.delete(MySqlLiteHelper.TABLE_COMMENTS, MySqlLiteHelper.COLUMN_ID
                    + " = " + id, null);
        }

        public List<Workouts> getAllComments() {
            List<Workouts> workouts = new ArrayList<Workouts>();

            Cursor cursor = database.query(MySqlLiteHelper.TABLE_COMMENTS,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Workouts workout = cursorToWorkout(cursor);
                workouts.add(workout);
                cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();
            return workouts;
        }

        private Workouts cursorToWorkout(Cursor cursor) {
            Workouts w1 = new Workouts();
            w1.setId(cursor.getLong(0));
            w1.setWorkout(cursor.getString(1));
            return w1;
        }
    }


