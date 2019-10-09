package com.example.tennis;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * The settings page
 *
 * @author Alan Liang
 * @version 0.1 10/8/2019
 */
public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /**
     * Init the activity. A back button is added to action bar on the top.
     * The spinner is initialized with custom item array, item list and dropdown item list.
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Spinner spinner =  findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bgcolors_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    /**
     * Handles options item selection event
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles spinner selection event and shows background color based on selection.
     * @param parent
     * @param view
     * @param pos
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        Spinner spinner =  findViewById(R.id.spinner);

        setViewBgColor(spinner.getSelectedItem().toString());
    }

    /**
     * Set activity background color based on the color name passed
     * @param color the name of the color
     */
    void setViewBgColor(String color) {
        View rootView = findViewById(R.id.settings_layout);
        if (color.equals("White")) {
            rootView.setBackgroundColor(Color.WHITE);
        }
        else if (color.equals("Gray")) {
            rootView.setBackgroundColor(Color.GRAY);
        } else if (color.equals("Blue")) {
            rootView.setBackgroundColor(Color.BLUE);
        }
        else if (color.equals("Yellow")) {
            rootView.setBackgroundColor(Color.YELLOW);
        }
    }

    /**
     * Handles event when nothing is selected in spinner
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
