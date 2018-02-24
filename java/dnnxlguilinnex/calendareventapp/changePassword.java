package dnnxlguilinnex.calendareventapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import library.ConnectionSQLiteUser;
import library.IConstant;

public class changePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        // Button change password
        Button updateBtn = (Button) findViewById(R.id.main_btn_event);
        updateBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Instance of textfield
                // Old password

                EditText oldPasswordTxt = (EditText) findViewById(R.id.main_txt_change_password);
                String oldPassword = oldPasswordTxt.getText().toString();

                // New Password
                EditText newPasswordTxt = (EditText) findViewById(R.id.main_txt_change_confirmPassword);
                String newPassword = newPasswordTxt.getText().toString();

                if (oldPassword.equals(newPassword)) {
                    // Show message
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(changePassword.this);
                    dialogBuilder.setMessage("Passwords can't be equal");
                    dialogBuilder.setCancelable(true).setTitle("Error");
                    dialogBuilder.create().show();

                    // Go to an other activity
                }else
                {
                    Intent pIntent = new Intent(changePassword.this, MainActivity.class);
                    startActivity(pIntent);
                    // Show message
                    changeUserPassword(oldPassword, newPassword);
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(changePassword.this);
                    dialogBuilder.setMessage("Password changed");
                    dialogBuilder.setCancelable(true).setTitle("Success");
                    dialogBuilder.create().show();
                }
            }
        });
    }

    /**
     * Method register an event
     * Author: Esteban Coto Alfaro
     * Last modification: 22/02/18
     * @param pOldPassword
     * @param pNewPassword
     */
    public void changeUserPassword(String pOldPassword, String pNewPassword)
    {
        ConnectionSQLiteUser connection = new ConnectionSQLiteUser(this, IConstant.USER_DATABASE, null, 1);
        SQLiteDatabase dataBaseObject = connection.getWritableDatabase();
        String[] parameter = {pOldPassword, pNewPassword};
        Cursor updateData = dataBaseObject.rawQuery("UPDATE " + IConstant.TABLE_USER + " SET " + IConstant.PASSWORD_USER_TABLE + " = " + pNewPassword +
                " WHERE User." + IConstant.PASSWORD_USER_TABLE + " = " + pOldPassword, null);
        updateData.moveToFirst();
        //String sql = "UPDATE " + IConstant.TABLE_USER + " SET " + IConstant.PASSWORD_USER_TABLE + " = '" + pNewPassword.toString() + "' WHERE " + IConstant.PASSWORD_USER_TABLE + " == " + pOldPassword.toString();
        Toast.makeText(this, "Encontrado " + pOldPassword + " " + pNewPassword, Toast.LENGTH_SHORT).show();

    }
}
