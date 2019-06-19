package org.bvrit.bvritschedule;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.lang.Object;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class adminLogin extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;
    private ProgressDialog mprogress;
    private Button login;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Firebase.setAndroidContext(this);

        auth = FirebaseAuth.getInstance();

        emailField = (EditText)findViewById(R.id.email);
        passwordField = (EditText)findViewById(R.id.password);
        mprogress = new ProgressDialog(this);
        mprogress.setMessage("Logging in..");

        login = (Button)findViewById(R.id.loginButton);

       /* authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                    finish();
                }
            }
        };*/

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mprogress.show();
                startSignIn();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //auth.addAuthStateListener(authListener);
    }

    private void startSignIn(){
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            mprogress.dismiss();
            Toast.makeText(adminLogin.this, "Fields should not left empty", Toast.LENGTH_LONG).show();
        }
        else{
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        mprogress.dismiss();
                        Toast.makeText(adminLogin.this, "Sign in error", Toast.LENGTH_LONG).show();
                    }
                    else{
                        mprogress.dismiss();
                        Intent intent = new Intent(adminLogin.this, afterAdminLogin.class);
                        startActivity(intent);
                    }
                }
            });
        }


    }
}
