package com.example.tennis;

import androidx.appcompat.app.AppCompatActivity;

alanliang
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gameover extends AppCompatActivity implements View.OnClickListener{

import android.os.Bundle;

public class Gameover extends AppCompatActivity {
master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
alanliang
        final Button button = findViewById(R.id.loseRestart);
        button.setOnClickListener(this);
    }

    public void onClick(View view){
        Intent i = new Intent(this, Game.class);
        startActivity(i);

master
    }
}
