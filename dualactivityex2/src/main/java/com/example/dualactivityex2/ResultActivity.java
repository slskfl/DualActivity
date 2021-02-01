package com.example.dualactivityex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    Button btnReturn;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btnReturn=findViewById(R.id.btnReturn);
        Intent gIntent=getIntent();

        if(gIntent.getIntExtra("Check",0)==1){
            result =gIntent.getIntExtra("Num1",0 )+gIntent.getIntExtra("Num2",0);
        }else if(gIntent.getIntExtra("Check",0)==2){
            result =gIntent.getIntExtra("Num1",0 )-gIntent.getIntExtra("Num2",0);
        }else if(gIntent.getIntExtra("Check",0)==3){
            result =gIntent.getIntExtra("Num1",0 )*gIntent.getIntExtra("Num2",0);
        }else if(gIntent.getIntExtra("Check",0)==4){
            result =gIntent.getIntExtra("Num1",0 )/gIntent.getIntExtra("Num2",0);
        }

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent=new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Hap", result);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}