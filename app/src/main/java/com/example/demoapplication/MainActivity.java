package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText et_pan ;
     String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //first 5 char are alpha
        //next 4 are numerical
        //1 again aplha
        //highlight the border of textfield with green
     et_pan = findViewById(R.id.et_pan);


       et_pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation() {
    String  pan=  et_pan.getText().toString().trim();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pan);
       /* if(pan.length()<10)
        {
            Toast.makeText(this,"Length must be 10",Toast.LENGTH_SHORT).show();
        }*/
         if(pan.matches(regex)){
            et_pan.setBackgroundResource(R.drawable.bg1);
            Toast.makeText(this,"Incorrect PAN",Toast.LENGTH_SHORT).show();
        }
        else
        {
            et_pan.setBackgroundResource(R.drawable.bg);
            Toast.makeText(this,"Correct PAN",Toast.LENGTH_SHORT).show();
        }


    }
}