package com.example.hito_luisja;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreManager {
    private static final String PREFS_NAME = "score_prefs";
    private static final String SCORES_KEY = "scores";
    private static SharedPreferences sharedPreferences;

    private static final List<Pair<String, Integer>> scores = new ArrayList<>();

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        loadScores();
    }

    public static void addScore(String playerName, int score) {
        scores.add(new Pair<>(playerName, score));
        Collections.sort(scores, (a, b) -> b.second - a.second);
        saveScores();
    }

    private static void saveScores() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        StringBuilder scoresString = new StringBuilder();
        for (Pair<String, Integer> score : scores) {
            scoresString.append(score.first).append(",").append(score.second).append(";");
        }
        editor.putString(SCORES_KEY, scoresString.toString());
        editor.apply();
    }

    private static void loadScores() {
        String scoresString = sharedPreferences.getString(SCORES_KEY, null);
        if (scoresString != null) {
            scores.clear();
            String[] scorePairs = scoresString.split(";");
            for (String scorePair : scorePairs) {
                String[] parts = scorePair.split(",");
                scores.add(new Pair<>(parts[0], Integer.parseInt(parts[1])));
            }
        }
    }

    public static List<Pair<String, Integer>> getScores() {
        return scores;
    }
}