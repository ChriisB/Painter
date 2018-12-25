package application.chris.painter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class EasyLevelActivity extends AppCompatActivity {

    int random, oldValue;
    //Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_easy_level);


        backButton1();
        changeTextAndColorRandomly();

        final TextView timer = (TextView) findViewById(R.id.timer);
        new CountDownTimer(31000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("done!");
            }
        }.start();



    }

    public void backButton1() {
        final ImageButton backButton1 = (ImageButton) findViewById(R.id.back_button);

        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void changeTextAndColorRandomly(){

        final String[] namesOfColors = {"red", "green", "gray"};
        final int[] arrayColors = {Color.parseColor("#ff000d"), Color.parseColor("#1ac60e"), Color.parseColor("#505050")};
        final TextView mainColor = (TextView) findViewById(R.id.mainSample);
        final Button sample_first = (Button) findViewById(R.id.sampleFirst);
        Button sample_second = (Button) findViewById(R.id.sampleSecond);
        Button sample_third = (Button) findViewById(R.id.sampleThird);
        final TextView point_counter = (TextView) findViewById(R.id.points);
        final int[] counter = {0};


        sample_first.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                random = (int) (Math.random() * arrayColors.length);
                if(random == oldValue){
                    random = (int) (Math.random() * arrayColors.length);
                    //random_color = (int) (Math.random() * arrayColors.length);
                }
                mainColor.setText(namesOfColors[random]);
                if(random == oldValue){
                    random = (int) (Math.random() * arrayColors.length);
                    //random_color = (int) (Math.random() * arrayColors.length);
                }
                mainColor.setTextColor(arrayColors[random]);


                String text = (String) sample_first.getText();
                String mainText = (String) mainColor.getText();

                if(text.equals(mainText)){
                    counter[0] += 10;
                    String counterS = counter[0] + " pkt.";
                    point_counter.setText(counterS);
                }
                oldValue = random;
            }
        });

        sample_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = (int) (Math.random() * namesOfColors.length);
                if(random == oldValue){
                    random = (int) (Math.random() * namesOfColors.length);
                }
                mainColor.setText(namesOfColors[random]);
                if(random == oldValue){
                    random = (int) (Math.random() * arrayColors.length);
                }
                mainColor.setTextColor(arrayColors[random]);
                oldValue = random;
            }
        });

        sample_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = (int) (Math.random() * namesOfColors.length);
                if(random == oldValue){
                    random = (int) (Math.random() * namesOfColors.length);
                }
                mainColor.setText(namesOfColors[random]);
                if(random == oldValue){
                    random = (int) (Math.random() * arrayColors.length);
                }
                mainColor.setTextColor(arrayColors[random]);
                oldValue = random;
            }
        });
    }

    /*
    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };


    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };
    */



    /*
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }


    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
    */
}
