package com.example.java_calc_new;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class Camera_Math extends AppCompatActivity {
    Button button;
    ImageView img;
    private static final int CAM_REQUEST=1313;
    Bitmap bitmap;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAM_REQUEST) {
            bitmap = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(bitmap);
            GifImageView gif2 = findViewById(R.id.gif);
            gif2.setVisibility(View.VISIBLE);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(Camera_Math.this, Answer.class));
                }
            },2000);

        }
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

    public Bitmap getImage() {
        return bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera__math);

        button = findViewById(R.id.buttonCamera);
        img = findViewById(R.id.cameraphoto);
        button.setOnClickListener(new btnTakePhotoClicker());
    }

    class btnTakePhotoClicker implements  Button.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAM_REQUEST);
        }
    }
}
