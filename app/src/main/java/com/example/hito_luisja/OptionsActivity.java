package com.example.hito_luisja;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        String username = getIntent().getStringExtra("username");

        Button buttonPlay = findViewById(R.id.button_play);
        Button buttonViewScores = findViewById(R.id.button_view_scores);

        buttonPlay.setOnClickListener(v -> {
            Intent intent = new Intent(OptionsActivity.this, GameActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        buttonViewScores.setOnClickListener(v -> {
            Intent intent = new Intent(OptionsActivity.this, ScoresActivity.class);
            startActivity(intent);
        });
    }
}