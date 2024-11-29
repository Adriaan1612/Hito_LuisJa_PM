package com.example.hito_luisja;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ScoreManager
        ScoreManager.init(this);

        Button buttonPlay = findViewById(R.id.button_play);
        Button buttonViewScores = findViewById(R.id.button_view_scores);
        Button buttonContactUs = findViewById(R.id.button_contact_us);

        buttonPlay.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EnterNameActivity.class);
            startActivity(intent);
        });

        buttonViewScores.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScoresActivity.class);
            startActivity(intent);
        });

        buttonContactUs.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContactUsActivity.class);
            startActivity(intent);
        });
    }
}