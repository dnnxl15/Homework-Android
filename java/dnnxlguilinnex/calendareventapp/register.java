package dnnxlguilinnex.calendareventapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import library.ConnectionSQLiteUser;
import library.IConstant;

import domain.*;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerBtn = (Button) findViewById(R.id.main_btn_register_signUp);
        registerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Variable name
                EditText nameTxt = (EditText) findViewById(R.id.main_txt_signUp_name);
                String name = nameTxt.getText().toString();
                // Variable place
                EditText usernameTxt = (EditText) findViewById(R.id.main_txt_signUp_username);
                String username = usernameTxt.getText().toString();
                // Variable password
                EditText passwordTxt = (EditText) findViewById(R.id.main_txt_signUp_password);
                String password = passwordTxt.getText().toString();
                // Variable confirm password
                EditText confirmPasswordTxt = (EditText) findViewById(R.id.main_txt_signUp_confirmPassword);
                String confirmPassword = confirmPasswordTxt.getText().toString();

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(register.this);

                // If password is equals the confirm password
                if(!password.equals(confirmPassword))
                {
                    dialogBuilder.setMessage("Password don't match");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }
                else if(name.equals("") || username.equals("") || password.equals(""))
                {
                    // Message of error
                    dialogBuilder.setMessage("Must complete all the fields");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();
                }
                User objectPerson = new User(name, username, password);
                saveUser(objectPerson);
                // Return to the back ativity
                Intent pIntent = new Intent(register.this, MainActivity.class);
                startActivity(pIntent);
                // Message of success
                dialogBuilder.setMessage("User " + name + " successful sign up");
                dialogBuilder.setCancelable(true).setTitle("Success");
                dialogBuilder.create().show();
            }
         });
    }

    /**
     * Method register an event
     * Author: Esteban Coto Alfaro
     * Description: Method that register an user to the database.
     * Last modification: 22/02/18
     * @param objectPerson
     */
    private void saveUser(User objectPerson)
    {
        ConnectionSQLiteUser connection = new ConnectionSQLiteUser(this, IConstant.USER_DATABASE, null, 1);
        SQLiteDatabase dataBaseObject = connection.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(IConstant.NAME_USER_TABLE, objectPerson.getName());
        values.put(IConstant.USERNAME_USER_TABLE, objectPerson.getUsername());
        values.put(IConstant.PASSWORD_USER_TABLE, objectPerson.getPassword());
        Long result = dataBaseObject.insert(IConstant.TABLE_USER, IConstant.NAME_USER_TABLE, values);
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        dataBaseObject.close();
    }
}
