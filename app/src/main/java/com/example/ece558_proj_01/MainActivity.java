package com.example.ece558_proj_01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // editable for operand 1
    EditText edit_op_1;

    // editable for operand 2
    EditText edit_op_2;

    // text-view for result
    TextView tv_result;

    // button for plus
    Button btn_plus;

    // button for minus
    Button btn_minus;

    // button for multiply
    Button btn_multiply;

    // button for divide
    Button btn_divide;

    // button for percentage
    Button btn_percentage;

    // button for square-root
    Button btn_sqrt;

    // store value of operand 1
    double op_1;

    // store value of operand 2
    double op_2;

    // tag for debug system
    String log_tag_system = "SYSTEM";

    // tag for debug misc
    String log_tag_misc = "MISC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(log_tag_system, "onCreate is called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect objects to views
        edit_op_1 = findViewById(R.id.edit_op_1);
        edit_op_2 = findViewById(R.id.edit_op_2);
        tv_result = findViewById(R.id.tv_result);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);
        btn_percentage = findViewById(R.id.btn_percentage);
        btn_sqrt = findViewById(R.id.btn_sqrt);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(log_tag_system, "onSaveInstanceState is called");

        super.onSaveInstanceState(outState);

//        Log.d(log_tag_misc, "Resource name = " + getResources().getResourceName(R.id.edit_op_1));
//        outState.putString(getResources().getResourceName(R.id.edit_op_1), edit_op_1.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(log_tag_system, "onResume is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(log_tag_system, "onStart is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(log_tag_system, "onDestroy is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(log_tag_system, "onStop is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(log_tag_system, "onPause is called");
    }

    /**
     * Handle click-event for button plus
     */
    public void onClick_btn_plus(View view){
        // check
        if (!check_update_operands()){
            return;
        }

        // compute & display
        Double result = op_1 + op_2;
        tv_result.setText(result.toString());
    }

    /**
     * Handle click-event for button minus
     */
    public void onClick_btn_minus(View view){
        // check
        if (!check_update_operands()){
            return;
        }

        // compute & display
        Double result = op_1 - op_2;
        tv_result.setText(result.toString());
    }

    /**
     * Handle click-event for button multiply
     */
    public void onClick_btn_multiply(View view){
        // check
        if (!check_update_operands()){
            return;
        }

        // compute & display
        Double result = op_1 * op_2;
        tv_result.setText(result.toString());
    }

    /**
     * Handle click-event for button divide
     */
    public void onClick_btn_divide(View view){
        // check
        if (!check_update_operands()){
            return;
        }
        if (op_2 == 0){
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            return;
        }

        // compute & display
        Double result = op_1 / op_2;
        tv_result.setText(result.toString());
    }

    /**
     * Handle click-event for button percentage
     */
    public void onClick_btn_percentage(View view){
        // check
        if (!check_update_operand(true)){
            return;
        }

        // compute & display
        Double result = op_1 / 100.0;
        tv_result.setText(result.toString());
    }

    /**
     * Handle click-event for button square-root
     */
    public void onClick_btn_sqrt(View view){
        // check
        if (!check_update_operand(true)){
            return;
        }

        // compute & display
        Double result = Math.sqrt(op_1);
        tv_result.setText(result.toString());
    }

    /**
     * Check & update the given selected operand
     * @param is_op_1   True if operand 1, False if operand 2
     * @return TRUE if the operand is retrieved successfully, FALSE otherwise in case the operand
     * is invalid
     */
    public boolean check_update_operand(boolean is_op_1){

        // check empty
        if (is_op_1 && edit_op_1.getText().toString().isEmpty()){
            Toast.makeText(this, "Operand 1 is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((!is_op_1) && edit_op_2.getText().toString().isEmpty()){
            Toast.makeText(this, "Operand 2 is empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            if (is_op_1) {
                op_1 = Double.parseDouble(edit_op_1.getText().toString());
            } else {
                op_2 = Double.parseDouble(edit_op_2.getText().toString());
            }
        } catch (NumberFormatException e){
            Toast.makeText(this, "Invalid format operands", Toast.LENGTH_SHORT).show();
            return false;
        } catch (Exception e){
            Toast.makeText(this, "Invalid operands", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Check & update 2 operands
     * @return TRUE if 2 operands are retrieved successfully, FALSE otherwise in case the operands
     * are invalid
     */
    public boolean check_update_operands(){

        if (!check_update_operand(true)){
            return false;
        }

        return check_update_operand(false);
    }
}