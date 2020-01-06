package com.example.java_calc_new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Converter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_converter);
        Spinner spinInput1 = findViewById(R.id.spinner);
        Spinner spinInput2 = findViewById(R.id.spinner2);
        String[] array = new String[] {"Binary", "Decimal", "Hexadecimal", "Octal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinInput1.setAdapter(adapter);
        spinInput2.setAdapter(adapter);
        convertButton();
    }

    /**
     * Convertbutton --
     */
    private void convertButton() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText input1 = findViewById(R.id.Input);
                Spinner spinInput1 = findViewById(R.id.spinner);
                Spinner spinInput2 = findViewById(R.id.spinner2);
                TextView output = findViewById(R.id.Output);


                switch(spinInput1.getSelectedItem().toString()) {
                    case "Binary":
                        int binary = Integer.parseInt(input1.getText().toString(),2);
                        switch(spinInput2.getSelectedItem().toString()) {

                            case "Binary":
                                output.setText(input1.getText());
                                break;
                            case "Decimal":
                                output.setText(Integer.toString(binary));
                                break;
                            case "Hexadecimal":
                                output.setText(Integer.toHexString(binary));
                                break;
                            case "Octal":
                                output.setText(Integer.toOctalString(binary));
                                break;
                        }
                        break;
                    case "Decimal":
                        int val = Integer.parseInt(input1.getText().toString());
                        switch(spinInput2.getSelectedItem().toString()) {

                            case "Binary":
                                output.setText(Integer.toBinaryString(val));
                                break;
                            case "Decimal":
                                output.setText(Integer.toString(val));
                                break;
                            case "Hexadecimal":
                                output.setText(Integer.toHexString(val));
                                break;
                            case "Octal":
                                output.setText(Integer.toOctalString(val));
                                break;
                        }
                        break;
                    case "Hexadecimal":
                        int hex = Integer.parseInt(input1.getText().toString(), 16);
                        switch(spinInput2.getSelectedItem().toString()) {

                            case "Binary":
                                output.setText(Integer.toBinaryString(hex));
                                break;
                            case "Decimal":

                                output.setText(Integer.toString(hex));
                                break;
                            case "Hexadecimal":
                                output.setText(input1.getText());
                                break;
                            case "Octal":
                                output.setText(Integer.toOctalString(hex));
                                break;
                        }
                            break;
                    case "Octal":
                        int oct = Integer.parseInt(input1.getText().toString(), 8);
                        switch(spinInput2.getSelectedItem().toString()) {

                            case "Binary":
                                output.setText(Integer.toBinaryString(oct));
                                break;
                            case "Decimal":
                                output.setText(Integer.toString(oct));
                                break;
                            case "Hexadecimal":
                                output.setText(Integer.toHexString(oct));
                                break;
                            case "Octal":
                                output.setText(input1.getText());
                                break;
                            }
                            break;
                }
            }
        });
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
}
