package com.example.java_calc_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scientific_Calc extends AppCompatActivity {
    private double firstNum = 0; //first number
    private String state = "";

    /**
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific__calc);


        percentButton();
        rootButton();
        squareButton();
        reciprocalButton();
        setUpButton(R.id.Seven, "7");
        setUpButton(R.id.Eight,"8");
        setUpButton(R.id.Nine, "9");
        operatorsButton("multiply",R.id.Multiply);
        setUpButton(R.id.Four,"4");
        setUpButton(R.id.Five,"5");
        setUpButton(R.id.Six,"6");
        operatorsButton("divide",R.id.Divide);
        setUpButton(R.id.One,"1");
        setUpButton(R.id.Two,"2");
        setUpButton(R.id.Three,"3");
        operatorsButton("add",R.id.Add);
        decimalButton();
        setUpButton(R.id.Zero,"0");
        signButton();
        operatorsButton("subtract", R.id.Minus);
        clearButton();
        deleteButton();
        piButton();
        modButton();
        equalButton();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.converter:
                startActivity(new Intent(this, Converter.class));
                return true;

            case R.id.home:
                startActivity(new Intent(this, CalculatorActivity.class));
                return true;

            case R.id.coin:
                startActivity(new Intent(this, CoinToss.class));
                return true;

            case R.id.spinnerspin:
                startActivity(new Intent(this, SpinSpinner.class));
                return true;

            case R.id.dice:
                startActivity(new Intent(this, DiceRoll.class));
                return true;

            case R.id.randomnumber:
                startActivity(new Intent(this, RandomNumber.class));
                return true;

            case R.id.graphfunction:
                startActivity(new Intent(this,Graph.class));

            case R.id.scientific:
                startActivity(new Intent(this,Scientific_Calc.class));

            case R.id.camera:
                startActivity(new Intent(this,Camera_Math.class));

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void setUpButton(int name, final String value) {
        Button button = findViewById(name);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                if(text.getText().equals("0")) {
                    text.setText(value);
                }
                else {
                    text.setText(text.getText() + value);
                }
            }
        });
    }

    private void clearButton() {
        Button button = findViewById(R.id.Clear);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                text.setText("0");
                firstNum = 0;
            }
        });
    }
    private void signButton() {
        Button button = findViewById(R.id.Sign);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);

                if(text.getText().equals("0")) {
                    text.setText("0");
                }
                else {
                    double number = Double.parseDouble(text.getText().toString());
                    number *= -1;
                    text.setText(Double.toString(number));
                }

            }
        });
    }

    private void operatorsButton(final String value, int id) {
        Button button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                state = value;

                firstNum = Double.parseDouble(text.getText().toString());
                text.setText("0");
            }
        });
    }

    private void percentButton() {
        Button button = findViewById(R.id.Percent);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);

                firstNum = Double.parseDouble(text.getText().toString())/100;

                text.setText(Double.toString(firstNum));
            }
        });
    }

    private void rootButton() {
        Button button = findViewById(R.id.Root);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);

                firstNum = Math.sqrt(Double.parseDouble(text.getText().toString()));
                text.setText(Double.toString(firstNum));
            }
        });
    }

    private void squareButton() {
        Button button = findViewById(R.id.Square);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);

                firstNum = Math.pow(Double.parseDouble(text.getText().toString()),2.0);
                text.setText(Double.toString(firstNum));
            }
        });
    }

    private void reciprocalButton() {
        Button button = findViewById(R.id.Reciprocal);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);

                firstNum = 1/Double.parseDouble(text.getText().toString());
                text.setText(Double.toString(firstNum));
            }
        });
    }

    private void piButton() {
        Button button = findViewById(R.id.Pi);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                firstNum = Math.PI;
                text.setText(Double.toString(firstNum));
            }
        });
    }

    private void decimalButton() {
        Button button = findViewById(R.id.Decimal);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                String number = text.getText().toString().concat(".");
                text.setText(number);
                firstNum = Double.parseDouble(number);
            }
        });
    }

    private void deleteButton() {
        Button button = findViewById(R.id.Back);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                if (text.getText().length() == 1) {
                    firstNum = 0;
                    text.setText("0");
                } else if (text.getText().length() > 1) {
                    String number = text.getText().toString().substring(0, text.getText().toString().length() -1);
                    int value = (int) Double.parseDouble(number);
                    firstNum = value;
                    text.setText(Integer.toString(value));
                } else {
                    text.setText("0");
                }
            }
        });
    }

    private void modButton() {
        Button button = findViewById(R.id.Mod);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                state = "mod";

                firstNum = Double.parseDouble(text.getText().toString());
                text.setText("");
            }
        });
    }
    private void equalButton() {
        Button button = findViewById(R.id.Equals);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView4);
                double finalAnswer;
                switch(state) {
                    case "add":
                        finalAnswer = firstNum
                                + Double.parseDouble(text.getText().toString());
                        text.setText(Double.toString(finalAnswer));
                        firstNum = finalAnswer;
                        break;
                    case "subtract":
                        finalAnswer = firstNum
                                - Double.parseDouble(text.getText().toString());
                        text.setText(Double.toString(finalAnswer));
                        firstNum = finalAnswer;
                        break;
                    case "multiply":
                        finalAnswer = firstNum
                                * Double.parseDouble(text.getText().toString());
                        text.setText(Double.toString(finalAnswer));
                        firstNum = finalAnswer;
                        break;
                    case "divide":
                        if(text.getText().equals("0")) {
                            text.setText("Undefined");
                        }
                        else {
                            finalAnswer = firstNum
                                    / Double.parseDouble(text.getText().toString());
                            text.setText(Double.toString(finalAnswer));
                            firstNum = finalAnswer;
                        }
                        break;
                    case "mod":
                        finalAnswer = firstNum
                                % Double.parseDouble(text.getText().toString());
                        text.setText(Double.toString(finalAnswer));
                        firstNum = finalAnswer;
                        break;
                    case "":
                        firstNum = 0;
                        text.setText("0");
                        break;
                }
                state = "";
            }
        });
    }


}
