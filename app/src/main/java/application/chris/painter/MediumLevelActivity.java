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

/**
 * Klasa rozszerzająca klasę LevelActivity, odpowiada za tworzenie i obsługę ekranu dla średniego poziomu gry
 */

public class MediumLevelActivity extends LevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**Załadowanie przygotowanego pliku XML z layoutem - activity_medium_level*/
        setContentView(R.layout.activity_medium_level);
        mainSample = findViewById(R.id.main_sample);
        point_counter = findViewById(R.id.points);
        timer = findViewById(R.id.timer);
        intent.putExtra("activity_name", MediumLevelActivity.class);
        tick_correct = findViewById(R.id.tick_correct);
        tick_wrong = findViewById(R.id.tick_wrong);

        backButton();
        timer();

        /**
         * Dodanie do listy (utworzonej w klasie nadrzędnej) wykorzystywanych w aktualnym poziomie
         * przycisków oraz dodanie do mapy (utworzonej w klasie nadrzędnej) odpowiadających sobie par - (nazwa koloru, kolor)
         */
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

        /**Deklaracja metody generującej losowy kolor oraz nazwę koloru na przyciskach. Zdefiniowana w klasie nadrzędnej(LevelActivity)*/
        randomlyChangeColors();
        /**Deklaracja metody obsługującej akcję wciśnięcia przycisku i jednocześnie sprawdzającej poprawność
         * udzielonej odpowiedzi. Zdefiniowana w klasie nadrzędnej(LevelActivity)
         * */
        addButtonListener();

    }//Koniec onCreate()

}//Koniec klasy MediumLevelActivity
