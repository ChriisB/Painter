package application.chris.painter;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.Button;

/**
 * Klasa rozszerzająca klasę LevelActivity, odpowiada za tworzenie i obsługę ekranu dla trudnego poziomu gry
 */

public class HardLevelActivity extends LevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**Załadowanie przygotowanego pliku XML z layoutem - activity_hard_level*/
        setContentView(R.layout.activity_hard_level);
        mainSample = findViewById(R.id.main_sample);
        point_counter = findViewById(R.id.points);
        timer = findViewById(R.id.timer);
        intent.putExtra("activity_name", HardLevelActivity.class);
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
        colors.put(getResources().getText(R.string.blue).toString(), ContextCompat.getColor(this, R.color.blue));
        colors.put(getResources().getText(R.string.yellow).toString(), ContextCompat.getColor(this, R.color.yellow));
        colors.put(getResources().getText(R.string.orange).toString(), ContextCompat.getColor(this, R.color.orange));
        buttons.add((Button) findViewById(R.id.sample1));
        buttons.add((Button) findViewById(R.id.sample2));
        buttons.add((Button) findViewById(R.id.sample3));
        buttons.add((Button) findViewById(R.id.sample4));
        buttons.add((Button) findViewById(R.id.sample5));
        buttons.add((Button) findViewById(R.id.sample6));
        buttons.add((Button) findViewById(R.id.sample7));
        buttons.add((Button) findViewById(R.id.sample8));
        buttons.add((Button) findViewById(R.id.sample9));

        /**Deklaracja metody generującej losowy kolor oraz nazwę koloru na przyciskach. Zdefiniowana w klasie nadrzędnej(LevelActivity)*/
        randomlyChangeColors();
        /**Deklaracja metody obsługującej akcję wciśnięcia przycisku i jednocześnie sprawdzającej poprawność
         * udzielonej odpowiedzi. Zdefiniowana w klasie nadrzędnej(LevelActivity)
         * */
        addButtonListener();

    }//Koniec onCreate()

}//Koniec klasy HardLevelActivity