package com.example.codeflow;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;


public class register extends AppCompatActivity {
    private static final String TAG = "Register";

    FirebaseAuth fAuth;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        final EditText dob= findViewById(R.id.dob);
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
        final EditText confirmpass= findViewById(R.id.confirmpassword);
        final EditText password= findViewById(R.id.passwordr);

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
        Button reg= findViewById(R.id.register);
        final EditText username= findViewById(R.id.username);
        final EditText email= findViewById(R.id.email);

        fAuth=FirebaseAuth.getInstance();

        // IF USER IS ALREADY CREATED
        if(fAuth.getCurrentUser() !=null){

            Toast.makeText(register.this, "User already registered.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=email.getText().toString();
                String password=confirmpass.getText().toString();
                String user=username.getText().toString();

                if(TextUtils.isEmpty(user))
                {
                    username.setError("Username is Required");
                    return;
                }

                //REGISTER USER INTO DATABASE

                fAuth.createUserWithEmailAndPassword(s,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //CHECKING WHETHER REGISTRATION SUCCESS OR NOT

                        if(task.isSuccessful())
                        {
                            Toast.makeText(register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            // IF REGISTERED, GO TO 'login'
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }
                        else
                        {
                            Toast.makeText(register.this, "User creation failed, try again.", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
    }

    public void onClickBack(View view){
        Intent back= new Intent(register.this,LoginActivity.class);
        startActivity(back);
    }

}