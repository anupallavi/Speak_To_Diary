package com.example.hp.speak_to_diary;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Hp on 4/30/2017.
 */

public class RegisterActivity extends AppCompatActivity {

    EditText Name,Pass,ConPass;
    Button reg_button;
    AlertDialog.Builder builder;
    static String savename,savepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText)findViewById(R.id.reg_name);
        Pass = (EditText)findViewById(R.id.reg_password);
        ConPass = (EditText)findViewById(R.id.reg_con_password);
        reg_button=(Button)findViewById(R.id.reg_button);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().equals("")||Pass.getText().toString().equals(""))
                {
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("something went wrong...");
                    builder.setMessage("please fill all the field..");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); //close alert dialog
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else if(!(Pass.getText().toString().equals(ConPass.getText().toString())))
                {
                    builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setTitle("something went wrong...");
                    builder.setMessage("Your passwords are not matching..");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Pass.setText("");    // reset password field when ok is clicked
                            ConPass.setText("");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                else
                {
                    savename = Name.getText().toString();
                    savepass = Pass.getText().toString();

                    //  BackgroundTask backgroundTask = new BackgroundTask(RegisterActivity.this);
                    //backgroundTask.execute("register",Name.getText().toString(),Email.getText().toString(),Pass.getText().toString());

                }
            }
        });

    }
    public static boolean compare(String cname, String cpass)
    {
        if(savename != cname || savepass != cpass)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}


