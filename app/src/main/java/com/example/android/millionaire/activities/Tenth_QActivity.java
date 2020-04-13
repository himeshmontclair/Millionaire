package com.example.android.millionaire.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.millionaire.HomeActivity;
import com.example.android.millionaire.R;
import com.example.android.millionaire.ResultActivity;
import com.example.android.millionaire.Utilities;

public class Tenth_QActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup radioGroup_tenth_question;
    private TextView tenth_answer;
    private int tenth_ans;
    private Button confirm_tenth;
    private RadioButton rb_one;
    private RadioButton rb_two;
    private RadioButton rb_three;
    private RadioButton rb_four;
    private RadioButton radioButton;
    private int screen_Width;
    private int screen_height;
    private Button yes_button,no_button;
    private ImageView cancel_popup;
    private TextView confirm;
    private TextView no;
    private Dialog confirmdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth__q);
        findViews();
        DisplayMetrics dm = new DisplayMetrics();
        Tenth_QActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_Width = dm.widthPixels;
        screen_height = dm.heightPixels;
    }

    private void findViews() {
        String ninth_ans = Utilities.getpref(Tenth_QActivity.this,"nine","");
        tenth_answer = (TextView) findViewById(R.id.tenth_answer);
        if(Utilities.Ninth_Ans.equals("50")){
            tenth_ans = Integer.valueOf(ninth_ans)+100;
            tenth_answer.setText("You earned "+"$ "+tenth_ans);
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        }else{
            tenth_ans = Integer.valueOf(ninth_ans);
            tenth_answer.setText("You earned "+"$ "+tenth_ans);
            Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
        }
        Utilities.savePref(Tenth_QActivity.this,"tenth",String.valueOf(tenth_ans));

        confirm_tenth = (Button) findViewById(R.id.confirm_tenth);
        confirm_tenth.setOnClickListener(this);

//        back_img5 = (ImageView) findViewById(R.id.back_img5);
//        back_img5.setOnClickListener(this);

        radioGroup_tenth_question = (RadioGroup) findViewById(R.id.radioGroup_tenth_question);
        rb_one = (RadioButton) findViewById(R.id.rb_one);
        rb_two = (RadioButton) findViewById(R.id.rb_two);
        rb_three = (RadioButton) findViewById(R.id.rb_three);
        rb_four = (RadioButton) findViewById(R.id.rb_four);

        backup();
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm_tenth:
                popup();
                break;

//            case R.id.back_img5:
//                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
//                finish();
//                break;
        }
    }

    private void popup() {
        confirmdialog = new Dialog(this);
        confirmdialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        confirmdialog.setContentView(R.layout.confirm_popup);
        confirmdialog.setCancelable(false);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(confirmdialog.getWindow().getAttributes());
        lp.width = (int) (screen_Width * 0.95);//WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        confirmdialog.getWindow().setAttributes(lp);

        confirm = (TextView) confirmdialog.findViewById(R.id.confirm);
        no = (TextView) confirmdialog.findViewById(R.id.no);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm_method();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmdialog.dismiss();
            }
        });

        confirmdialog.show();

    }

    private void confirm_method() {
        // get selected radio button from radioGroup
        int selectedId = radioGroup_tenth_question.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        try {
            if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                Intent tofifth = new Intent(Tenth_QActivity.this, ResultActivity.class);
                startActivity(tofifth);
                finish();
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                Utilities.Result_btn_click = true;

                Utilities.Tenth_Ans = radioButton.getText().toString();

            } else {
                Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                confirmdialog.dismiss();
            }
        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
            confirmdialog.dismiss();
        }

    }

    private void backup() {
        if (Utilities.Tenth_Ans != null) {
            switch (Utilities.Tenth_Ans) {
                case "John Glenn":
                    rb_one.setChecked(true);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Jim Lowell":
                    rb_one.setChecked(false);
                    rb_two.setChecked(true);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Neil Armstrong":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(true);
                    rb_four.setChecked(false);
                    break;

                case "James E. Atwater":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(true);
                    break;
            }
        }
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
                Intent i = new Intent(Tenth_QActivity.this, HomeActivity.class);
                startActivity(i);
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
