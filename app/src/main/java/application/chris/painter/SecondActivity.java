package application.chris.painter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//import static application.chris.painter.R.id.sampleFirst;


public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);

        LevelChooseButtons();
        backButton();
    }

    public void backButton() {
        final ImageButton backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FirstActivity.class));
            }
        });
    }



    public void LevelChooseButtons(){
        final ImageButton  EasyLevelButton = (ImageButton) findViewById(R.id.easyButton);
        ImageButton  MediumLevelButton = (ImageButton) findViewById(R.id.mediumButton);
        ImageButton  HardLevelButton = (ImageButton) findViewById(R.id.hardButton);

        EasyLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, EasyLevelActivity.class));
            }
        });

        MediumLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, MediumLevelActivity.class));
            }
        });

        HardLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, HardLevelActivity.class));
            }
        });

    }
}
