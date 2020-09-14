package com.example.codeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class page2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    GoogleApiClient mGoogleApiClient;
    Toolbar toolbar;
    WebView webView;
    private FirebaseAuth firebaseAuth;
    DrawerLayout drawerLayout;
    //Toolbar toolbar;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        webView=findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com/");
        toolbar = findViewById(R.id.tb);
        toolbar.setTitle("Notice me, Senpai!");
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
       navigationView.setCheckedItem(R.id.create);
      //  navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        toolbar.inflateMenu(R.menu.menu);
     //   navigationView.setCheckedItem(R.id.create);

        //  navigationView.setCheckedItem(R.id.create);
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
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.create:

                break;
            case R.id.logout1:
                Toast.makeText(this, "selected", Toast.LENGTH_SHORT).show();
                Intent tom=new Intent(this,viewimg.class);
               startActivity(tom);
                break;
            case R.id.help:
//                Intent upcoming=new Intent(this,upcoming.class);
//                startActivity(upcoming);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
    }

}


