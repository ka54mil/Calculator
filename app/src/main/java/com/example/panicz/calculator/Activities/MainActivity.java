package com.example.panicz.calculator.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.panicz.calculator.Controllers.CalculatorViewCreator;
import com.example.panicz.calculator.Math.Constants;
import com.example.panicz.calculator.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        saveConstantsOnDevice();
        CalculatorViewCreator buttons = new CalculatorViewCreator(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveConstantsOnDevice(){

        try {
            InputStream is = getAssets().open(Constants.getFileName());
            Constants.setFileName(getFilesDir()+Constants.getFileName());
            File constants = new File(Constants.getFileName());
            if(!constants.exists()){
                constants.createNewFile();
            }

            OutputStream os = new FileOutputStream(constants);
            byte [] buffer = new byte [1024];
            int length =0;
            while((length = is.read(buffer))!=-1){
                os.write(buffer,0,length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
