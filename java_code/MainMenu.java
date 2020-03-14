package com.example.harrypotterworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    Button b1, b2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}


        setContentView(R.layout.main_menu);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.backmenu);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainMenu.this, CaracterQuiz.class);
                startActivity(i);
                finish();
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }

        });



    }
}
   // Drawable simple = getResources().getDrawable(R.drawable.answer);
   // Drawable clicked = getResources().getDrawable(R.drawable.answerselected);