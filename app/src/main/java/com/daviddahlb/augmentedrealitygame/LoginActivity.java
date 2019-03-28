package com.daviddahlb.augmentedrealitygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignup;
    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;

    public static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignup = findViewById(R.id.btnSignup);
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);

        // or log in if user already exists or persisted from previous login
        ParseUser currentUser = ParseUser.getCurrentUser();
        currentUser.logOut();
        if (currentUser != null) {
            // do stuff with the user
            //goMainActivity();
            Log.d(TAG, "currentUser is NOT null");
        } else {
            // show the signup or login screen
            //startActivity();
            Log.d(TAG, "currentUser is null");
        }

        // set a listener for sign up button which creates a user
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // put data into username and password
                // create new user
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                signup(username, password, email);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });
    }

    private void signup(String username, String password, String email) {
        // Create the ParseUser
        ParseUser user = new ParseUser();

        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        // Set custom properties
        //user.put("phone", "650-253-0000");
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    goMainActivity();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    // TODO: user feedback about what went wrong (account name already in use), etc.
                    Log.e(TAG, "signup fail");
                    e.printStackTrace();
                    return;
                }
            }
        });
    }

    private void goMainActivity() {
        Log.d(TAG, "Navigating to Main Activity");
        //navigating to new MainActivity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void login(String username, String password) {

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    // TODO: better error handling
                    Log.e(TAG, "issue with login");
                    e.printStackTrace();
                    return;
                }
                goMainActivity();
            }
        });
    }
}
