package com.example.java_calc_new;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.Random;

public class SpinSpinner extends AppCompatActivity {

    private int count1 = 0;
    private int count2 = 0;
    private int count3 = 0;
    private int count4 = 0;
    private int count5 = 0;
    private int count6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin_spinner);
        setUpButton();


        com.jjoe64.graphview.GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.removeAllSeries();

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, count1),
                new DataPoint(1, count2), new DataPoint(2,count3),
                new DataPoint(3, count4), new DataPoint(4, count5), new DataPoint(5, count6),
                new DataPoint(6, 0)
        });
        graph.addSeries(series);


// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                int color = Color.rgb(200, 0, 0);
                if(data.getX() == 0) {
                    color = Color.rgb(255, 0, 0);
                }
                else if(data.getX() == 1) {
                    color = Color.rgb(179,0,255);
                }
                else if(data.getX() == 2) {
                    color = Color.rgb(0,0,255);
                }
                else if(data.getX() == 3) {
                    color = Color.rgb(0,183,30);
                }
                else if(data.getX() == 4) {
                    color = Color.rgb(231,255,0);
                }
                else {
                    color = Color.rgb(255, 162, 0);
                }
                return color;
            }
        });

        series.setSpacing(50);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);
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
        Button button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView text = findViewById(R.id.textView3);
                ImageView image = findViewById(R.id.imageView);



                Random rand = new Random();

                int num = rand.nextInt(6);
                if(num==0) {
                    count1++;
                    text.setText("Red");
                    Drawable res = getResources().getDrawable(R.drawable.red);
                    image.setImageDrawable(res);
                }
                else if(num==1) {
                    count2++;
                    text.setText("Purple");
                    Drawable res = getResources().getDrawable(R.drawable.purple);
                    image.setImageDrawable(res);
                }
                else if(num==2) {
                    count3++;
                    text.setText("Blue");
                    Drawable res = getResources().getDrawable(R.drawable.blue);
                    image.setImageDrawable(res);
                }
                else if(num == 3) {
                    count4++;
                    text.setText("Green");
                    Drawable res = getResources().getDrawable(R.drawable.green);
                    image.setImageDrawable(res);
                }
                else if(num ==4) {
                    count5++;
                    text.setText("Yellow");
                    Drawable res = getResources().getDrawable(R.drawable.yellow);
                    image.setImageDrawable(res);
                }
                else {
                    count6++;
                    text.setText("Orange");
                    Drawable res = getResources().getDrawable(R.drawable.orange);
                    image.setImageDrawable(res);
                }

                com.jjoe64.graphview.GraphView graph = (GraphView) findViewById(R.id.graph);
                graph.removeAllSeries();

                BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, count1),
                        new DataPoint(1, count2), new DataPoint(2,count3),
                        new DataPoint(3, count4), new DataPoint(4, count5), new DataPoint(5, count6),
                        new DataPoint(6, 0)
                });
                graph.addSeries(series);


// styling
                series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                    @Override
                    public int get(DataPoint data) {
                        int color = Color.rgb(200, 0, 0);
                        if(data.getX() == 0) {
                            color = Color.rgb(255, 0, 0);
                        }
                        else if(data.getX() == 1) {
                            color = Color.rgb(179,0,255);
                        }
                        else if(data.getX() == 2) {
                            color = Color.rgb(0,0,255);
                        }
                        else if(data.getX() == 3) {
                            color = Color.rgb(0,183,30);
                        }
                        else if(data.getX() == 4) {
                            color = Color.rgb(231,255,0);
                        }
                        else {
                            color = Color.rgb(255, 162, 0);
                        }
                        return color;
                    }
                });

                series.setSpacing(50);

// draw values on top
                series.setDrawValuesOnTop(true);
                series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);



            }
        });
    }

}
