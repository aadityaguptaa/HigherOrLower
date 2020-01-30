package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int guessingNumber = guessNumber();

    public int guessNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(21);
        while (randomNumber == 0){
            randomNumber = random.nextInt(21);
        }
        return randomNumber;
    }
    public void onClick(View view){

        EditText number = (EditText)findViewById(R.id.number);

        int guess = Integer.parseInt(number.getText().toString());

        checkInput(guess);
    }

    public void checkInput(int guess){

        if(guess < guessingNumber){
            Toast.makeText(this, "Lower", Toast.LENGTH_SHORT).show();
        }
        else if (guess > guessingNumber){
            Toast.makeText(this, "Higher", Toast.LENGTH_SHORT).show();
        }
        else if (guess == guessingNumber){
            Toast.makeText(this, "Congratulations! You guessed the right number :)", Toast.LENGTH_SHORT).show();

            guessingNumber = guessNumber();
        }
    }
}
