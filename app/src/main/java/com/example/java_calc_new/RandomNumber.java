package com.example.java_calc_new;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.Random;

public class RandomNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);

        setUpButton();
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



    public void setUpButton() {
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = findViewById(R.id.Input);
                EditText second = findViewById(R.id.editText);
                TextView result = findViewById(R.id.output2);

                Random rand = new Random();

                int firstnum = Integer.parseInt(text.getText().toString());
                System.out.println(firstnum);
                int secondnum = Integer.parseInt(second.getText().toString());
                System.out.println(secondnum);
                int num = rand.nextInt(secondnum+1) + firstnum;
                System.out.println(num);

                result.setText(Integer.toString(num));
            }
        });
    }
}
