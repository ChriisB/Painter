package application.chris.painter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

/**
 * Klasa odpowiadająca za utworzenie aktywności, w której dokonujemy wyboru poziomu gry
 */

public class LevelChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**Wywołanie metod odpowiadających za ustawienie pełnego ekranu w danej aktywności*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**Załadowanie przygotowanego pliku XML z layoutem - activity_level_choose*/
        setContentView(R.layout.activity_level_choose);
        /**Deklaracja metody odpowiadającej za przejście do odpowiednich aktywności
         * odpowiedzialnych za różne poziomy gry.
         * */
        LevelChooseButtons();
        /**Deklaracja metody odpowiadającej za obsługę przycisku powrotudo poprzedniej aktywności*/
        backButton();
    }
    /**Definicja metody odpowiadającej za obsługę przycisku powrotudo poprzedniej aktywności*/
    public void backButton() {
        final ImageButton backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FirstActivity.class));
            }
        });
    }
    /**Definicja metody odpowiadającej za przejście do odpowiednich aktywności
     * odpowiedzialnych za różne poziomy gry.*/
    public void LevelChooseButtons(){
        ImageButton  EasyLevelButton = findViewById(R.id.easyButton);
        ImageButton  MediumLevelButton = findViewById(R.id.mediumButton);
        ImageButton  HardLevelButton = findViewById(R.id.hardButton);

        EasyLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LevelChooseActivity.this, EasyLevelActivity.class));
            }
        });

        MediumLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LevelChooseActivity.this, MediumLevelActivity.class));
            }
        });

        HardLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LevelChooseActivity.this, HardLevelActivity.class));
            }
        });

    }//Koniec LevelChooseButtons

}//Koniec klasy LevelChooseActivity
