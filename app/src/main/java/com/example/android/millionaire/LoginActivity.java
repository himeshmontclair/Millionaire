package com.example.android.millionaire;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

//initializing
    private Button signup_btn,login_btn;
    EditText emailText,password_editText;
    private TextView register_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        findViews();
    }

    private void findViews() {
        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);

        emailText = (EditText) findViewById(R.id.et_username);
        password_editText = (EditText) findViewById(R.id.password_editText);

        register_txt = (TextView) findViewById(R.id.register_txt);
        register_txt.setOnClickListener(this);

        register_txt.setText(Html.fromHtml("<html><body><font color=#91A1AB> <small> Don't have an account?  </small> </font> <font color=#335139><big>  Register </big> </font> </body><html>"));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
    }

//    //moving to registration screen on clicking register button
//    public void switchScreen(View view) {
//        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
//    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.login_btn :
                login_method();
                break;

            case R.id.register_txt :
                Intent register = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(register);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                break;
        }
    }

    private void login_method() {
         if(!emailText.getText().toString().equalsIgnoreCase("") && !password_editText.getText().toString().equalsIgnoreCase("")){
             if(doValidationEmail()){
                 Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                 startActivity(i);
                 overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                 Toast.makeText(this, "Loggedin Successfully", Toast.LENGTH_SHORT).show();
             }
         }else{
             Toast.makeText(this, "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
         }
    }

    public boolean doValidationEmail() {
        String emaili = emailText.getText().toString().trim();

        if (emailText.getText().length() == 0) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!emaili.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+[a-zA-Z0-9._-]+.com")) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent exit = new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }
}