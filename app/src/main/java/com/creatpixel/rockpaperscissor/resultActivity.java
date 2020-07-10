package com.creatpixel.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class resultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView = (TextView) findViewById(R.id.resultText);
        TextView youText = findViewById(R.id.youText);
        TextView opponentText = findViewById(R.id.opponentText);
        ImageView playerHand = (ImageView) findViewById(R.id.playerHand);
        ImageView opponentHand = (ImageView) findViewById(R.id.opponentHand);

        Intent intent = getIntent();
        intent.getExtras();

        String resultString = intent.getStringExtra(MainActivity.MSG);
        textView.setText(resultString);
        String tag = intent.getStringExtra(MainActivity.MSG2);

        //setColours Conditions
             if(resultString.contains("GameOver")){
            textView.setTextColor(Color.RED);
            opponentText.setTextColor(Color.GREEN);
            youText.setTextColor(Color.RED);
            opponentHand.animate().scaleX(2);
            opponentHand.animate().scaleY(2);
        }
        else if(resultString.contains("Draw")){
            textView.setTextColor(Color.YELLOW);
                 opponentText.setTextColor(Color.BLACK);
                 youText.setTextColor(Color.BLACK);
        }
        else{
                 opponentText.setTextColor(Color.RED);
                 youText.setTextColor(Color.GREEN);
                 playerHand.animate().scaleX(2);
                 playerHand.animate().scaleY(2);
             }
        //Draw
             if(tag.equals("0") && resultString.contains("Draw")){
            playerHand.setImageDrawable(getDrawable(R.drawable.rock));
            opponentHand.setImageDrawable(getDrawable(R.drawable.rock));
        }
        else if(tag.equals("1") && resultString.contains("Draw")){
            playerHand.setImageDrawable(getDrawable(R.drawable.paper));
            opponentHand.setImageDrawable(getDrawable(R.drawable.paper));
        }
        else if(tag.equals("2") && resultString.contains("Draw")){
            playerHand.setImageDrawable(getDrawable(R.drawable.scissor));
            opponentHand.setImageDrawable(getDrawable(R.drawable.scissor));
        }
        //Rock
        else if(tag.equals("0") && resultString.contains("GameOver")){
            playerHand.setImageDrawable(getDrawable(R.drawable.rock));
            opponentHand.setImageDrawable(getDrawable(R.drawable.paper));
        }
        else if(tag.equals("0") && resultString.contains("YouWin")){
            playerHand.setImageDrawable(getDrawable(R.drawable.rock));
            opponentHand.setImageDrawable(getDrawable(R.drawable.scissor));
        }
        //Paper
        else if(tag.equals("1") && resultString.contains("YouWin")){
            playerHand.setImageDrawable(getDrawable(R.drawable.paper));
            opponentHand.setImageDrawable(getDrawable(R.drawable.rock));
        }
        else if(tag.equals("1") && resultString.contains("GameOver")){
            playerHand.setImageDrawable(getDrawable(R.drawable.paper));
            opponentHand.setImageDrawable(getDrawable(R.drawable.scissor));
        }
        //Scissor
        else if(tag.equals("2") && resultString.contains("GameOver")){
            playerHand.setImageDrawable(getDrawable(R.drawable.scissor));
            opponentHand.setImageDrawable(getDrawable(R.drawable.rock));
        }
        else if(tag.equals("2") && resultString.contains("YouWin")){
            playerHand.setImageDrawable(getDrawable(R.drawable.scissor));
            opponentHand.setImageDrawable(getDrawable(R.drawable.paper));
        }

        //Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
    }
}
