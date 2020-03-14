package com.example.harrypotterworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaracterQuizResult extends AppCompatActivity {
    Button main;
    TextView name;
    TextView description;
    ImageView iw;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}

       // Toast myToast= Toast.makeText(getApplicationContext(),""+CaracterQuiz.final_points, Toast.LENGTH_LONG);
       // myToast.show();
        setContentView(R.layout.caracter_quiz_result);
        description=(TextView) findViewById(R.id.description);
        name=(TextView) findViewById(R.id.name);
        iw=(ImageView)findViewById(R.id.imageView);
        main=(Button)findViewById(R.id.mainmenu);
        setFinalResult();
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CaracterQuiz.final_points=0;
                Intent i=new Intent(CaracterQuizResult.this, MainMenu.class);
                startActivity(i);
                finish();
            }
        });







    }
    public String readFile(String fname){
        BufferedReader reader = null;
        String finalLine = "";

        try {
            String line;
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fname)));


            while ((line = reader.readLine()) != null) {
                finalLine = finalLine + line + " ";


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return finalLine;
    }
    void setFinalResult(){
        String snape="",ron="",luna="",hermione="",harry="",dumbledore="";
        snape=readFile("snape.txt");
        ron=readFile("ron.txt");
        hermione=readFile("hermione.txt");
        harry=readFile("harry.txt");
        luna=readFile("luna.txt");
        dumbledore=readFile("dumbledore.txt");
        name.setText(""+CaracterQuiz.final_points+" points =");
        if (CaracterQuiz.final_points>=100 && CaracterQuiz.final_points<=150)
        {
            name.setText(name.getText()+" Severus Snape!");
            iw.setImageResource(R.drawable.snape);
            description.setText(snape);

        }
        else if (CaracterQuiz.final_points>=160 && CaracterQuiz.final_points<=200)
        {
            name.setText(name.getText()+" Ron Weasley!");
            iw.setImageResource(R.drawable.ron);
            description.setText(ron);

        }
        else if (CaracterQuiz.final_points>=210 && CaracterQuiz.final_points<=270)
        {
            name.setText(name.getText()+" Luna Lovegood!");
            iw.setImageResource(R.drawable.luna);
            description.setText(luna);

        }
        else if (CaracterQuiz.final_points>=280 && CaracterQuiz.final_points<=350)
        {
            name.setText(name.getText()+"  Hermione Granger!");
            iw.setImageResource(R.drawable.hermike);
            description.setText(hermione);

        }
        else if (CaracterQuiz.final_points>=360 && CaracterQuiz.final_points<=430)
        {
            name.setText(name.getText()+"  Harry Potter!");
            iw.setImageResource(R.drawable.harry_im);
            description.setText(harry);

        }
        else if (CaracterQuiz.final_points>=440 && CaracterQuiz.final_points<=500)
        {
            name.setText(name.getText()+"  Albus Dumbledore!");
            iw.setImageResource(R.drawable.dumbledore);
            description.setText(dumbledore);

        }

    }

}
