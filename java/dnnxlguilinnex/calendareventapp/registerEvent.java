package dnnxlguilinnex.calendareventapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.widget.EditText;
import android.widget.Toast;

import domain.Event;
import domain.TimeRange;
import library.ConnectionSQLiteHelper;
import library.IConstant;

public class registerEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);

        // Button register event
        Button registerBtn = (Button) findViewById(R.id.main_btn_registerEvent);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText nameTxt = (EditText) findViewById(R.id.main_txt_registerEvent_name);
                String name = nameTxt.getText().toString();

                EditText placeTxt = (EditText) findViewById(R.id.main_txt_registerEvent_username);
                String place = placeTxt.getText().toString();

                EditText startDayTxt = (EditText) findViewById(R.id.main_txt_startDayEventRegister);
                String startDay = startDayTxt.getText().toString();

                EditText endDayTxt = (EditText) findViewById(R.id.main_txt_endDayEventRegister);
                String endDay = endDayTxt.getText().toString();

                // Register the event in the data base
                if(name.equals("") || place.equals("") || startDay.equals("") || endDay.equals(""))
                {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(registerEvent.this);

                    dialogBuilder.setMessage("Must complete all the fields");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }
                else
                {
                    Event objectEvent = new Event(name,username,new TimeRange(startDay, endDay));
                    registerEvent(objectEvent);
                    Intent pActivityEventByUser = new Intent(registerEvent.this,eventByUser.class);
                    startActivity(pActivityEventByUser);
                }
            }
        });

        // Button delete event
        Button deleteBtn = (Button) findViewById(R.id.main_btn_deleteEvent);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameTxt = (EditText) findViewById(R.id.main_txt_registerEvent_name);
                String name = nameTxt.getText().toString();

                EditText placeTxt = (EditText) findViewById(R.id.main_txt_registerEvent_username);
                String place = placeTxt.getText().toString();

                EditText startDayTxt = (EditText) findViewById(R.id.main_txt_startDayEventRegister);
                String startDay = startDayTxt.getText().toString();

                EditText endDayTxt = (EditText) findViewById(R.id.main_txt_endDayEventRegister);
                String endDay = endDayTxt.getText().toString();
                // Eliminar el evento en la base de datos
                // FALTA

                if(name.equals("") || place.equals("") || startDay.equals("") || endDay.equals(""))
                {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(registerEvent.this);

                    dialogBuilder.setMessage("Must complete all the fields");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }
                else
                {
                    deleteEvent( name, place, startDay, endDay);
                    Intent pActivityEventByUser = new Intent(registerEvent.this,eventByUser.class);
                    startActivity(pActivityEventByUser);
                }
            }
        });

        // Button search event
        Button searchBtn = (Button) findViewById(R.id.main_btn_searchEvent);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Variables
                EditText nameTxt = (EditText) findViewById(R.id.main_txt_registerEvent_name);
                String name = nameTxt.getText().toString();

                EditText placeTxt = (EditText) findViewById(R.id.main_txt_registerEvent_username);
                String place = placeTxt.getText().toString();

                EditText startDayTxt = (EditText) findViewById(R.id.main_txt_startDayEventRegister);
                String startDay = startDayTxt.getText().toString();

                EditText endDayTxt = (EditText) findViewById(R.id.main_txt_endDayEventRegister);
                String endDay = endDayTxt.getText().toString();

                if(name.equals("") || place.equals("") || startDay.equals("") || endDay.equals(""))
                {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(registerEvent.this);
                    dialogBuilder.setMessage("Must complete all the fields");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }
                else
                {
                    Event objectEvent = new Event(name,place,new TimeRange(startDay,endDay));
                    searchEvent(objectEvent);
                }
            }
        });
    }

    /**
     * Method register an event
     * Author: Danny Xie Li
     * Description: Method that register an event to the database.
     * Last modification: 22/02/18
     * @param pObjectEvent
     */
    private void registerEvent(Event pObjectEvent)
    {
        ConnectionSQLiteHelper connection = new ConnectionSQLiteHelper(this,IConstant.DATABASE_NAME, null, 1);
        SQLiteDatabase dataBaseObject = connection.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IConstant.NAME_EVENT_TABLE, pObjectEvent.getName());
        values.put(IConstant.PLACE_EVENT_TABLE, pObjectEvent.getPlace());
        values.put(IConstant.START_DAY_EVENT_TABLE, pObjectEvent.getTimeRange().getStartDay());
        values.put(IConstant.END_DAY_EVENT_TABLE, pObjectEvent.getTimeRange().getEndDay());
        Long result = dataBaseObject.insert(IConstant.TABLE_EVENT, IConstant.NAME_EVENT_TABLE, values);
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        dataBaseObject.close();
    }

    /**
     * Method search event
     * Author: Danny Xie Li
     * Description: Method that search an event to the database.
     * Last modification: 22/02/18
     * @param pObjectEvent
     */
    private void searchEvent(Event pObjectEvent)
    {
        ConnectionSQLiteHelper connection = new ConnectionSQLiteHelper(this,IConstant.DATABASE_NAME, null, 1);
        SQLiteDatabase dataBaseObject = connection.getWritableDatabase();
        String[] parameter = {pObjectEvent.getName(), pObjectEvent.getPlace(), pObjectEvent.getTimeRange().getStartDay(), pObjectEvent.getTimeRange().getEndDay()};
        String[] returnValues = {IConstant.NAME_EVENT_TABLE, IConstant.PLACE_EVENT_TABLE};
        Cursor cursor = dataBaseObject.rawQuery("SELECT " + IConstant.NAME_EVENT_TABLE + ", " + IConstant.PLACE_EVENT_TABLE + "," + IConstant.START_DAY_EVENT_TABLE + "," + IConstant.END_DAY_EVENT_TABLE+ " FROM " + IConstant.TABLE_EVENT +
                " WHERE Event." + IConstant.NAME_EVENT_TABLE + " =? AND Event." + IConstant.PLACE_EVENT_TABLE + " =? AND Event." + IConstant.START_DAY_EVENT_TABLE + " =? AND Event." + IConstant.END_DAY_EVENT_TABLE + " =? ", parameter);
        cursor.moveToFirst();
        try {
            Toast.makeText(this, "Encontrado " + cursor.getString(0), Toast.LENGTH_SHORT).show();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "No encontrado ", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method delete event
     * Author: Danny Xie Li
     * Description: Method that delete an event to the database.
     * Last modification: 22/02/18
     * @param pObjectEvent
     */
    private void deleteEvent(Event pObjectEvent)
    {
        ConnectionSQLiteHelper connection = new ConnectionSQLiteHelper(this,IConstant.DATABASE_NAME, null, 1);
        SQLiteDatabase dataBaseObject = connection.getWritableDatabase();
        String[] parameter = {pObjectEvent.getName(), pObjectEvent.getPlace(), pObjectEvent.getTimeRange().getStartDay(), pObjectEvent.getTimeRange().getEndDay()};
        String[] returnValues = {IConstant.NAME_EVENT_TABLE, IConstant.PLACE_EVENT_TABLE};
        Cursor cursor= dataBaseObject.rawQuery("DELETE FROM " + IConstant.TABLE_EVENT +
                " WHERE Event." + IConstant.NAME_EVENT_TABLE + " =? AND Event." + IConstant.PLACE_EVENT_TABLE + " =? AND Event." + IConstant.START_DAY_EVENT_TABLE + " =? AND Event." + IConstant.END_DAY_EVENT_TABLE + " =? ", parameter);
        cursor.moveToFirst();
    }
}
