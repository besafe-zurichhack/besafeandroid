package com.marcos.perez.mvpexample.login.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.marcos.perez.mvpexample.R;
import com.marcos.perez.mvpexample.home.view.HomeView;
import com.marcos.perez.mvpexample.login.presenter.LoginPresenter;
import com.marcos.perez.mvpexample.login.presenter.ILoginPresenter;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class LoginView extends AppCompatActivity implements ILoginView {
    private final static String TAG = "LoginView";
    private Button loginButton;
    ILoginPresenter mPresenter;

    private static final String TAG1 = "EmailPassword";

    private EditText mEmailField;
    private EditText mPasswordField;

    private FirebaseAuth mAuth;

    private SharedPreferences pref;

    private LoginButton faceLoginButton;
    CallbackManager mCallbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        super.setContentView(R.layout.activity_login_view);
        pref = getApplicationContext().getSharedPreferences("mypref", 0); // 0 - for private mode
        mAuth = FirebaseAuth.getInstance();

        mEmailField =(EditText) findViewById(R.id.input_email);
        mPasswordField = (EditText) findViewById(R.id.input_password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
            }
        });

        mCallbackManager = CallbackManager.Factory.create();
        faceLoginButton = (LoginButton) findViewById(R.id.login_button_face);
        faceLoginButton.setReadPermissions("email", "public_profile");
        faceLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });

        initialize(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    private void initialize(ILoginView view){
        mPresenter = new LoginPresenter(view);
    }

    @Override
    public void loadHomeActivity() {
        Intent anIntent = new Intent(getApplicationContext(), HomeView.class);
        startActivity(anIntent);
        this.finish();
    }

    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
       /* if (!validateForm()) {
            return;
        }*/

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            SharedPreferences.Editor editor = pref.edit();
                            Log.d(TAG, "signInWithEmail:success"+user.getUid());
                            editor.putString("user_id", user.getUid());
                            editor.commit();
                            Intent anIntent = new Intent(getApplicationContext(), HomeView.class);
                            startActivity(anIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginView.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;
        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }
        return valid;
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                        }
                    }
                });
    }
}
