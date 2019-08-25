package com.example.rockpaperscissor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_scissors, b_paper;
    ImageView youChose, theyChose;
    TextView score;
    int yourScore = 0;
    int theirScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_rock = (Button) findViewById(R.id.button7);
        b_scissors = (Button) findViewById(R.id.button8);
        b_paper = (Button) findViewById(R.id.button9);

        youChose = (ImageView) findViewById(R.id.imageView5);
        theyChose = (ImageView) findViewById(R.id.imageView6);

        score = (TextView) findViewById(R.id.textView3);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                youChose.setImageResource(R.drawable.rock);
                String result = cpuTurn("Rock");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                score.setText("Score: Humans "+yourScore+" - "+theirScore+" Computers");
                score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        });

        b_scissors.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                youChose.setImageResource(R.drawable.scissors);
                String result = cpuTurn("Scissors");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                score.setText("Score: Humans "+yourScore+" - "+theirScore+" Computers");
                score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {
                youChose.setImageResource(R.drawable.paper);
                String result = cpuTurn("Paper");
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                score.setText("Score: Humans "+yourScore+" - "+theirScore+" Computers");
                score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        });

    }

    public String cpuTurn (String thing){
        Random r = new Random();
        String cpuChoice = "";
        int cpuChoiceInd = r.nextInt(3);

        if (cpuChoiceInd == 0){
            cpuChoice = "Rock";
            theyChose.setImageResource(R.drawable.rock);
        }
        else if (cpuChoiceInd == 1){
            cpuChoice = "Scissors";
            theyChose.setImageResource(R.drawable.scissors);
        }
        else if (cpuChoiceInd == 2){
            cpuChoice = "Paper";
            theyChose.setImageResource(R.drawable.paper);
        }

        if (cpuChoice.equals(thing)){
            return "DRAW!";
        }
        else if (cpuChoice.equals("Rock") && thing.equals("Scissors")){
            theirScore++;
            return "COMPUTER WINS!";
        }
        else if (cpuChoice.equals("Rock") && thing.equals("Paper")){
            yourScore++;
            return "HUMAN WINS!";
        }
        else if (cpuChoice.equals("Paper") && thing.equals("Scissors")){
            yourScore++;
            return "HUMAN WINS!";
        }
        else if (cpuChoice.equals("Paper") && thing.equals("Rock")){
            theirScore++;
            return "COMPUTER WINS!";
        }
        else if (cpuChoice.equals("Scissors") && thing.equals("Paper")){
            theirScore++;
            return "COMPUTER WINS!";
        }
        else if (cpuChoice.equals("Scissors") && thing.equals("Rock")){
            yourScore++;
            return "HUMAN WINS!";
        }
        return "whoa what now";
    }
}
