package com.example.codeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;


public class page2 extends AppCompatActivity {
    GoogleApiClient mGoogleApiClient;
    Toolbar toolbar;
    WebView webView;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        webView=findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com/");
        toolbar = findViewById(R.id.tb);
        toolbar.setTitle("Notice me, Senpai!");

        toolbar.inflateMenu(R.menu.menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        // addSomething();
                        return true;
                    case R.id.download:
                        // startSettings();
                        return true;
                    case R.id.logout:
                        signOut();

                    default:
                        return false;
                }
            }
        });
    }
    @Override
    protected void onStart() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
        super.onStart();
    }

    private void signOut() {

        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(getApplicationContext(),"Logged Out", Toast.LENGTH_SHORT).show();
                        Intent mainIntent = new Intent(page2.this, LoginActivity.class);
                        page2.this.startActivity(mainIntent);
                        page2.this.finish();
                    }
                });
    }
}


