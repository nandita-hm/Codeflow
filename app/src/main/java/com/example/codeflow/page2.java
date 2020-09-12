package com.example.codeflow;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class page2 extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        webView=findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com/");
        toolbar = findViewById(R.id.tb);
        toolbar.setTitle("Notice me ,senpai!");

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
                    default:
                        return false;
                }
            }
        });
    }
}


