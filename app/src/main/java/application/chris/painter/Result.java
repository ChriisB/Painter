package application.chris.painter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Klasa odpowiadająca za aktywność, w której wyświetlony zostaje wynik uzyskany po zakończeniu rozgrywki
 */

public class Result extends AppCompatActivity {
    Bundle extras;
    Class nextActivityClass;
    TextView high_score;
    TextView player_score;
    int counter;
    SharedPreferences easy_level_settings;
    SharedPreferences medium_level_settings;
    SharedPreferences hard_level_settings;
    int highScore_on_easy_level;
    int highScore_on_medium_level;
    int highScore_on_hard_level;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**Załadowanie przygotowanego pliku XML z layoutem - activity_result*/
        setContentView(R.layout.activity_result);
        /**Widok odpowiada za wyświetlenie aktualnego wyniku punktowego gracza zdobytego podczas rozgrywki*/
        player_score = findViewById(R.id.player_score);
        /**Widok odpowiada za wyświetlenie najwyższego wyniku punktowego osiągniętego przez gracza podczas rozgrywki*/
        high_score = findViewById(R.id.high_score);
        /**Zmienna przechowująca wynik uzyskany w danej rundzie, na danym poziomie trudności*/
        counter = getIntent().getIntExtra("SCORE", 0);
        /**Ustawienie wyniku punktowego w widoku*/
        player_score.setText("Your Score: " + counter);
        /**Zmienna przechowująca dane, które dostępne są po wyłączeniu aplikacji*/
        easy_level_settings = getSharedPreferences("Game Data", Context.MODE_PRIVATE);
        medium_level_settings = getSharedPreferences("Game Data", Context.MODE_PRIVATE);
        hard_level_settings = getSharedPreferences("Game Data", Context.MODE_PRIVATE);
        /**Zmienna przechowująca najwyższy wynik uzyskany, na danym poziomie trudności*/
        highScore_on_easy_level = easy_level_settings.getInt("HIGH_SCORE_EASY_LEVEL", 0);
        highScore_on_medium_level = medium_level_settings.getInt("HIGH_SCORE_MEDIUM_LEVEL", 0);
        highScore_on_hard_level = hard_level_settings.getInt("HIGH_SCORE_HaRD_LEVEL", 0);

        /**Deklaracja metody odpowiadającej za zmianę najwyższego osiągniętego przez gracza wyniku*/
        highScoreChange();

    }//Koniec onCreate()

    /**Metoda umożliwiająca ponowne włączenie danego poziomu gry*/
    public void tryAgain(View view) {

        extras = getIntent().getExtras();
        nextActivityClass = (Class<Activity>) extras.getSerializable("activity_name");

        Intent intent = new Intent(Result.this, nextActivityClass);
        startActivity(intent);
    }

    /**Metoda umożliwiająca powrót do ekranu wyboru poziomu*/
    public void backToChooseLevelActivity(View view) {
        startActivity(new Intent(getApplicationContext(), LevelChooseActivity.class));
    }

    /**Metoda odpowiadająca za zmianę najwyższego osiągniętego przez gracza wyniku zależnie od wybranego poziomu gry*/
    public void highScoreChange(){

        extras = getIntent().getExtras();
        nextActivityClass = (Class<Activity>) extras.getSerializable("activity_name");

        if(nextActivityClass == EasyLevelActivity.class) {
            if (counter > highScore_on_easy_level) {
                high_score.setText("High Score: " + counter);

                SharedPreferences.Editor editor1 = easy_level_settings.edit();
                editor1.putInt("HIGH_SCORE_EASY_LEVEL", counter);
                editor1.commit();
            } else {
                high_score.setText("High Score: " + highScore_on_easy_level);
            }
        }else if (nextActivityClass == MediumLevelActivity.class){
            if (counter > highScore_on_medium_level) {
                high_score.setText("High Score: " + counter);

                SharedPreferences.Editor editor1 = medium_level_settings.edit();
                editor1.putInt("HIGH_SCORE_MEDIUM_LEVEL", counter);
                editor1.commit();
            } else {
                high_score.setText("High Score: " + highScore_on_medium_level);
            }
        }else if (nextActivityClass == HardLevelActivity.class){
            if (counter > highScore_on_hard_level) {
                high_score.setText("High Score: " + counter);

                SharedPreferences.Editor editor1 = hard_level_settings.edit();
                editor1.putInt("HIGH_SCORE_HARD_LEVEL", counter);
                editor1.commit();
            } else {
                high_score.setText("High Score: " + highScore_on_hard_level);
            }
        }
    }

}//Koniec klasy Result