package com.example.tennis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * The game activity that shows the game
 *
 * @author Alan Liang
 * @version 0.1 10/8/2019
 */
public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
