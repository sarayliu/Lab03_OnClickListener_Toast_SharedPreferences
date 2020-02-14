package com.liusara.lab03_onclicklistenertoastsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView displayText1;
    TextView displayText2;
    TextView displayText3;
    TextView displayText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener displayText = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast =  Toast.makeText(getApplicationContext(),"hi mom"+v.getId()+":"+v.getTag(), Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        displayText1.setOnClickListener(displayText);
        displayText2.setOnClickListener(displayText);
        displayText3.setOnClickListener(displayText);
        displayText4.setOnClickListener(displayText);
    }
}
