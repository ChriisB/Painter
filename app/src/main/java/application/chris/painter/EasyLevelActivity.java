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

import java.util.Objects;
import java.util.Random;

public class EasyLevelActivity extends LevelActivity {

    int random, oldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_easy_level);

        //final int colorStr = (String) findViewById(R.color.red);

        //getColorName();

        //final int colorStr = mainColor.getCurrentTextColor();     //!!!!!!!!!!!!!!!

        backButton1();
        //changeTextAndColorRandomly();
        //addPoints();
        //counter();
        //cos();
        //findColor();

    }

    public void backButton1() {
        final ImageButton backButton1 = findViewById(R.id.back_button);

        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
/*
    public void changeTextAndColorRandomly(){
        final String[] namesOfColors = {"red", "green", "gray"};
        final int[] arrayColors = {Color.parseColor("#ff000d"), Color.parseColor("#0fe200"), Color.parseColor("#505050")};
        //final int[] arrayColors = {R.color.red, R.color.green, R.color.grey};
//        final Button sample_first = findViewById(R.id.sampleFirst);
//        final Button sample_second = findViewById(R.id.sampleSecond);
//        final Button sample_third = findViewById(R.id.sampleThird);
        final TextView mainColor = findViewById(R.id.mainSample);
        final TextView point_counter = findViewById(R.id.points);
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
                oldValue = random;
                //point_counter.setText(buttonColorName);

                int name_color = mainColor.getCurrentTextColor();
                String buttonColorName = (String) sample_first.getText();
                String color = "green";

                //point_counter.setText("" + name_color);

                switch (name_color){
                    case (-65523):
                        color = "red";
                        //point_counter.setText("" + name_color);
                        break;
                    case (-157363):
                        color = "green";
                        //point_counter.setText("" + name_color);
                        break;
                    case (-11513776):
                        color = "grey";
                        //point_counter.setText("" + name_color);
                        break;
                }

                //point_counter.setText(color);
                if(buttonColorName.equals(color)){
                    counter[0] += 10;
                    String counterS = counter[0] + " pkt.";
                    point_counter.setText(counterS);
                }

//                else{
//                    point_counter.setText("nie dziala");
//                }
//                String text = (String) sample_first.getText();
//                String mainText = (String) mainColor.getText();
//
//                if(text.equals(mainText)){
//                    counter[0] += 10;
//                    String counterS = counter[0] + " pkt.";
//                    point_counter.setText(counterS);
//                }

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

                String buttonColorName = (String) sample_second.getText();
                String color = "green";

                int name_color = mainColor.getCurrentTextColor();

                switch (name_color) {
                    case (-65523):
                        color = "red";
                        break;
                    case (-157363):
                        color = "green";
                        break;
                    case (-11513776):
                        color = "grey";
                        break;
                }

                if(color.equals(buttonColorName)){
                    counter[0] += 10;
                    String counterS = counter[0] + " pkt.";
                    point_counter.setText(counterS);
                }
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

                String buttonColorName = (String) sample_third.getText();
                String color = "green";

                int name_color = mainColor.getCurrentTextColor();

                switch (name_color) {
                    case (-65523):
                        color = "red";
                        break;
                    case (-157363):
                        color = "green";
                        break;
                    case (-11513776):
                        color = "grey";
                        break;
                }

                if(color.equals(buttonColorName)){
                    counter[0] += 10;
                    String counterS = counter[0] + " pkt.";
                    point_counter.setText(counterS);
                }
            }
        });

    }
    */
/*
    public void addPoints(){

        String buttonColorName1 = (String) sample_first.getText();
        String buttonColorName2 = (String) sample_second.getText();
        String buttonColorName3 = (String) sample_third.getText();
        String color = "";

        int name_color = mainColor.getCurrentTextColor();
        //point_counter.setText(cos);
        //point_counter.setText("" + name_color);

        switch (name_color) {
            case (-65523):
                color = "red";
                break;
            case (-150225):
                color = "green";
                break;
            case (-11513776):
                color = "grey";
                break;
        }

        if(color.equals(buttonColorName1)){
            counter[0] += 10;
            String counterS = counter[0] + " pkt.";
            point_counter.setText(counterS);
        }

        if(color.equals(buttonColorName2)){
            counter[0] += 10;
            String counterS = counter[0] + " pkt.";
            point_counter.setText(counterS);
        }

        if(color.equals(buttonColorName3)){
            counter[0] += 10;
            String counterS = counter[0] + " pkt.";
            point_counter.setText(counterS);
        }
    }
*/
/*
    public String findColor(){
        String color = null;
        final TextView mainColor = findViewById(R.id.mainSample);

        switch (mainColor.getCurrentTextColor()) {
            case -65536:
                color = "red";
                break;
            case -16711936:
                color = "green";
                break;
            case -7829368:
                color = "grey";
                break;
        }
        return color;
    }


    public void cos(){

        final TextView mainColor = findViewById(R.id.mainSample);
        final Button sample_first = findViewById(R.id.sampleFirst);
        final TextView point_counter = findViewById(R.id.points);
        final int[] counter = {0};
        String cos = (String) sample_first.getText();
        String color = "vos";

        switch (mainColor.getCurrentTextColor()) {
            case -65536:
                color = "red";
                break;
            case -16711936:
                color = "green";
                break;
            case -7829368:
                color = "grey";
                break;
        }

        if(color.equals(cos)){
            counter[0] += 10;
            String counterS = counter[0] + " pkt.";
            point_counter.setText(counterS);
        }
    }
*/
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
