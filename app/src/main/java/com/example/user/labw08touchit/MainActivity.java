package com.example.user.labw08touchit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    TextView parametrs;
    LinearLayout cordinats;
    float x, y, xDown, yDown, xMove, yMove, xUp, yUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parametrs = (TextView) findViewById(R.id.parametrs);
        cordinats = (LinearLayout) findViewById(R.id.cordinats);

        cordinats.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();   // текущая координата X пальца
        y = event.getY();   // текущая координата Y пальца

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                // здесь делаем что-то, чтобы обработать событие нажатия
                xDown = x;
                yDown = y;
                parametrs.setX(x);
                parametrs.setY(y);
                break;
            case MotionEvent.ACTION_MOVE: // движение
                // здесь обработываем событие перемещения пальца
                xMove = x;
                yMove = y;
                parametrs.setX(x);
                parametrs.setY(y);
                break;
            case MotionEvent.ACTION_UP: // отпускание
                // здесь делаем что-то, чтобы обработать событие отпускания
                xUp = x;
                yUp = y;
                parametrs.setX(x);
                parametrs.setY(y);
                break;
            case MotionEvent.ACTION_CANCEL:
                // событие отмены
                xUp = 0;
                yUp = 0;
                xMove = 0;
                yMove = 0;
                xDown = 0;
                yDown = 0;
                break;
        }
        // здесь можем вывести нужные надписи
        parametrs.setText("Down: " + xDown + " " + yDown + "\nMove: " + xMove + " " + yMove + "\nUp: " + xUp + " " + yUp);
        return true;
    }
}
