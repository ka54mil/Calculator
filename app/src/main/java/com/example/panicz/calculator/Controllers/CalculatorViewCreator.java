package com.example.panicz.calculator.Controllers;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.panicz.calculator.R;

public class CalculatorViewCreator {
    private Activity activity;
    private GridLayout gridButtons;
    private DisplayMetrics displayMetrics;

    public CalculatorViewCreator(Activity activity){

        this.activity = activity;
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
        for (int i = 0; i < 10; i++) {
            gridButtons.addView(new Button(activity));
        }
    }

    private void setAttributesToTextField(EditText textField){
        textField.setText("0");
        textField.setId(R.id.equationTextField);
        gridButtons.addView(textField);
    }

    private void createVerticalView(GridLayout gridButtons){

    }
}
