package com.example.tennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Win extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        final Button button = findViewById(R.id.winRestart);
        button.setOnClickListener(this);
    }

    public void onClick(View view){
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }
}
