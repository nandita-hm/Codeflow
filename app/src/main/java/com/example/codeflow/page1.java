package com.example.codeflow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class page1 extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        floatingActionButton=findViewById(R.id.floating);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(page1.this, " in fab", Toast.LENGTH_SHORT).show();
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(page1.this);
                View BottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.addfolder, null);
                bottomSheetDialog.setContentView(BottomSheetView);
                bottomSheetDialog.show();
            }
        });


    }
}