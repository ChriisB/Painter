package application.chris.painter;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Handler;

public abstract class LevelActivity extends AppCompatActivity {

    protected HashMap<String, Integer> colors = new HashMap<>();
    protected ArrayList<Button> buttons = new ArrayList<>();
    protected TextView mainSample;
    protected Random random = new Random();
    protected int counter = 0;
    TextView point_counter;
    TextView timer;

//    ProgressBar mProgressBar;
//    CountDownTimer mCountDownTimer;
//    protected int i = 0;

//    final Handler handler = new Handler();
//    TextView start_textview;
//    java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //start_textview = findViewById(R.id.start_textview);
        //progressBarTimer();

    }

    public void backButton() {
        final ImageButton backButton = (ImageButton) findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void counter(){
        new CountDownTimer(31000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");
            }
        }.start();
    }

//    public void progressBarTimer(){
//        mProgressBar.setProgress(i);
//        mCountDownTimer = new CountDownTimer(5000,1000) {
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                Log.v("Log_tag", "Tick of Progress"+ i + millisUntilFinished);
//                i++;
//                mProgressBar.setProgress(i*100/(5000/1000));
//            }
//            @Override
//            public void onFinish() {
//                i++;
//                mProgressBar.setProgress(100);
//            }
//        };
//        mCountDownTimer.start();
//    }

    public void randomlyChangeColors(){
        ArrayList<String> colorNames = new ArrayList<>(colors.keySet());
        ArrayList<Integer> colorValues = new ArrayList<>(colors.values());
        int colorNameIndex = random.nextInt(colorNames.size());
        int colorValuesIndex = random.nextInt(colorValues.size());

        mainSample.setText(colorNames.get(colorNameIndex));
        mainSample.setTextColor(colorValues.get(colorValuesIndex));

        for(Button button: buttons){
            colorNameIndex = random.nextInt(colorNames.size());
            colorValuesIndex = random.nextInt(colorValues.size());

            button.setText(colorNames.get(colorNameIndex));
            button.setTextColor(colorValues.get(colorValuesIndex));

            colorNames.remove(colorNameIndex);
            colorValues.remove(colorValuesIndex);

        }
    }

    public void addButtonListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if(colors.get(button.getText()) == mainSample.getTextColors().getDefaultColor()){
                    counter += 10;
                    String counterS = counter + " pkt.";
                    point_counter.setText(counterS);
                }
                randomlyChangeColors();
            }
        };
        for (Button button : buttons){
            button.setOnClickListener(listener);
        }
    }
}
