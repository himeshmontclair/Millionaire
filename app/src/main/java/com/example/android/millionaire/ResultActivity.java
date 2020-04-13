package com.example.android.millionaire;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
   public  static int final_Score;
    private TextView score_txt;
    private Button HomePage_btn;
    private Button review_btn;
    TextView ten_answer;
    private int ten_ans;
    private int screen_Width;
    private int screen_height;
    private Button yes_button,no_button;
    private ImageView cancel_popup;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViewes();
        DisplayMetrics dm = new DisplayMetrics();
        ResultActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_Width = dm.widthPixels;
        screen_height = dm.heightPixels;
        scoreForQuize();
    }

    private void findViewes() {
        String tenth_ans = Utilities.getpref(ResultActivity.this,"tenth","");
        ten_answer = (TextView) findViewById(R.id.ten_answer);
        if(Utilities.Tenth_Ans.equals("Neil Armstrong")){
            ten_ans = Integer.valueOf(tenth_ans)+100;
            result="<html><body><font color=#91A1AB> <small> You earned </small> </font> <font color=#FF0000><big> "+"$ "+ ten_ans + "</big> </font> </body><html>";
            ten_answer.setText(Html.fromHtml(result));
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        }else{
            ten_ans = Integer.valueOf(tenth_ans);
            result="<html><body><font color=#91A1AB> <small> You earned </small> </font> <font color=#FF0000><big> "+"$ "+  ten_ans + "</big> </font> </body><html>";
            ten_answer.setText(Html.fromHtml(result));
            Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
        }

        score_txt=(TextView)findViewById(R.id.score_txt);

        HomePage_btn=(Button)findViewById(R.id.HomePage_btn);
        HomePage_btn.setOnClickListener(this);

        review_btn=(Button)findViewById(R.id.review_btn);
        review_btn.setOnClickListener(this);
    }

    private void scoreForQuize() {
         final_Score=0;
        if(Utilities.First_Ans.equals("US and Canada")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Second_Ans.equals("Headache")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Third_Ans.equals("148million km sq")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Fourth_Ans.equals("Vasco da Gama")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Fifth_Ans.equals("Tim Berners-Lee")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Sixth_Ans.equals("Greenland")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Seventh_Ans.equals("Norway")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Eight_Ans.equals("Republicans and Democrats")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Ninth_Ans.equals("50")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        if(Utilities.Tenth_Ans.equals("Neil Armstrong")){
            final_Score=final_Score+1;
        }else {
            final_Score=final_Score;
        }

        setImage(final_Score);
        //Toast.makeText(getApplication(),final_Score+"/5",Toast.LENGTH_SHORT).show();
    }

    private void setImage(int score) {
        String text="<html><body><font color=#91A1AB> <small> You got </small> </font> <font color=#826FDB><big> "+ score + "/10" + "</big> </font> </body><html>";
        score_txt.setText(Html.fromHtml( text));
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.HomePage_btn:
                Intent start = new Intent(ResultActivity.this, HomeActivity.class);
                startActivity(start);
                finish();
                break;

            case R.id.review_btn:
                Intent start1 = new Intent(ResultActivity.this, ReviewActivity.class);
                startActivity(start1);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.exit_popup);
        dialog.setCancelable(false);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = (int) (screen_Width * 0.95);//WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);

        yes_button = (Button) dialog.findViewById(R.id.yes_button);
        no_button = (Button) dialog.findViewById(R.id.no_button);
        cancel_popup = (ImageView) dialog.findViewById(R.id.cancel_popup);

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(ResultActivity.this, HomeActivity.class);
                startActivity(start);
                finish();
            }
        });

        cancel_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}
