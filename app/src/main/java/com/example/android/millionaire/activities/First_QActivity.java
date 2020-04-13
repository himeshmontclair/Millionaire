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
import com.example.android.millionaire.Utilities;

public class First_QActivity extends AppCompatActivity implements View.OnClickListener {
    Button confirm_first;
    ImageView back_img1;
    private RadioGroup radioGroup_first_question;
    RadioButton radioButton;
    private RadioButton rb_one, rb_two, rb_three, rb_four;
    TextView first_answer;
    int first_amt;
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
        setContentView(R.layout.activity_first__q);
        findViews();

        DisplayMetrics dm = new DisplayMetrics();
        First_QActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_Width = dm.widthPixels;
        screen_height = dm.heightPixels;
    }

    private void findViews() {
        first_answer = (TextView) findViewById(R.id.first_answer);
        first_amt = 0;
        first_answer.setText("You earned "+"$ "+first_amt);
        Utilities.savePref(First_QActivity.this,"first",String.valueOf(first_amt));

        confirm_first = (Button) findViewById(R.id.confirm_first);
        confirm_first.setOnClickListener(this);

        back_img1 = (ImageView) findViewById(R.id.back_img1);
        back_img1.setOnClickListener(this);

        radioGroup_first_question = (RadioGroup) findViewById(R.id.radioGroup_first_question);
        rb_one = (RadioButton) findViewById(R.id.rb_one);
        rb_two = (RadioButton) findViewById(R.id.rb_two);
        rb_three = (RadioButton) findViewById(R.id.rb_three);
        rb_four = (RadioButton) findViewById(R.id.rb_four);

        backup();
    }

    private void backup() {
        if (Utilities.First_Ans != null) {
            switch (Utilities.First_Ans) {
                case "India and Pakistan":
                    rb_one.setChecked(true);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "US and Mexico":
                    rb_one.setChecked(false);
                    rb_two.setChecked(true);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "US and Canada":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(true);
                    rb_four.setChecked(false);
                    break;

                case "South Korea and North Korea":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm_first:
                popup();
                break;

            case R.id.back_img1:
                overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                finish();
                break;

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
        int selectedId = radioGroup_first_question.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

        try {
            if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                Utilities.First_Ans = radioButton.getText().toString();
                Intent tosecond = new Intent(First_QActivity.this, Second_QActivity.class);
                startActivity(tosecond);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
            } else {
                Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                confirmdialog.dismiss();
             }
        } catch (NullPointerException e) {
            Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
            confirmdialog.dismiss();
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
                Intent i = new Intent(First_QActivity.this, HomeActivity.class);
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