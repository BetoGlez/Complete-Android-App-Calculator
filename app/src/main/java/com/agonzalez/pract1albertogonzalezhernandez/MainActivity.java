package com.agonzalez.pract1albertogonzalezhernandez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

enum Operation{ Add, Subtract, Multiply, Divide, Equal }
enum AlternativeOperation{ Pow, Sqrt, Mod, Sin, Cos, Tan, OneDivideX }

public class MainActivity extends AppCompatActivity {

    private static final String OP1_KEY = "op1";
    private static final String OP2_KEY = "op2";
    private static final String DISPLAY_NUM_KEY = "displayNumber";
    private static final String CURR_OP_KEY = "currOperation";
    private static final String DOT_CHARACTER = ".";
    private static final String MINUS_CHARACTER = "-";
    private static final double PI_VALUE = 3.14159;

    private TextView operationResultTv;

    private double op1;
    private double op2;
    private String displayNumber = "";
    private Operation currOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n1Btn = findViewById(R.id.n1Button);
        Button n2Btn = findViewById(R.id.n2Button);
        Button n3Btn = findViewById(R.id.n3Button);
        Button n4Btn = findViewById(R.id.n4Button);
        Button n5Btn = findViewById(R.id.n5Button);
        Button n6Btn = findViewById(R.id.n6Button);
        Button n7Btn = findViewById(R.id.n7Button);
        Button n8Btn = findViewById(R.id.n8Button);
        Button n9Btn = findViewById(R.id.n9Button);
        Button n0Btn = findViewById(R.id.n0Button);
        Button plusBtn = findViewById(R.id.plusButton);
        Button minusBtn = findViewById(R.id.minusButton);
        Button multiplyBtn = findViewById(R.id.multiplyButton);
        Button divideBtn = findViewById(R.id.divideButton);
        Button equalBtn = findViewById(R.id.equalButton);
        Button cBtn = findViewById(R.id.cButton);
        Button ceBtn = findViewById(R.id.ceButton);
        Button dotBtn = findViewById(R.id.dotButton);
        Button powBtn = findViewById(R.id.potButton);
        Button sqrtBtn = findViewById(R.id.rootButton);
        Button offBtn = findViewById(R.id.offButton);
        Button modBtn = findViewById(R.id.modButton);
        Button plusMinusBtn = findViewById(R.id.plusMinusButton);
        Button sinBtn = findViewById(R.id.sinBtn);
        Button cosBtn = findViewById(R.id.cosBtn);
        Button tanBtn = findViewById(R.id.tanBtn);
        Button oneDivideXBtn = findViewById(R.id.oneDivideXBtn);
        Button piSymbolBtn = findViewById(R.id.piSymbolBtn);
        Button delBtn = findViewById(R.id.delBtn);
        operationResultTv = findViewById(R.id.ResultTextView);

        setResultText(0);
        if(savedInstanceState != null) {
            op1 = savedInstanceState.getDouble(OP1_KEY);
            op2 = savedInstanceState.getDouble(OP2_KEY);
            displayNumber = savedInstanceState.getString(DISPLAY_NUM_KEY);
            currOperation = (Operation)savedInstanceState.get(CURR_OP_KEY);
            String currentDisplay = !displayNumber.isEmpty() ? displayNumber : op1 != 0 ? String.valueOf(op1) : "0";
            setResultText((Double.parseDouble(currentDisplay)));
        }

        int screenOrientation = this.getResources().getConfiguration().orientation;
        if (screenOrientation == Configuration.ORIENTATION_PORTRAIT){
            ceBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clearPartially();
                }
            });
            offBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    quitApp();
                }
            });
        } else if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            sinBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    performAlternativeOperation(AlternativeOperation.Sin);
                }
            });
            cosBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    performAlternativeOperation(AlternativeOperation.Cos);
                }
            });
            tanBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    performAlternativeOperation(AlternativeOperation.Tan);
                }
            });
            oneDivideXBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    performAlternativeOperation(AlternativeOperation.OneDivideX);
                }
            });
            piSymbolBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setPiNumber();
                }
            });
            delBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteNumber();
                }
            });
        }

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
        dotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDot();
            }
        });
        powBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAlternativeOperation(AlternativeOperation.Pow);
            }
        });
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAlternativeOperation(AlternativeOperation.Sqrt);
            }
        });
        modBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAlternativeOperation(AlternativeOperation.Mod);
            }
        });
        plusMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alternateSign();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putDouble(OP1_KEY, op1);
        outState.putDouble(OP2_KEY, op1);
        outState.putString(DISPLAY_NUM_KEY, displayNumber);
        outState.putSerializable(CURR_OP_KEY, currOperation);

        super.onSaveInstanceState(outState);
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

    private void clearPartially() {
        displayNumber = "";
        setResultText(0);
    }

    private void addDot() {
        if (!displayNumber.isEmpty() && !displayNumber.contains(DOT_CHARACTER)) {
            setNumberValue(DOT_CHARACTER);
        }
    }

    private void deleteNumber() {
        if (!displayNumber.isEmpty() && displayNumber.length() > 0) {
            displayNumber = displayNumber.substring(0, displayNumber.length() - 1);
            setResultText((Double.parseDouble(displayNumber.isEmpty() ? "0" : displayNumber)));
        }
    }

    private void setPiNumber() {
        displayNumber = String.valueOf(PI_VALUE);
        setResultText(PI_VALUE);
    }

    private void alternateSign() {
        if (!displayNumber.isEmpty() || op1 != 0.0) {
            if (displayNumber.isEmpty()) {
                displayNumber = String.valueOf(op1);
            }
            if(displayNumber.startsWith(MINUS_CHARACTER)) {
                displayNumber = displayNumber.replace(MINUS_CHARACTER, "");
            } else {
                displayNumber = MINUS_CHARACTER + displayNumber;
            }
            setResultText(Double.parseDouble(displayNumber));
        }
    }

    private void performAlternativeOperation(AlternativeOperation alternativeOp) {
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
            case Mod:
                altOpResult = op1 / 100;
                break;
            case Sin:
                altOpResult = Math.sin(Math.toRadians(op1));
                break;
            case Cos:
                altOpResult = Math.cos(Math.toRadians(op1));
                break;
            case Tan:
                altOpResult = Math.tan(Math.toRadians(op1));
                break;
            case OneDivideX:
                altOpResult = 1 / op1;
                break;
        }
        setResultText(altOpResult);
        op1 = altOpResult;
        currOperation = null;
        displayNumber = "";
    }

    private void quitApp() {
        MainActivity.this.finish();
        System.exit(0);
    }
}