package com.example.android.millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Home_page_btn;
    private ImageView back_img;
    private TextView first_ans_txt,second_ans_txt,third_ans_txt,fourth_ans_txt,fifth_ans_txt,sixth_ans_txt,seventh_ans_txt,eigth_ans_txt,ninth_ans_txt,tenth_ans_txt;
    String first_selcted_ans,second_selcted_ans,third_selcted_ans,fourth_selcted_ans,five_selcted_ans,sixth_selcted_ans,seventh_selcted_ans,eigth_selcted_ans,ninth_selcted_ans,tenth_selcted_ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        findViewes();
        setAnswers();
    }


    private void findViewes() {
        Home_page_btn=(Button)findViewById(R.id.Home_page_btn);
        Home_page_btn.setOnClickListener(this);

        back_img=(ImageView)findViewById(R.id.back_img);
        back_img.setOnClickListener(this);

        first_ans_txt=(TextView)findViewById(R.id.first_ans_txt);
        second_ans_txt=(TextView)findViewById(R.id.second_ans_txt);
        third_ans_txt=(TextView)findViewById(R.id.third_ans_txt);
        fourth_ans_txt=(TextView)findViewById(R.id.fourth_ans_txt);
        fifth_ans_txt=(TextView)findViewById(R.id.fifth_ans_txt);
        sixth_ans_txt=(TextView)findViewById(R.id.sixth_ans_txt);
        seventh_ans_txt=(TextView)findViewById(R.id.seventh_ans_txt);
        eigth_ans_txt=(TextView)findViewById(R.id.eigth_ans_txt);
        ninth_ans_txt=(TextView)findViewById(R.id.ninth_ans_txt);
        tenth_ans_txt=(TextView)findViewById(R.id.tenth_ans_txt);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.Home_page_btn:
                Intent start = new Intent(ReviewActivity.this, HomeActivity.class);
                startActivity(start);
                finish();
                break;

            case R.id.back_img:
                finish();
                break;
        }
    }

    private void setAnswers() {
      //first
        if(Utilities.First_Ans.equals("US and Canada")){
            first_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.First_Ans + " </font> </body><html>";
        }else {
            first_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.First_Ans + " </font> </body><html>";
        }
        first_ans_txt.setText(Html.fromHtml( first_selcted_ans));

        //Second
        if(Utilities.Second_Ans.equals("Headache")){
            second_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Second_Ans + " </font> </body><html>";
        }else {
            second_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Second_Ans + " </font> </body><html>";
        }
        second_ans_txt.setText(Html.fromHtml( second_selcted_ans));

        //Third
        if(Utilities.Third_Ans.equals("148million km sq")){
            third_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Third_Ans + " </font> </body><html>";
        }else {
            third_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Third_Ans + " </font> </body><html>";
        }
        third_ans_txt.setText(Html.fromHtml( third_selcted_ans));


        //Fourth
        if(Utilities.Fourth_Ans.equals("Vasco da Gama")){
            fourth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Fourth_Ans + " </font> </body><html>";
        }else {
            fourth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Fourth_Ans + " </font> </body><html>";
        }
        fourth_ans_txt.setText(Html.fromHtml( fourth_selcted_ans));

        //Fifth
        if(Utilities.Fifth_Ans.equals("Tim Berners-Lee")){
            five_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Fifth_Ans + " </font> </body><html>";
        }else {
            five_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Fifth_Ans + " </font> </body><html>";
        }
        fifth_ans_txt.setText(Html.fromHtml( five_selcted_ans));

        //sixth
        if(Utilities.Sixth_Ans.equals("Greenland")){
            sixth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Sixth_Ans + " </font> </body><html>";
        }else {
            sixth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Sixth_Ans + " </font> </body><html>";
        }
        sixth_ans_txt.setText(Html.fromHtml( sixth_selcted_ans));

        //seventh
        if(Utilities.Seventh_Ans.equals("Norway")){
            seventh_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Seventh_Ans + " </font> </body><html>";
        }else {
            seventh_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Seventh_Ans + " </font> </body><html>";
        }
        seventh_ans_txt.setText(Html.fromHtml( seventh_selcted_ans));

        //Eighth
        if(Utilities.Eight_Ans.equals("Republicans and Democrats")){
            eigth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Eight_Ans + " </font> </body><html>";
        }else {
            eigth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Eight_Ans + " </font> </body><html>";
        }
        eigth_ans_txt.setText(Html.fromHtml( eigth_selcted_ans));

        //Ninth
        if(Utilities.Ninth_Ans.equals("50")){
            ninth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Ninth_Ans + " </font> </body><html>";
        }else {
            ninth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Ninth_Ans + " </font> </body><html>";
        }
        ninth_ans_txt.setText(Html.fromHtml( ninth_selcted_ans));

        //Tenth
        if(Utilities.Tenth_Ans.equals("Neil Armstrong")){
            tenth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#008000>"+ Utilities.Tenth_Ans + " </font> </body><html>";
        }else {
            tenth_selcted_ans="<html><body><font color=#000>  Your Answer     :  </font> <font color=#AD1F2D>"+ Utilities.Tenth_Ans + " </font> </body><html>";
        }
        tenth_ans_txt.setText(Html.fromHtml( tenth_selcted_ans));
    }
}
