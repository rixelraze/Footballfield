package com.example.footballfield;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView GermanyScore, RussiaScore;
    Button GermanyClick, RussiaClick, DownClick;
    int ScoreGerm = 0;
    int ScoreRuss = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GermanyScore = (TextView) findViewById(R.id.RussiaScore);

        RussiaScore = (TextView) findViewById(R.id.GermanyScore);

        GermanyClick = (Button) findViewById(R.id.buttonGermany);

        RussiaClick = (Button) findViewById(R.id.buttonRussia);

        DownClick = (Button) findViewById(R.id.buttonDown);

        GermanyClick();

        RussianClick();

        DownClick();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counterGerman", ScoreGerm);
        outState.putInt("counterRuss", ScoreRuss);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ScoreGerm = savedInstanceState.getInt("counterGerman", 0);
        GermanyScore.setText(ScoreGerm + "");
        ScoreRuss = savedInstanceState.getInt("counterRuss", 0);
        RussiaScore.setText(ScoreRuss + "");
    }

    void DownClick() {
        DownClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreGerm = 0;
                ScoreRuss = 0;
                GermanyScore.setText(ScoreGerm + "");
                RussiaScore.setText(ScoreRuss + "");
            }
        });
    }

    void GermanyClick() {
        GermanyClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreGerm++;
                GermanyScore.setText(ScoreGerm + "");

            }
        });

    }

    void RussianClick() {
        RussiaClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScoreRuss++;
                RussiaScore.setText(ScoreRuss + "");

            }
        });
    }


}