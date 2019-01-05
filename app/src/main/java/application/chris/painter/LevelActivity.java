package application.chris.painter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Klasa, po której dziedziczą klasy: EasyLevelActivity, MediumLevelActivity oraz HardLevelActivity
 * Zdefioniowane są w niej metody wykorzystywane w klasach odpowiadających różnym poziomom gry
 */

public abstract class LevelActivity extends AppCompatActivity {

    /**Kolekcja par typu klucz (key), którym w tym przypadku jest nazwa koloru oraz wartości (value), którą jest wartość danego koloru*/
    protected HashMap<String, Integer> colors = new HashMap<>();
    /**Lista przycisków używanych podczas wywołania odpowiednich poziomów gry*/
    protected ArrayList<Button> buttons = new ArrayList<>();
    /**Deklaracja intencji*/
    Intent intent;
    /**Inicjalizacja funkcji losującej*/
    protected Random random = new Random();
    /**Zmienna wykorzystana do zliczania punktów zdobytych podczas gry*/
    protected int counter = 0;
    /**Zmienna wykorzystana do wyświetlenia punktów zdobytych podczas gry*/
    String counterS;
    /**Deklaracje komponentów*/
    protected TextView mainSample;
    TextView point_counter;
    TextView timer;
    Button tick_correct;
    Button tick_wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**Definicja intencji, w której przekazana jest klasa Result*/
        intent = new Intent(getApplicationContext(), Result.class);
        tick_correct = findViewById(R.id.tick_correct);
        tick_wrong = findViewById(R.id.tick_wrong);
    }
    /**Definicja metody odpowiadającej za obsługę przycisku powrotudo poprzedniej aktywności*/
    public void backButton() {
        final ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LevelChooseActivity.class));
            }
        });
    }
    /**Licznik czasu pozostałego do końca rundy*/
    public void timer(){
        new CountDownTimer(31000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                startActivity(intent);
            }
        }.start();
    }
    /**Metoda generująca losowy kolor oraz nazwę koloru na przyciskach.*/
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
    /**Metody obsługująca akcję wciśnięcia przycisku i jednocześnie sprawdzająca poprawność udzielonej odpowiedzi.
     * */
    public void addButtonListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Button button = (Button) v;
                if(colors.get(button.getText()) == mainSample.getTextColors().getDefaultColor()){
                    counter += 10;
                    counterS = counter + " pkt.";
                    point_counter.setText(counterS);
                    intent.putExtra("SCORE", counter);
                    tick_correct.setVisibility(View.VISIBLE);
                    tick_correct.postDelayed(new Runnable() {
                        public void run() {
                            tick_correct.setVisibility(View.INVISIBLE);
                        }
                    }, 200);
                }else{
                    tick_wrong.setVisibility(View.VISIBLE);
                    tick_wrong.postDelayed(new Runnable() {
                        public void run() {
                            tick_wrong.setVisibility(View.INVISIBLE);
                        }
                    }, 200);
                }
                randomlyChangeColors();
            }
        };
        for (Button button : buttons){
            button.setOnClickListener(listener);
        }

    }//Koniec addButtonListener()

}//Koniec klasy LevelActivity
