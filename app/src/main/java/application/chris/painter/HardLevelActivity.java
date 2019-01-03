package application.chris.painter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.media.Image;
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

public class HardLevelActivity extends LevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        colors.put(getResources().getText(R.string.red).toString(), ContextCompat.getColor(this, R.color.red));
        colors.put("green", ContextCompat.getColor(this, R.color.green));
        colors.put("grey", ContextCompat.getColor(this, R.color.grey));
        colors.put("violet", ContextCompat.getColor(this, R.color.violet));
        colors.put("pink", ContextCompat.getColor(this, R.color.pink));
        colors.put("brown", ContextCompat.getColor(this, R.color.brown));
        colors.put("blue", ContextCompat.getColor(this, R.color.blue));
        colors.put("yellow", ContextCompat.getColor(this, R.color.yellow));
        colors.put("orange", ContextCompat.getColor(this, R.color.orange));

        buttons.add((Button) findViewById(R.id.sample1));
        buttons.add((Button) findViewById(R.id.sample2));
        buttons.add((Button) findViewById(R.id.sample3));
        buttons.add((Button) findViewById(R.id.sample4));
        buttons.add((Button) findViewById(R.id.sample5));
        buttons.add((Button) findViewById(R.id.sample6));
        buttons.add((Button) findViewById(R.id.sample7));
        buttons.add((Button) findViewById(R.id.sample8));
        buttons.add((Button) findViewById(R.id.sample9));

        randomlyChangeColors();
        addButtonListener();
    }

}
