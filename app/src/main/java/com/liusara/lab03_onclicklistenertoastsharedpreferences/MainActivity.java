package com.liusara.lab03_onclicklistenertoastsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView displayText1;
    TextView displayText2;
    TextView displayText3;
    TextView displayText4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int count1;
    int count2;
    int count3;
    int count4;
    SeekBar seekbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        displayText1 = findViewById(R.id.textBox1);
        displayText2 = findViewById(R.id.textBox2);
        displayText3 = findViewById(R.id.textBox3);
        displayText4 = findViewById(R.id.textBox4);
        seekbar = findViewById(R.id.seekBar);

        count1 = sharedPreferences.getInt("count1", 0);
        count2 = sharedPreferences.getInt("count2", 0);
        count3 = sharedPreferences.getInt("count3", 0);
        count4 = sharedPreferences.getInt("count4", 0);

        final View.OnClickListener displayText = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textBox = (TextView) v;
                int count;
                if(textBox.getId() == R.id.textBox1)
                {
                    count1++;
                    count = count1;
                    editor.putInt("count1", count1);
                }
                else if(textBox.getId() == R.id.textBox2)
                {
                    count2++;
                    count = count2;
                    editor.putInt("count2", count2);
                }
                else if(textBox.getId() == R.id.textBox3)
                {
                    count3++;
                    count = count3;
                    editor.putInt("count3", count3);
                }
                else
                {
                    count4++;
                    count = count4;
                    editor.putInt("count4", count4);
                }
                editor.apply();
                Toast toast =  Toast.makeText(getApplicationContext(),v.getId()+" was pressed "+ count + " times", Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        displayText1.setOnClickListener(displayText);
        displayText2.setOnClickListener(displayText);
        displayText3.setOnClickListener(displayText);
        displayText4.setOnClickListener(displayText);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                displayText1.setTextSize(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
