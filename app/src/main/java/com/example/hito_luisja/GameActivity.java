package com.example.hito_luisja;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hito_luisja.R;

public class GameActivity extends AppCompatActivity {
    private int score = 0;
    private int level = 1;
    private CountDownTimer countDownTimer;
    private final long gameTimeInMillis = 30000; // 30 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        String playerName = getIntent().getStringExtra("playerName");
        TextView textViewPlayerName = findViewById(R.id.text_view_player_name);
        TextView textViewScore = findViewById(R.id.text_view_score);
        TextView textViewTimer = findViewById(R.id.text_view_timer);
        TextView textViewLevel = findViewById(R.id.text_view_level);
        ImageView imageClick = findViewById(R.id.image_click);
        Button buttonEndGame = findViewById(R.id.button_end_game);

        textViewPlayerName.setText("Player: " + playerName);
        textViewLevel.setText("Level: " + level);

        imageClick.setOnClickListener(v -> {
            score += level;
            textViewScore.setText("Score: " + score);
            imageClick.startAnimation(AnimationUtils.loadAnimation(this, R.anim.click_animation));
            checkLevelUp();
        });

        buttonEndGame.setOnClickListener(v -> endGame(playerName));

        startTimer();
    }

    private void startTimer() {
        TextView textViewTimer = findViewById(R.id.text_view_timer);
        countDownTimer = new CountDownTimer(gameTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText("Time: " + millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                endGame(getIntent().getStringExtra("playerName"));
            }
        }.start();
    }

    private void checkLevelUp() {
        if (score >= level * 100) {
            level++;
            TextView textViewLevel = findViewById(R.id.text_view_level);
            textViewLevel.setText("Level: " + level);
        }
    }

    private void endGame(String playerName) {
        countDownTimer.cancel();
        if (playerName != null) {
            ScoreManager.addScore(playerName, score);
        }
        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("playerName", playerName);
        startActivity(intent);
        finish();
    }
}