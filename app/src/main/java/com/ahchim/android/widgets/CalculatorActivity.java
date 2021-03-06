package com.ahchim.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// TODO 나중에 BigDecimal로도 짜보기
// import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    TextView result;
    TextView preview;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnSum;
    Button btnSub;
    Button btnMultiple;
    Button btnDivide;

    Button btnCancle;
    Button btnRun;

    ArrayList<String> oper = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = (TextView) findViewById(R.id.result);
        preview = (TextView) findViewById(R.id.preview);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnSum = (Button) findViewById(R.id.btnSum);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMultiple = (Button) findViewById(R.id.btnMultiple);
        btnDivide = (Button) findViewById(R.id.btnDivide);

        btnCancle = (Button) findViewById(R.id.btnCancle);
        btnRun = (Button) findViewById(R.id.btnRun);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnSum.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMultiple.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnCancle.setOnClickListener(this);
        btnRun.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn0:
                if(preview.getText().toString().equals("0")) preview.setText("0");
                else preview.setText(preview.getText() + "0");
                break;
            case R.id.btn1:
                if(preview.getText().toString().equals("0")) preview.setText("1");
                else preview.setText(preview.getText() + "1");
                break;
            case R.id.btn2:
                if(preview.getText().toString().equals("0")) preview.setText("2");
                else preview.setText(preview.getText() + "2");
                break;
            case R.id.btn3:
                if(preview.getText().toString().equals("0")) preview.setText("3");
                else preview.setText(preview.getText() + "3");
                break;
            case R.id.btn4:
                if(preview.getText().toString().equals("0")) preview.setText("4");
                else preview.setText(preview.getText() + "4");
                break;
            case R.id.btn5:
                if(preview.getText().toString().equals("0")) preview.setText("5");
                else preview.setText(preview.getText() + "5");
                break;
            case R.id.btn6:
                if(preview.getText().toString().equals("0")) preview.setText("6");
                else preview.setText(preview.getText() + "6");
                break;
            case R.id.btn7:
                if(preview.getText().toString().equals("0")) preview.setText("7");
                else preview.setText(preview.getText() + "7");
                break;
            case R.id.btn8:
                if(preview.getText().toString().equals("0")) preview.setText("8");
                else preview.setText(preview.getText() + "8");
                break;
            case R.id.btn9:
                if(preview.getText().toString().equals("0")) preview.setText("9");
                else preview.setText(preview.getText() + "9");
                break;
            case R.id.btnSum:
                preview.setText(preview.getText() + " + ");
                oper.add("+");
                break;
            case R.id.btnSub:
                preview.setText(preview.getText() + " - ");
                oper.add("-");
                break;
            case R.id.btnMultiple:
                preview.setText(preview.getText() + " * ");
                oper.add("*");
                break;
            case R.id.btnDivide:
                preview.setText(preview.getText() + " / ");
                oper.add("/");
                break;
            case R.id.btnCancle:
                preview.setText("0");
                result.setText("0");

                oper.clear();
                break;
            case R.id.btnRun:
                String resultview = preview.getText().toString().replace(" ", "");  // 공백빼기
                String[] num = resultview.split("\\D");  // 문자 다 거르고 숫자만 배열에 넣기 (훗날 괄호까지 추가할수도 있는 상황을 위해 모든문자를 추가함..)

                ArrayList<String> numlist = new ArrayList<String>(Arrays.asList(num)); // ArrayList로 변환해서 넣고빼기 좋게 만듬

                int operIndex;  // 연산자 index 저장
                int operSize = oper.size();  // 연산횟수 고정하기 위해 int에 저장

                if(oper.size()!=0) {  // 연산자가 있어야 연산시작
                    for(int i=0; i<operSize; i++) {  // 우선순위는 if else문 순서에 따라
                        if(oper.indexOf("*")>=0){  // 곱연산이 존재하면 곱연산의 첫 번째 인덱스를 가져옴
                            // Index 임시저장
                            operIndex = oper.indexOf("*");

                            // (Index)값과 (Index + 1)값을 계산해서 Index 위치에 저장
                            numlist.set(operIndex, (Double.parseDouble(numlist.get(operIndex)) * Double.parseDouble(numlist.get(operIndex + 1))) + "");

                            oper.remove(operIndex);  // 계산후 연산자 List에서 삭제
                            numlist.remove(operIndex + 1);   // 계산후 (Index + 1)값 List에서 삭제

                        } else if(oper.indexOf("/")>=0){  // 나눗셈연산이 존재하면 나눗셈연산의 첫 번째 인덱스를 가져옴
                            // 곱연산과 로직 동일
                            operIndex = oper.indexOf("/");
                            numlist.set(operIndex, (Double.parseDouble(numlist.get(operIndex)) / Double.parseDouble(numlist.get(operIndex + 1))) + "");

                            oper.remove(operIndex);
                            numlist.remove(operIndex + 1);
                        } else if(oper.indexOf("+")>=0){  // 덧셈연산이 존재하면 덧셈연산의 첫 번째 인덱스를 가져옴
                            // 곱연산과 로직 동일
                            operIndex = oper.indexOf("+");
                            numlist.set(operIndex, (Double.parseDouble(numlist.get(operIndex)) + Double.parseDouble(numlist.get(operIndex + 1))) + "");

                            oper.remove(operIndex);
                            numlist.remove(operIndex + 1);
                        } else if(oper.indexOf("-")>=0){  // 뺄셈연산이 존재하면 뺄셈연산의 첫 번째 인덱스를 가져옴
                            // 곱연산과 로직 동일
                            operIndex = oper.indexOf("-");
                            numlist.set(operIndex, (Double.parseDouble(numlist.get(operIndex)) - Double.parseDouble(numlist.get(operIndex + 1))) + "");

                            oper.remove(operIndex);
                            numlist.remove(operIndex + 1);
                        }
                    }
                }

                // 마지막 남은 numlist List값을 가져옴.
                result.setText(numlist.get(0) + "");

                // operation 담는 List 초기화
                oper.clear();
                break;
        }
    }
}
