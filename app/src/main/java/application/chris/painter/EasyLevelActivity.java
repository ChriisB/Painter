package application.chris.painter;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.Button;

/**
 * Klasa rozszerzająca klasę LevelActivity, odpowiada za tworzenie i obsługę ekranu dla łatwego poziomu gry
 */
public class EasyLevelActivity extends LevelActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**Załadowanie przygotowanego pliku XML z layoutem - activity_easy_level*/
        setContentView(R.layout.activity_easy_level);
        /**Pobranie referencji do TextView. Otrzymany widok użyty jest w celu wyświetlania głównego napisu koloru*/
        mainSample = findViewById(R.id.main_sample);
        /**Pobranie referencji do TextView. Otrzymany widok służy do wyświetlania punktów zdobytych przez gracza*/
        point_counter = findViewById(R.id.points);
        /**Pobranie referencji do TextView. Otrzymany widok wykorzystany jest do odliczania czasu trwania rundy*/
        timer = findViewById(R.id.timer);
        /**Intencja przekazująca klase*/
        intent.putExtra("activity_name", EasyLevelActivity.class);
        /**Pobranie referencji do TextView. Otrzymany widok odpowiada za sprawdzanie poprawności odpowiedzi,
         * pojawia się gdy udzielimy poprawnej odpowiedzi*/
        tick_correct = findViewById(R.id.tick_correct);
        /**Pobranie referencji do TextView. Otrzymany widok odpowiadaja za sprawdzanie poprawności odpowiedzi,
         * pojawia się gdy udzielimy niepoprawnej odpowiedzi*/
        tick_wrong = findViewById(R.id.tick_wrong);
        /**Deklaracja metody odpowiadającej za obsługę przycisku powrotu do poprzedniej aktywności, zdefiniowanej w klasie nadrzędnej(LevelActivity)*/
        backButton();
        /**Deklaracja metody odpowiadającej za zliczanie czasu trwania rundy, zdefiniowanej w klasie nadrzędnej(LevelActivity)*/
        timer();
        /**
         * Dodanie do listy (utworzonej w klasie nadrzędnej) wykorzystywanych w aktualnym poziomie
         * przycisków oraz dodanie do mapy (utworzonej w klasie nadrzędnej) odpowiadających sobie par - (nazwa koloru, kolor)
         */
        colors.put(getResources().getText(R.string.red).toString(), ContextCompat.getColor(this, R.color.red));
        colors.put(getResources().getText(R.string.cyan).toString(), ContextCompat.getColor(this, R.color.cyan));
        colors.put(getResources().getText(R.string.grey).toString(), ContextCompat.getColor(this, R.color.grey));
        buttons.add((Button) findViewById(R.id.sample1));
        buttons.add((Button) findViewById(R.id.sample2));
        buttons.add((Button) findViewById(R.id.sample3));
        /**Deklaracja metody generującej losowy kolor oraz nazwę koloru na przyciskach. Zdefiniowana w klasie nadrzędnej(LevelActivity)*/
        randomlyChangeColors();
        /**Deklaracja metody obsługującej akcję wciśnięcia przycisku i jednocześnie sprawdzającej poprawność
         * udzielonej odpowiedzi. Zdefiniowana w klasie nadrzędnej(LevelActivity)
         * */
        addButtonListener();

    }//Koniec onCreate()

}//Koniec klasy EasyLevelActivity