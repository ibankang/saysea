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

public class GameStartActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private Button StartGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            window.setStatusBarColor(getColor(R.color.home_color));
//        }

        mediaPlayer = MediaPlayer.create(GameStartActivity.this, R.raw.start_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        StartGame = (Button) findViewById(R.id.start_game_btn);

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mediaPlayer.stop();
                Intent mainIntent = new Intent(GameStartActivity.this, MainActivity.class);
                startActivity(mainIntent);

            }
        });


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