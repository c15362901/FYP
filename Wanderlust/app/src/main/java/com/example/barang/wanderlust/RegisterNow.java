package com.example.barang.wanderlust;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterNow extends AppCompatActivity {

    Button registerBtn, registerCancel;
    EditText regUsername, regPassword, regFirstName, regLastName, regEmail, regNumber, confirmPass;
    DatabaseHelper myDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        myDatabaseHelper = new DatabaseHelper(this);
        registerBtn = (Button)findViewById(R.id.btRegister);
        regUsername = (EditText)findViewById(R.id.userinput);
        regPassword = (EditText)findViewById(R.id.passwordinput);
        regFirstName = (EditText)findViewById(R.id.nameinput);
        regLastName = (EditText)findViewById(R.id.lastnameinput);
        regEmail = (EditText)findViewById(R.id.emailinput);
        regNumber = (EditText)findViewById(R.id.numberinput);
        confirmPass = (EditText)findViewById(R.id.confirmpass);
        registerCancel = (Button)findViewById(R.id.btCancel);

        InsertCustomer();
    }

    private void InsertCustomer()
    {

        final Pattern letters = Pattern.compile("[a-zA-Z]+");
        final Pattern user_letters = Pattern.compile("[a-z0-9]");
        final Pattern numbers = Pattern.compile("[0-9]");
        final Pattern pass = Pattern.compile("[A-Z]+[a-z]+[0-9]");
        final Pattern email = Pattern.compile("[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+");

        registerBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        String insert_regUsername = regUsername.getText().toString();
                        String insert_regPassword = regPassword.getText().toString();
                        String insert_regFirstName = regFirstName.getText().toString();
                        String insert_regLastName = regLastName.getText().toString();
                        String insert_regEmail = regEmail.getText().toString();
                        String insert_regNumber = regNumber.getText().toString();
                        String insert_regConfirm = confirmPass.getText().toString();

                        if (insert_regUsername.equals("")
                                || insert_regPassword.equals("")
                                || insert_regFirstName.equals("")
                                || insert_regLastName.equals("")
                                || insert_regEmail.equals("")
                                || insert_regNumber.equals("")
                                || insert_regConfirm.equals(""))
                        {
                            Toast.makeText(getApplicationContext(), "Sorry you can't have empty fields!", Toast.LENGTH_SHORT).show();
                        }
                        //checks if the username already exists or if the username is already taken
                        else if (myDatabaseHelper.checkUser(insert_regUsername))
                        {
                            Toast.makeText(getApplicationContext(), "Choose another username.", Toast.LENGTH_SHORT).show();
                        }
                        else if(!pass.matcher(insert_regPassword).find() || insert_regPassword.length()<6)
                        {
                            Toast.makeText(getApplicationContext(), "Password must have atleast 6 characters with UPPERCASE, LOWERCASE and a NUMBER!", Toast.LENGTH_SHORT).show();
                        }
                        else if(!user_letters.matcher(insert_regUsername).find() || insert_regUsername.length()< 6)
                        {
                            Toast.makeText(getApplicationContext(), "Username must have at least 6 LOWERCASE characters and may contain a NUMBER", Toast.LENGTH_SHORT).show();
                        }
                        else if(!numbers.matcher(insert_regNumber).find() || insert_regNumber.length() < 10)
                        {
                            Toast.makeText(getApplicationContext(), "Number must contain 10 digits!", Toast.LENGTH_SHORT).show();
                        }
                        else if (!letters.matcher(insert_regFirstName).find() || !letters.matcher(insert_regLastName).find())
                        {
                            Toast.makeText(getApplicationContext(), "First and last name must only contain letters!", Toast.LENGTH_SHORT).show();
                        }
                        else if(!email.matcher(insert_regEmail).find())
                        {
                            Toast.makeText(getApplicationContext(), "Must follow email format!", Toast.LENGTH_SHORT).show();
                        }
                        else if(!insert_regPassword.equals(insert_regConfirm))
                        {
                            Toast.makeText(getApplicationContext(), "Password must match!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            //insert users to the users table
                            myDatabaseHelper.insertData(insert_regUsername, insert_regPassword, insert_regFirstName, insert_regLastName, insert_regEmail, insert_regNumber,0);

                            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(RegisterNow.this, MainActivity.class));
                            finish();
                        }
                    }
                }
        );

        registerCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterNow.this, MainActivity.class));
                finish();
            }
        });
    }
}
