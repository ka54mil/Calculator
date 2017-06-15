package com.example.panicz.calculator.Controllers;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.panicz.calculator.R;

public class CalculatorViewCreator {
    private Activity activity;
    private GridLayout gridButtons;
    private DisplayMetrics displayMetrics;
    private String values [];

    public CalculatorViewCreator(Activity activity){

        this.activity = activity;
        values = new String[]{"1", "2", "3", "+", "-", "4", "5", "6", "*", "/", "7", "8", "9", "0", "^", "( )",".", "+/-", "C", "="};
        displayMetrics = new DisplayMetrics();
        gridButtons = (GridLayout)activity.findViewById(R.id.GridButtons);
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        recreateView();
    }

    public void recreateView(){
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        gridButtons.removeViewsInLayout(1,gridButtons.getChildCount()-1);
        if (height>width) {
            createHorizontalView(gridButtons);
        } else {
            createVerticalView(gridButtons);
        }

    }

    private void createHorizontalView(GridLayout gridButtons){
        EditText equationTextField = new EditText(activity);
        setAttributesToTextField(equationTextField);
        for (int i = 0; i < values.length; i++) {

            Button tmp = new Button(activity);
            tmp.setId(activity.getResources().getIdentifier("button"+i, "id", activity.getPackageName()));
            tmp.setText(values[i]);
            gridButtons.addView(tmp);
        }
    }

    private void setAttributesToTextField(EditText textField){
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.columnSpec = GridLayout.spec(0,5);
        textField.setLayoutParams(params);
        textField.setText("0");
        textField.setGravity(Gravity.CLIP_HORIZONTAL|Gravity.TOP|Gravity.BOTTOM);
        textField.setId(R.id.equationTextField);
        gridButtons.setPadding(5,0,5,0);
        gridButtons.addView(textField);
    }

    private void createVerticalView(GridLayout gridButtons){

    }
}
