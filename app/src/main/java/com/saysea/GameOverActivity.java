package com.saysea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity
{
    private Button StartGameAgain;
    private TextView Displayscore;
    private String score;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        score = getIntent().getExtras().get("score").toString();

        StartGameAgain = (Button) findViewById(R.id.play_again_btn);
        Displayscore = (TextView) findViewById(R.id.displayScore);


        mediaPlayer = MediaPlayer.create(GameOverActivity.this, R.raw.backgroundmusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


        StartGameAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mediaPlayer.stop();
                Intent mainIntent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });

        Displayscore.setText("Total Score = " + score);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}