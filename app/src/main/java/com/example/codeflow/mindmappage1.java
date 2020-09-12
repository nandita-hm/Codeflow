package com.example.codeflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class mindmappage1 extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ImageButton cancel,confirm;
    EditText team_name,file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindmappage1);
        floatingActionButton=findViewById(R.id.floating);
        floatingActionButton.bringToFront();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Toast.makeText(todolist_act.this, " after fab", Toast.LENGTH_SHORT).show();
                final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(mindmappage1.this);
                View BottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.addfolder,null);
                bottomSheetDialog.setContentView(BottomSheetView);
                team_name=BottomSheetView.findViewById(R.id.team_name);
                file_name=BottomSheetView.findViewById(R.id.file_name);
                confirm=BottomSheetView.findViewById(R.id.send);
                cancel=BottomSheetView.findViewById(R.id.cancel_button);
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String team_name1=team_name.getText().toString();
                        String file_name1=file_name.getText().toString();
                        if(team_name1.isEmpty() || file_name1.isEmpty()){
                            Toast.makeText(mindmappage1.this, "Enter data", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(mindmappage1.this, "File created", Toast.LENGTH_SHORT).show();
                            bottomSheetDialog.dismiss();
                        }
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mindmappage1.this, "Cancel", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

               }

            });
    }
}