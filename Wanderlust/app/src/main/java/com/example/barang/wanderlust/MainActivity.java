package com.example.barang.wanderlust;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDatabaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new DatabaseHelper(this);

        login();
        register();
    }


    private void login() {
        Button loginBtn = (Button) findViewById(R.id.btSignIn);


        final EditText loginUsername = (EditText) findViewById(R.id.emailinput);
        final EditText loginPassword = (EditText) findViewById(R.id.passwordinput);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //the username and password that have been entered in by the user will be stored here
                final String compare_loginUsername = loginUsername.getText().toString();
                String compare_loginPassword = loginPassword.getText().toString();
                String password = myDatabaseHelper.checkUsername(compare_loginUsername);

                //it also stores the address and phone number so we can display/update it later
                String dbEmail = myDatabaseHelper.getEmail(compare_loginUsername);
                String dbPhone = myDatabaseHelper.getPhone(compare_loginUsername);
                String dbName = myDatabaseHelper.getName(compare_loginUsername);
                String dbLName = myDatabaseHelper.getLName(compare_loginUsername);


                //the user must enter the username AND password
                if (compare_loginUsername.equals("") && compare_loginPassword.equals("")) {
                    Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }

                //this checks the customer's password if it matches

                else if (compare_loginPassword.equals(password)) {


                    Toast.makeText(MainActivity.this, "Start Wandering!", Toast.LENGTH_SHORT).show();

                    SharedPreferences pref = MainActivity.this.getSharedPreferences("Login", Context.MODE_PRIVATE);
                    final SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", compare_loginUsername);
                    editor.putString("email", dbEmail);
                    editor.putString("phone", dbPhone);
                    editor.putString("firstname", dbName);
                    editor.putString("lastname", dbLName);

                    editor.apply();

                    startActivity(new Intent(MainActivity.this, MainPage.class));
                    finish();
                }
                else if(myDatabaseHelper.checkUser(compare_loginUsername))
                {
                    Toast.makeText(MainActivity.this, "Incorrect username/password!", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "User does not exist!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register() {

        TextView registerNow = (TextView) findViewById(R.id.btSignUp);
        registerNow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterNow.class));
            }
        });

    }
}