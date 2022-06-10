package com.example.connect_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    int iscounter = 0;
    int [] gameState ={2,2,2,2,2,2,2,2,2};
    int[][] winningPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,8,6},{0,4,8},{2,4,6}};
    String winner;
    boolean gameActive = true;

     public void dropin(View view) {
         ImageView counter = (ImageView) view;
         int counterTageed = Integer.parseInt(counter.getTag().toString());

         if (gameState[counterTageed] == 2 && gameActive) {
             gameState[counterTageed] = iscounter;
             counter.setTranslationY(-1500);

             if (iscounter == 0) {
                 iscounter = 1;
                 counter.setImageResource(R.drawable.yellow);

             }
             else
                 {
                 iscounter = 0;
                 counter.setImageResource(R.drawable.red);
             }
             counter.animate().translationYBy(1500).setDuration(200);

             for (int[] winningPosition : winningPosition) {
                 if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2)
                 {

                     gameActive = false;
                     winner = " ";

                     if (iscounter == 1) {
                         winner = "Yellow";

                     }
                     else
                         {
                         winner = "Red";
                     }

                     Button playagain = (Button)findViewById(R.id.button);
                     TextView text = (TextView)findViewById(R.id.text_View);
                     text.setText(winner + "Has Won");

                     playagain.setVisibility(View.VISIBLE);

                     text.setVisibility(View.VISIBLE);

                 }

             }

         }
         else {
             gameActive = false;
             Button playagain = (Button)findViewById(R.id.button);
             TextView text = (TextView)findViewById(R.id.text_View);
             text.setText("The game is Tied");

             playagain.setVisibility(View.VISIBLE);

             text.setVisibility(View.VISIBLE);

         }
     }

     public void play(View view)
     {
         Button playagain = (Button) findViewById(R.id.button);
         TextView text= (TextView)findViewById(R.id.text_View);
         playagain.setVisibility(View.INVISIBLE);
         text.setVisibility(View.INVISIBLE);

         GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

         for(int i = 0; i < gridLayout.getChildCount(); i++)
         {
             ImageView counter = (ImageView) gridLayout.getChildAt(i);
             counter.setImageDrawable(null);
         }

         for(int  i=0; i<gameState.length; i++)
         {

             gameState[i] = 2;
         }
         iscounter = 0;
         gameActive = true;

     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}