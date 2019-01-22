package com.roma.formvalidation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.roma.formvalidation.R.id.btnLogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // Initialization
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvCreatAccount;
    String username, password;
    int formsuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreatAccount = findViewById(R.id.tvCreateAccount);

        btnLogin.setOnClickListener(this);
        tvCreatAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                formsuccess = 2;

                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                // check if the username is null
                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formsuccess--;
                }

                // check if the password is null
                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formsuccess--;
                }

                if (formsuccess == 2) {
                    Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.tvCreateAccount:
                Intent signup = new Intent(this, SignupActivity.class);
                startActivity(signup);
                break;
        }
    }
}
