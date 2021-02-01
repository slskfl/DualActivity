package com.example.dualactivityex2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNum1, edtNum2;
    RadioGroup rdoG;
    RadioButton rdoAdd, rdoMin, rdoMul, rdoDiv;
    Button btnCalc;
    TextView tvResult;
    int rdoResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1=findViewById(R.id.edtNum1);
        edtNum2=findViewById(R.id.edtNum2);
        rdoG=findViewById(R.id.rdoG);
        rdoAdd=findViewById(R.id.rdoAdd);
        rdoMin=findViewById(R.id.rdoMin);
        rdoMul=findViewById(R.id.rdoMul);
        rdoDiv=findViewById(R.id.rdoDiv);
        btnCalc=findViewById(R.id.btnCalc);
        tvResult=findViewById(R.id.tvResult);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));

                switch (rdoG.getCheckedRadioButtonId()){
                    case R.id.rdoAdd:
                        rdoResult=1;
                        break;
                    case R.id.rdoMin:
                        rdoResult=2;
                        break;
                    case R.id.rdoMul:
                        rdoResult=3;
                        break;
                    case R.id.rdoDiv:
                        rdoResult=4;
                        break;
                }
                intent.putExtra("Check", rdoResult);
                startActivityForResult(intent,0);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            tvResult.setText("결과값="+ data.getIntExtra("Hap",0));
        }

    } 
}