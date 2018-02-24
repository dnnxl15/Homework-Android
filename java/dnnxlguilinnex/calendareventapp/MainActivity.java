package dnnxlguilinnex.calendareventapp;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import android.content.Intent;

import android.view.View;

import library.ConnectionSQLiteUser;
import library.IConstant;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to sign up
        Button signUpBtn = (Button) findViewById(R.id.main_btn_signUp);
        signUpBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Go to an other activity, to the register class
                Intent pIntent = new Intent(MainActivity.this, register.class);
                startActivity(pIntent);
            }
        });

        // Button to sign in
        Button signInBtn = (Button) findViewById(R.id.main_btn_signIn);
        signInBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TextView Name
                EditText nameTxt = (EditText) findViewById(R.id.main_txt_main_username);
                String name = nameTxt.getText().toString();

                // TextView Password
                EditText passwordTxt = (EditText) findViewById(R.id.main_txt_main_confirmPassword);
                String password = passwordTxt.getText().toString();
                boolean verify = userLogin(name, password);
                if(verify == true) {
                    // Go to the activity Event by user.
                    Intent activity = new Intent(MainActivity.this, eventByUser.class);
                    startActivity(activity);
                }
                else
                {
                    // Punto 1
                    // Message of error, incorrect password or username
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    dialogBuilder.setMessage("Username or password incorrect");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }

            }
        });

        // Button change password
        Button changePasswordBtn = (Button) findViewById(R.id.main_btn_changePassword);
        changePasswordBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // TextView Name
                EditText nameTxt = (EditText) findViewById(R.id.main_txt_main_username);
                String name = nameTxt.getText().toString();

                // TextView Password
                EditText passwordTxt = (EditText) findViewById(R.id.main_txt_main_confirmPassword);
                String password = passwordTxt.getText().toString();
                // FALTA
                //-------------------------------------------------------
                // Ver si existe el usuario y su contraseña esta correcta
                //-------------------------------------------------------
                boolean verify = userLogin(name, password);
                if(verify == true) {
                    // Go to the activity change password.
                    Intent pIntent = new Intent(MainActivity.this, changePassword.class);
                    startActivity(pIntent);
                }
                else
                {
                    //Show message of error, that username of password is incorrect
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    dialogBuilder.setMessage("Username or password incorrect");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }
            }
        });
    }
    /**
     * Method search event
     * Author: Esteban Coto
     * Description: Method that search an event to the database.
     * Last modification: 22/02/18
     * @param pUsername
     * @param pPassword
     */
    private boolean userLogin(String pUsername, String pPassword)
    {
        ConnectionSQLiteUser connection = new ConnectionSQLiteUser(this, IConstant.USER_DATABASE, null, 1);
        SQLiteDatabase dataBaseObject = connection.getWritableDatabase();
        String[] parameter = {pUsername, pPassword};
        String[] returnValues = {IConstant.NAME_USER_TABLE, IConstant.PASSWORD_USER_TABLE};
        Cursor cursor = dataBaseObject.rawQuery("SELECT count(*)" + " FROM " + IConstant.TABLE_USER +
                " WHERE User." + IConstant.USERNAME_USER_TABLE + " =? AND User." + IConstant.PASSWORD_USER_TABLE + " =? ", parameter);
        cursor.moveToFirst();
        try {
            int count2 = cursor.getShort(0);
            Toast.makeText(this, "Coincide", Toast.LENGTH_SHORT).show();
            if (count2 >= 1)
                return true;
            else
                return false;
            //return true;
        }
        catch(Exception e)
        {
            Toast.makeText(this, "No coincide ", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}