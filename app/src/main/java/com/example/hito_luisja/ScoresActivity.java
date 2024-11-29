package com.example.hito_luisja;

import android.os.Bundle;
import android.util.Pair;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScoresActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        TableLayout tableLayout = findViewById(R.id.table_layout_scores);

        for (Pair<String, Integer> score : ScoreManager.getScores()) {
            TableRow row = new TableRow(this);
            TextView playerNameView = new TextView(this);
            playerNameView.setText(score.first);
            playerNameView.setPadding(8, 8, 8, 8);
            playerNameView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

            TextView scoreView = new TextView(this);
            scoreView.setText(String.valueOf(score.second));
            scoreView.setPadding(8, 8, 8, 8);
            scoreView.setGravity(android.view.Gravity.END);
            scoreView.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

            row.addView(playerNameView);
            row.addView(scoreView);
            tableLayout.addView(row);
        }
    }
}