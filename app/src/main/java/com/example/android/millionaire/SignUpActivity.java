package com.example.android.millionaire;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

//this is the class for the registration screen

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText first_name,last_name,e_mail,mobile_no,date_birth,password,family_name;
    Button btn_siginup;
    private DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();
    }


    private void findViews() {
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        e_mail = (EditText) findViewById(R.id.e_mail);
        family_name= (EditText) findViewById(R.id.family_name);
        mobile_no = (EditText) findViewById(R.id.mobile_no);

        date_birth = (EditText) findViewById(R.id.date_birth);
        date_birth.setOnClickListener(this);

        password = (EditText) findViewById(R.id.password);

        btn_siginup = (Button) findViewById(R.id.btn_siginup);
        btn_siginup.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
         int id = view.getId();
         switch (id){
             case R.id.btn_siginup :
                 sign_up();
                 break;

             case R.id.date_birth :
                 calendar_method();
                 break;

         }
    }

    private void calendar_method() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);

        picker = new DatePickerDialog(SignUpActivity.this, R.style.DataPick,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date_birth.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }

    private void sign_up() {
        if(!first_name.getText().toString().equalsIgnoreCase("") &&
                !last_name.getText().toString().equalsIgnoreCase("") &&
                !family_name.getText().toString().equalsIgnoreCase("") &&
                !e_mail.getText().toString().equalsIgnoreCase("") &&
                !mobile_no.getText().toString().equalsIgnoreCase("") &&
                !date_birth.getText().toString().equalsIgnoreCase("") &&
                !password.getText().toString().equalsIgnoreCase("")){
          if(doValidationFName()) {
              if (doValidationEmail()) {
                  if (doValidationmobile()) {
                      Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                      startActivity(i);
                      Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                  }
              }
          }else{
              Toast.makeText(this, "first name should be more than 3 characters", Toast.LENGTH_SHORT).show();
          }

        }else{
            Toast.makeText(this, "Please fill the details", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean doValidationFName() {
        String f_name = first_name.getText().toString().trim();
        if(f_name.length()>3 && f_name.length()<30){
            return true;
        }
        return false;
    }

    public boolean doValidationEmail() {
        String emaili = e_mail.getText().toString().trim();

        if (e_mail.getText().length() == 0) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emaili.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+[a-zA-Z0-9._-]+.com")) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean doValidationmobile() {
        String mobile = mobile_no.getText().toString().trim();
        if(mobile.length()!=10){
            Toast.makeText(this, "Please Enter valid 10 digit mobile number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
