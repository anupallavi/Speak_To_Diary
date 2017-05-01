package com.example.hp.speak_to_diary;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity  extends AppCompatActivity {
    EditText name,password;
    TextView signup_text;
    Button login;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* boolean comp = RegisterActivity.compare(name.toString(), password.toString());
                if (comp == true) {
                    startActivity(new Intent(MainActivity.this, CalendarActivity.class));
                }
                else{
                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("something went wrong...");
                    builder.setMessage("If you are a new user, please register..");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }*/
                startActivity(new Intent(MainActivity.this, CalendarActivity.class));
            }
        });
        signup_text = (TextView)findViewById(R.id.sign_up);
        signup_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
}

