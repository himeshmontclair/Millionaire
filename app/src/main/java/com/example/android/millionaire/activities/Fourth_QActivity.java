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

public class Fourth_QActivity extends AppCompatActivity implements View.OnClickListener {

    private Button confirm_fourth;
    private ImageView back;
    private ImageView back_img4;
    private RadioGroup radioGroup_fourt_question;
    RadioButton radioButton;

    private RadioButton rb_one, rb_two, rb_three, rb_four;
    private TextView fourth_answer;
    private int fourth_ans;
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
        setContentView(R.layout.activity_fourth__q);
        findViews();
        DisplayMetrics dm = new DisplayMetrics();
        Fourth_QActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        screen_Width = dm.widthPixels;
        screen_height = dm.heightPixels;
    }

    private void findViews() {
        String third_ans = Utilities.getpref(Fourth_QActivity.this,"third","");
        fourth_answer = (TextView) findViewById(R.id.fourth_answer);
        if(Utilities.Third_Ans.equals("148million km sq")){
            fourth_ans = Integer.valueOf(third_ans)+100;
            fourth_answer.setText("You earned "+"$ "+fourth_ans);
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
        }else{
            fourth_ans = Integer.valueOf(third_ans);
            fourth_answer.setText("You earned "+"$ "+fourth_ans);
            Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show();
        }
        Utilities.savePref(Fourth_QActivity.this,"fourth",String.valueOf(fourth_ans));

        confirm_fourth = (Button) findViewById(R.id.confirm_fourth);
        confirm_fourth.setOnClickListener(this);

        back_img4 = (ImageView) findViewById(R.id.back_img4);
        back_img4.setOnClickListener(this);

        radioGroup_fourt_question = (RadioGroup) findViewById(R.id.radioGroup_fourt_question);
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
            case R.id.confirm_fourth:
                popup();
                break;

            case R.id.back_img4:
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
        // get selected radio button from radioGroup
        int selectedId = radioGroup_fourt_question.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

        try {
            if (!radioButton.getText().toString().isEmpty() && radioButton.getText().toString() != null) {
                Intent tofifth = new Intent(Fourth_QActivity.this, Fifth_QActivity.class);
                startActivity(tofifth);
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_right);

                Utilities.Fourth_Ans = radioButton.getText().toString();
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
        if (Utilities.Fourth_Ans != null) {
            switch (Utilities.Fourth_Ans) {
                case "Christopher Columbus":
                    rb_one.setChecked(true);
                    rb_two.setChecked(false);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Vasco da Gama":
                    rb_one.setChecked(false);
                    rb_two.setChecked(true);
                    rb_three.setChecked(false);
                    rb_four.setChecked(false);
                    break;

                case "Marco Polo":
                    rb_one.setChecked(false);
                    rb_two.setChecked(false);
                    rb_three.setChecked(true);
                    rb_four.setChecked(false);
                    break;

                case "John Cabot":
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
                Intent i = new Intent(Fourth_QActivity.this, HomeActivity.class);
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

