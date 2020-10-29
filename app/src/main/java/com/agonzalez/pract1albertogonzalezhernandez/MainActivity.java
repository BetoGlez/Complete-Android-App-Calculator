package com.agonzalez.pract1albertogonzalezhernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

enum Operation{ Add, Subtract, Multiply, Divide, Equal };
enum AlternativeOperation{ Pow, Sqrt };

public class MainActivity extends AppCompatActivity {

    private static final String DOT_CHARACTER = ".";

    private TextView operationResultTv;
    private Button n1Btn, n2Btn, n3Btn, n4Btn, n5Btn, n6Btn, n7Btn, n8Btn, n9Btn, n0Btn, plusBtn, minusBtn, multiplyBtn, divideBtn,
            equalBtn, cBtn, doBtn, offBtn, powBtn, sqrtBtn;

    private double op1;
    private double op2;
    private String displayNumber = "";
    private Operation currOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1Btn = (Button)findViewById(R.id.n1Button);
        n2Btn = (Button)findViewById(R.id.n2Button);
        n3Btn = (Button)findViewById(R.id.n3Button);
        n4Btn = (Button)findViewById(R.id.n4Button);
        n5Btn = (Button)findViewById(R.id.n5Button);
        n6Btn = (Button)findViewById(R.id.n6Button);
        n7Btn = (Button)findViewById(R.id.n7Button);
        n8Btn = (Button)findViewById(R.id.n8Button);
        n9Btn = (Button)findViewById(R.id.n9Button);
        n0Btn = (Button)findViewById(R.id.n0Button);
        plusBtn = (Button)findViewById(R.id.plusButton);
        minusBtn = (Button)findViewById(R.id.minusButton);
        multiplyBtn = (Button)findViewById(R.id.multiplyButton);
        divideBtn = (Button)findViewById(R.id.divideButton);
        equalBtn = (Button)findViewById(R.id.equalButton);
        cBtn = (Button)findViewById(R.id.cButton);
        doBtn = (Button)findViewById(R.id.dotButton);
        powBtn = (Button)findViewById(R.id.potButton);
        sqrtBtn = (Button)findViewById(R.id.rootButton);
        offBtn = (Button)findViewById(R.id.offButton);

        operationResultTv = (TextView)findViewById(R.id.ResultTextView);
        setResultText(0);

        n1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("1");
            }
        });
        n2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("2");
            }
        });
        n3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("3");
            }
        });
        n4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("4");
            }
        });
        n5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("5");
            }
        });
        n6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("6");
            }
        });
        n7Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("7");
            }
        });
        n8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("8");
            }
        });
        n9Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("9");
            }
        });
        n0Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNumberValue("0");
            }
        });
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.Add);
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.Subtract);
            }
        });
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.Multiply);
            }
        });
        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.Divide);
            }
        });
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.Equal);
            }
        });
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });
        doBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDot();
            }
        });
        powBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlternativeOperation(AlternativeOperation.Pow);
            }
        });
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlternativeOperation(AlternativeOperation.Sqrt);
            }
        });
        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitApp();
            }
        });
    }

    private void setNumberValue(String number) {
        displayNumber += number;
        setResultText((Double.parseDouble(displayNumber)));
    }

    private void setResultText(double number) {
        operationResultTv.setText(String.valueOf(number));
    }

    private void setOperation(Operation operation) {
        if (!displayNumber.isEmpty()) {
            if (op1 == 0.0) {
                op1 = Double.parseDouble(displayNumber);
            } else {
                op2 = Double.parseDouble(displayNumber);
                op1 = performOperation(op1, op2, currOperation);
                setResultText(op1);
            }
        }
        currOperation = operation;
        displayNumber = "";
    }

    private double performOperation(double op1, double op2, Operation operation) {
        double result = 0.0;
        switch (operation) {
            case Add:
                result = op1 + op2;
                break;
            case Subtract:
                result = op1 - op2;
                break;
            case Multiply:
                result = op1 * op2;
                break;
            case Divide:
                result = op1 / op2;
                break;
            case Equal:
                result = op1;
                break;
        }
        return result;
    }
    
    private void clearAll() {
        currOperation = null;
        displayNumber = "";
        op1 = 0.0;
        op2 = 0.0;
        setResultText(0);
    }

    private void addDot() {
        if (!displayNumber.isEmpty() && !displayNumber.contains(DOT_CHARACTER)) {
            setNumberValue(DOT_CHARACTER);
        }
    }

    private void setAlternativeOperation(AlternativeOperation alternativeOp) {
        if (op1 == 0.0 && !displayNumber.isEmpty()) {
            op1 = Double.parseDouble(displayNumber);
        }
        op2 = 0.0;
        double altOpResult = 0.0;
        switch (alternativeOp) {
            case Pow:
                altOpResult = Math.pow(op1, 2);
                break;
            case Sqrt:
                altOpResult = Math.sqrt(op1);
                break;
        }
        setResultText(altOpResult);
        op1 = altOpResult;
        currOperation = null;
        displayNumber = "";
    }

    private void calculateRoot() {

    }

    private void quitApp() {
        MainActivity.this.finish();
        System.exit(0);
    }
}