package com.android.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       /* First create an instance of SQLite database
         * We then check if the database exisrs or not by invoking the open or create
         * We pass in the name of the database, called myDB, 
         * the mode-Who can access the database-- Private which means its available only for this app
         * factory.. just lenga for now*/
                 
        
        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
       /* We are creating a sql command to create a table and check if it exists*/
        
        /*inserting the data
         */
         /* db.execSQL("CREATE TABLE IF NOT EXISTS MyTable (LastName VARCHAR, FirstName VARCHAR, Age INT(3));");
        db.execSQL("INSERT INTO MyTable VALUES ('Mama', 'Papa', '20');");
        */
        /* Reading the data using the db.raw query method which returns to us a 
         * cursor object with the results which we can then iterate over etc.*/
        
        Cursor c = db.rawQuery("SELECT * FROM MyTable", null);
        //Move the cursor to the first position so that we can start iterating
        c.moveToFirst();
        Log.d("TestDB", c.getString(c.getColumnIndex("FirstName")));
        
        db.close();
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
