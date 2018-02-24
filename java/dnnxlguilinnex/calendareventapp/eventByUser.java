package dnnxlguilinnex.calendareventapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import library.ConnectionSQLiteHelper;
import library.IConstant;

import domain.*;

public class eventByUser extends AppCompatActivity {

    private ListView listEvent;
    private ArrayList<String> arrayEvent;
    private ArrayList<Event> arrayEvents;


    private ConnectionSQLiteHelper objectConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_by_user);

        // ListView that have all the events
        listEvent = (ListView) findViewById(R.id.main_listView_events);
        objectConnection = new ConnectionSQLiteHelper(this,"bd_Event", null, 1);

        consultEvent(); // Get the arrayList
        ArrayAdapter objectAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayEvent); //Adapt the arrayList to the listview
        listEvent.setAdapter(objectAdapter); // Set the arrayList to the listView

        Button eventBtnEvent = (Button) findViewById(R.id.main_btn_registerEvent_event);
        eventBtnEvent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Go to an other activity
                Intent pActivityEventByUser = new Intent(eventByUser.this, registerEvent.class);
                startActivity(pActivityEventByUser);
            }
        });
    }

    /**
     * Method consult event
     * Author: Danny Xie Li
     * Description: Method that get all the data from the database.
     * Last modification: 22/02/18
     */
    private void consultEvent()
    {
        SQLiteDatabase databaseObject = objectConnection.getReadableDatabase();
        Event objectEvent; // Object event
        arrayEvent = new ArrayList<String>(); // Arraylist of string to display in the listview
        Cursor cursor = databaseObject.rawQuery("SELECT * FROM " + IConstant.TABLE_EVENT, null); // Cursor to get data
        while(cursor.moveToNext())
        {
            String object;
            objectEvent = new Event();
            objectEvent.setName(cursor.getString(0));
            arrayEvent.add(cursor.getString(0) +"  "+  cursor.getString(1) + "  " + cursor.getString(2) + "  " + cursor.getString(3));
            objectEvent.setPlace(cursor.getString(1));  // Set the data
            TimeRange objectTime = new TimeRange(cursor.getString(2),cursor.getString(3));
            arrayEvents.add(objectEvent); // Add the object to the arraylist
        }
    }
}
