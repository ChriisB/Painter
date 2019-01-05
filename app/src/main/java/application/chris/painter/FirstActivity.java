package application.chris.painter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

/**
 * Klasa odpowiadająca za tworzenie wstępnego ekranu gry, wstępnej aktywności.
 */

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**Wywołanie metody z klasy, którą rozszerzamy (w tym przypadku - LevelActivity)*/
        super.onCreate(savedInstanceState);
        /**Wywołanie metod odpowiadających za ustawienie pełnego ekranu w danej aktywności*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**Załadowanie przygotowanego pliku XML z layoutem - activity_first*/
        setContentView(R.layout.activity_first);
        /**Deklaracja metody odpowiadającej za przejście do następnej aktywności (LevelChooseActivity) - wyboru poziomu gry*/
        StartButton();
        /**Deklaracja metody odpowiadającej za zakończenie działania aplikacji (zakończenie działania danej aktywności)*/
        exitButton();
    }
    /**Definicja metody odpowiadającej za przejście do następnej aktywności (LevelChooseActivity) - wyboru poziomu gry*/
    private void StartButton(){

        ImageButton startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, LevelChooseActivity.class));
            }
        });
    }
    /**Definicja metody odpowiadającej za zakończenie działania aplikacji (zakończenie działania danej aktywności)*/
    public void exitButton() {
        final ImageButton exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                //Process.killProcess(Process.myPid());
                System.exit(0);
            }
        });
    }
}//Koniec klasy FirstActivity
