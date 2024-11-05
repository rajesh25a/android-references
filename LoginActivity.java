package com.example.fininfocom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fininfocom.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FirebaseApp.initializeApp(this);

        EditText suser_name = binding.userNameEdt;
        EditText spassword = binding.passwordEdt;
        TextView slogin_btn = binding.loginTv;

        slogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String muser_name = suser_name.getText().toString().trim();
                String mPassword = spassword.getText().toString().trim();
                validateCredentials(muser_name, mPassword);
            }
        });
    }

    private void validateCredentials(String muserName, String mPassword) {
        if (muserName.isEmpty() || mPassword.isEmpty()) {
            Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_LONG).show();
        } else if (muserName.length() != 10) {
            Toast.makeText(this, "Username must be 10 characters", Toast.LENGTH_LONG).show();
        } else if (mPassword.length() < 7 || !isStrongPassword(mPassword)) {
            Toast.makeText(this, "Password must be 7 characters with one uppercase alphabet, one special character, and one numeric", Toast.LENGTH_LONG).show();
        } else {
            // Call Firebase authentication method
            signInWithEmailAndPassword(muserName, mPassword);
        }
    }

    private void signInWithEmailAndPassword(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Authentication successful", Toast.LENGTH_SHORT).show();
                    sendIntentToMainActivity();
                }else{
                    // If sign in fails, display a message to the user.
                    Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void sendIntentToMainActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish(); // Close the current activity if login is successful
    }

    private boolean isStrongPassword(String mPassword) {
        return mPassword.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$");
    }


}