package com.example.ece558_proj_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // editable for operand 1
    EditText edit_op_1;

    // editable for operand 2
    EditText edit_op_2;

    // button for plus
    Button btn_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect object to views
        edit_op_1 = findViewById(R.id.edit_op_1);
        edit_op_2 = findViewById(R.id.edit_op_2);
        btn_plus = findViewById(R.id.btn_plus);
    }

    /**
     * Handle click-event for button plus
     */
    public void onClick_btn_plus(View view){
        Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
    }

    /**
     * Check & retrieve 2 operands
     * @return TRUE if 2 operands are retrieved successfully, FALSE otherwise in case the operands
     * are invalid
     */
    public boolean retrieve_operands(Double op_1, Double op_2){
        return false;
    }
}