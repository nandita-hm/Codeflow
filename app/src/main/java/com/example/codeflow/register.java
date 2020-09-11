package com.example.codeflow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class register extends AppCompatActivity {
    private static final String TAG = "Register";


    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        final EditText dob=(EditText)findViewById(R.id.dob);
        dob.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(register.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                dob.setText(date);
            }
        };
        final EditText confirmpass=(EditText)findViewById(R.id.confirmpassword);
        final EditText password=(EditText)findViewById(R.id.passwordr);

        confirmpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass=password.getText().toString();
                String cp=confirmpass.getText().toString();
                if(!cp.equals(pass))
                {
                    confirmpass.setText("");
                    password.setText("");
                    Toast.makeText(register.this, "Password Doesn't match", Toast.LENGTH_SHORT).show();

                }

            }
        });
        Button reg=(Button)findViewById(R.id.register);
        final EditText username=(EditText)findViewById(R.id.username);
        final EditText email=(EditText)findViewById(R.id.email);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=email.getText().toString();
                String password=confirmpass.getText().toString();
                String uset=username.getText().toString();




            }
        });


    }
    public void onClickBack(){
        Intent back= new Intent(register.this,LoginActivity.class);
        startActivity(back);
    }

}