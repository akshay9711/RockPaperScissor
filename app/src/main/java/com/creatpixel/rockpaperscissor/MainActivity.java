package com.creatpixel.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.creatpixel.rockpaperscissor.MSG";
    public static final String MSG2 = "com.creatpixel.rockpaperscissor.MSG2";

    int b = 1;
    boolean bBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout backround = findViewById(R.id.backround);
        new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                //How many times run under 5000 means 5 seconds
            }

            @Override
            public void onFinish() {
                //When we come at last second of 5 means 4th
            }
        };
    }

    public void startButton(View view){
        //Getting Player Value
        Button button = (Button) view;
        int buttonTag = Integer.parseInt(button.getTag().toString());
        //Getting Opponent Value
        Random random = new Random();
        int opponentValue = random.nextInt(3);
        //0 = Rock
        //1 = Paper
        //2 = Scissor
        String resultString = "Umm There is some problem";

        //Draw Conditions
             if(buttonTag == 0 && opponentValue == 0){
            //Same Same Rock
            resultString = "Draw both choice is Rock";
        }
        else if(buttonTag == 1 && opponentValue == 1){
            //Same Same Paper
            resultString = "Draw both choice is Paper";
        }
        else if(buttonTag == 2 && opponentValue == 2){
            //Same Same Scissor
            resultString = "Draw both choice is Scissor";
        }
        //Rock
        else if(buttonTag == 0 && opponentValue == 1){
            resultString = "GameOver, Opponent choice is Paper";
        }
        else if(buttonTag == 0 && opponentValue == 2){
            resultString = "YouWin!!, Opponent choice is Scissor";
        }
        //Paper
        else if(buttonTag == 1 && opponentValue == 0){
            resultString = "YouWin!!, Opponent choice is Rock";
        }
        else if(buttonTag == 1 && opponentValue == 2){
            resultString = "GameOver, Opponent choice is Scissor";
        }
        //Scissor
        else if(buttonTag == 2 && opponentValue == 0){
            resultString = "GameOver, Opponent choice is Rock";
        }
        else if(buttonTag == 2 && opponentValue == 1){
            resultString = "YouWin!!, Opponent choice is Paper";
        }

        //This is result function
        getResult(resultString, buttonTag);
    }

    public void getResult(String resultStr, int tag){
        String tagStr = Integer.toString(tag);

        Intent intent = new Intent(this, resultActivity.class);

        intent.putExtra(MSG, resultStr);
        intent.putExtra(MSG2, tagStr);

        startActivity(intent);
        //Toast.makeText(this, "Its works", Toast.LENGTH_SHORT).show();
    }
}
