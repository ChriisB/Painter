package application.chris.painter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
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


public class MediumLevelActivity extends LevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level);
        mainSample = findViewById(R.id.main_sample);
        point_counter = findViewById(R.id.points);
        timer = findViewById(R.id.timer);
        intent.putExtra("activity_name", MediumLevelActivity.class);
        backButton();
        counter();

        colors.put(getResources().getText(R.string.red).toString(), ContextCompat.getColor(this, R.color.red));
        colors.put(getResources().getText(R.string.cyan).toString(), ContextCompat.getColor(this, R.color.cyan));
        colors.put(getResources().getText(R.string.grey).toString(), ContextCompat.getColor(this, R.color.grey));
        colors.put(getResources().getText(R.string.violet).toString(), ContextCompat.getColor(this, R.color.violet));
        colors.put(getResources().getText(R.string.pink).toString(), ContextCompat.getColor(this, R.color.pink));
        colors.put(getResources().getText(R.string.brown).toString(), ContextCompat.getColor(this, R.color.brown));

        buttons.add((Button) findViewById(R.id.sample1));
        buttons.add((Button) findViewById(R.id.sample2));
        buttons.add((Button) findViewById(R.id.sample3));
        buttons.add((Button) findViewById(R.id.sample4));
        buttons.add((Button) findViewById(R.id.sample5));
        buttons.add((Button) findViewById(R.id.sample6));

        randomlyChangeColors();
        addButtonListener();
    }
}
