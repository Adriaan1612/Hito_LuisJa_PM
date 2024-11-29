package com.example.hito_luisja;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score = getIntent().getIntExtra("score", 0);
        String playerName = getIntent().getStringExtra("playerName");
        TextView textViewResult = findViewById(R.id.text_view_result);
        textViewResult.setText("Player: " + playerName + "\nYour Score: " + score);

        Button buttonBackToMain = findViewById(R.id.button_back_to_main);
        buttonBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}