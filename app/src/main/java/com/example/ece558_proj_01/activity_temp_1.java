package com.example.ece558_proj_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_temp_1 extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_LASTBUTTONID = "lastbuttonpressed";

    private Button mButton1;
    private Button mButton2;
    private TextView mText;
    protected int mLastButtonId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_1);

        // bind objects to views
        mButton1 = findViewById(R.id.btn_1);
        mButton2 = findViewById(R.id.btn_2);
        mText = findViewById(R.id.tv_pressed);

        // hook listener for the buttons
        mButton1.setOnClickListener(btnListener);
        mButton2.setOnClickListener(btnListener);

        // restore
        if (savedInstanceState != null){
            // restore mLastButtonId
            mLastButtonId = Integer.parseInt(savedInstanceState.getString(KEY_LASTBUTTONID));

            // update textview
            if (mLastButtonId == 0){
                mText.setText("No button has been pressed");
            } else {
                mText.setText("Button " + mLastButtonId + " has been pressed");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // save mLastButtonId
        savedInstanceState.putString(KEY_LASTBUTTONID, String.valueOf(mLastButtonId));
    }


    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {

            // record button id
            if (v.getId() == R.id.btn_1){
                mLastButtonId = 1;
            } else {
                mLastButtonId = 2;
            }

            // update textview
            mText.setText("Button " + mLastButtonId + " has been pressed");
        }
    };
}