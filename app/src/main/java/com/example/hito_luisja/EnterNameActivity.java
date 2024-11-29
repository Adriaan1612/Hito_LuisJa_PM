package com.example.hito_luisja;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hito_luisja.R;
import com.example.hito_luisja.GameActivity; // Ensure this import is present

public class EnterNameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        EditText editTextName = findViewById(R.id.edit_text_name);
        Button buttonStartGame = findViewById(R.id.button_start_game);

        buttonStartGame.setOnClickListener(v -> {
            String playerName = editTextName.getText().toString();
            if (!playerName.isEmpty()) {
                Intent intent = new Intent(EnterNameActivity.this, GameActivity.class);
                intent.putExtra("playerName", playerName);
                startActivity(intent);
            }
        });
    }
}