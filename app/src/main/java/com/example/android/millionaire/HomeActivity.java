package com.example.android.millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.millionaire.activities.First_QActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout start_btn;
    TextView previous_score;
    Button history_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        findViews();
    }

    private void findViews() {
        history_btn = (Button) findViewById(R.id.history_btn);
        history_btn.setOnClickListener(this);

        start_btn = (LinearLayout) findViewById(R.id.start_btn);
        start_btn.setOnClickListener(this);

        previous_score = (TextView) findViewById(R.id.previous_score);

        if(Utilities.Result_btn_click){
            history_btn.setVisibility(View.VISIBLE);
            previous_score.setVisibility(View.VISIBLE);
            previous_score.setText("Previous Score : "+ ResultActivity.final_Score+"/10");
        }else{
            previous_score.setVisibility(View.GONE);
            history_btn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.start_btn :
                Utilities.First_Ans="";
                Utilities.Second_Ans="";
                Utilities.Third_Ans="";
                Utilities.Fourth_Ans="";
                Utilities.Fifth_Ans="";
                Utilities.Sixth_Ans="";
                Utilities.Seventh_Ans="";
                Utilities.Eight_Ans="";
                Utilities.Ninth_Ans="";
                Utilities.Tenth_Ans="";
                ResultActivity.final_Score=0;
                Utilities.Result_btn_click = false;

                Intent start = new Intent(HomeActivity.this, First_QActivity.class);
                startActivity(start);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                break;

            case R.id.history_btn :
                Intent i = new Intent(HomeActivity.this,ReviewActivity.class);
                startActivity(i);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Utilities.Result_btn_click){
            history_btn.setVisibility(View.VISIBLE);
            previous_score.setVisibility(View.VISIBLE);
            previous_score.setText("Previous Score : "+ ResultActivity.final_Score+"/10");
        }else{
            previous_score.setVisibility(View.GONE);
            history_btn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        Intent exit = new Intent(Intent.ACTION_MAIN);
        exit.addCategory(Intent.CATEGORY_HOME);
        exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(exit);
    }
}