package com.example.tennis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * The page shows win message
 *
 * @author Alan Liang
 * @version 0.1 10/8/2019
 */
public class Win extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        final Button button = findViewById(R.id.winPlayAgain);
        button.setOnClickListener(this);
    }

    /**
     * It handles play again button click to open the game page
     * @param view
     */
    public void onClick(View view){
        Intent i = new Intent(this, Game.class);
        startActivity(i);
    }

    /**
     * Initialize the options menu on the top
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    /**
     * When settings menu is selected, it opens settings activity page
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_setting:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Uses Intent to open settings activity
     */
    private void showSettings(){
        Intent s = new Intent(this, Settings.class);
        startActivity(s);
    }
}
