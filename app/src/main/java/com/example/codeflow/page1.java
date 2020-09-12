package com.example.codeflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class page1 extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    Toolbar toolbar;
    EditText Team_name,File_name;
    ImageButton cancel,confirm;

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
                Team_name=BottomSheetView.findViewById(R.id.team_name);
                File_name=BottomSheetView.findViewById(R.id.file_name);
                cancel=BottomSheetView.findViewById(R.id.cancelbtn);
                confirm=BottomSheetView.findViewById(R.id.send);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(page1.this, "On click confirm", Toast.LENGTH_SHORT).show();
                        //String tn=Team_name.getText().toString();
                       // String fn=File_name.getText().toString();
                        bottomSheetDialog.dismiss();
                       Intent file=new Intent(page1.this,page2.class);
                        page1.this.startActivity(file);
                        page1.this.finish();
                    }
                });

                bottomSheetDialog.show();
            }
        });


    }
}