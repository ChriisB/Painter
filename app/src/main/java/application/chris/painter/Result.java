package application.chris.painter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    Bundle extras;
    Class nextActivityClass;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);

        TextView player_score = findViewById(R.id.player_score);
        TextView high_score = findViewById(R.id.high_score);

        int counter = getIntent().getIntExtra("SCORE", 0);
        player_score.setText("Your Score: " + counter);

        SharedPreferences settings = getSharedPreferences("Game Data", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        if(counter > highScore){
            high_score.setText("High Score: " + counter);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", counter);
            editor.commit();
        }else{
            high_score.setText("High Score: " + highScore);
        }
    }

    public void tryAgain(View view) {

        extras = getIntent().getExtras();
        nextActivityClass = (Class<Activity>) extras.getSerializable("activity_name");

        Intent intent = new Intent(Result.this, nextActivityClass);
        startActivity(intent);
    }

    public void backToChooseLevelActivity(View view) {
        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
    }
}
