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

public class Fifth_QActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm_fifth;
    private ImageView back_img5;
    private RadioGroup radioGroup_fifth_question;
    RadioButton radioButton;
    private RadioButton rb_one, rb_two, rb_three, rb_four;
    TextView fifth_answer;
    private int fifth_ans;
    private int screen_Width;
    private int screen_height;
    private Button yes_button, no_button;
    private ImageView cancel_popup;
    private TextView confirm;
    private TextView no;
    private Dialog confirmdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth__q);

        findViews();

        DisplayMetrics dm = new DisplayMetrics();
        Fifth_QActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_Width = dm.widthPixels;
        screen_height = dm.heightPixels;
    }

    private void findViews() {
        String fourth_ans = Utilities.getpref(Fifth_QActivity.this, "fourth", "");
        fifth_answer = (TextView) findViewById(R.id.fifth_answer);
        if (Utilities.Fourth_Ans.equals("Vasco da Gama")) {
            fifth_ans = Integer.valueOf(fourth_ans) + 100;
            fifth_answer.setText("You earned " + "$ " + fifth_ans);
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        } else {
            fifth_ans = Integer.valueOf(fourth_ans);
            fifth_answer.setText("You earned " + "$ " + fifth_ans);
            Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
        }
        Utilities.savePref(Fifth_QActivity.this, "fifth", String.valueOf(fifth_ans));

        confirm_fifth = (Button) findViewById(R.id.confirm_fifth);
        confirm_fifth.setOnClickListener(this);

        back_img5 = (ImageView) findViewById(R.id.back_img5);
        back_img5.setOnClickListener(this);

        radioGroup_fifth_question = (RadioGroup) findViewById(R.id.radioGroup_fifth_question);
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
            case R.id.confirm_fifth:
                // get selected radio button from radioGroup
                int selectedId = radioGroup_fifth_question.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                radioButton = (RadioButton) findViewById(selectedId);
                if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                    popup();
                } else {
                    Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
                    confirmdialog.dismiss();
                }
                    break;

                    case R.id.back_img5:
                        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_from_left);
                        finish();
                        break;
                }
        }

        private void popup () {
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

        private void confirm_method () {
            try {
                Intent tofifth = new Intent(Fifth_QActivity.this, Sixth_QActivity.class);
                startActivity(tofifth);
                finish();
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);
                Utilities.Result_btn_click = true;

                Utilities.Fifth_Ans = radioButton.getText().toString();

            } catch (NullPointerException e) {
                Toast.makeText(getApplicationContext(), "Please choose your option", Toast.LENGTH_SHORT).show();
            }
        }

        private void backup () {
            if (Utilities.Fifth_Ans != null) {
                switch (Utilities.Fifth_Ans) {
                    case "Tim Berners-Lee":
                        rb_one.setChecked(true);
                        rb_two.setChecked(false);
                        rb_three.setChecked(false);
                        rb_four.setChecked(false);
                        break;

                    case "Bob Kahn":
                        rb_one.setChecked(false);
                        rb_two.setChecked(true);
                        rb_three.setChecked(false);
                        rb_four.setChecked(false);
                        break;

                    case "Steve Jobs":
                        rb_one.setChecked(false);
                        rb_two.setChecked(false);
                        rb_three.setChecked(true);
                        rb_four.setChecked(false);
                        break;

                    case "Bill Gates":
                        rb_one.setChecked(false);
                        rb_two.setChecked(false);
                        rb_three.setChecked(false);
                        rb_four.setChecked(true);
                        break;
                }
            }
        }
        @Override
        public void onBackPressed () {
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
                    Intent i = new Intent(Fifth_QActivity.this, HomeActivity.class);
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
