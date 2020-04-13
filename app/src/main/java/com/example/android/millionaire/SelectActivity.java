package com.example.android.millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {
     Button login_btn;
     Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select);

        findViews();
    }

    private void findViews() {
        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);

        register_btn = (Button) findViewById(R.id.register_btn);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.login_btn :
                Intent login = new Intent(SelectActivity.this,LoginActivity.class);
                startActivity(login);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                break;

            case R.id.register_btn :
                Intent register = new Intent(SelectActivity.this,SignUpActivity.class);
                startActivity(register);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                break;
        }
    }
}