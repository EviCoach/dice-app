package com.columnhack.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                R.drawable.dice4, R.drawable.dice5, R.drawable.dice6 };

        Button btnRoll = findViewById(R.id.roll_dice_btn);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.dice_sound);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Dice App", "btnRoll is tapped now!");
                Random random = new Random();
                int rnd1 = random.nextInt(6);
                int rnd2 = random.nextInt(6);

                Log.i("Dice App",  "Random generated numbers: " + rnd1 + " and " + rnd2);

                diceImage1.setImageResource(diceImages[rnd1]);
                diceImage2.setImageResource(diceImages[rnd2]);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImage2);

                mediaPlayer.start();


            }
        });

    }
}
