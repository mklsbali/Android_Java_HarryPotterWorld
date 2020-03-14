package com.example.harrypotterworld;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CaracterQuiz extends AppCompatActivity {
    TextView t;
    Button a1, a2, a3, a4, a5;
    Button back, next;
    int selected=0;
    ArrayList<String>lines;
   // Question q;
    ArrayList<Question>questions;
    public static int final_points=0;
    ArrayList<Integer>a_points=null;
    int q_no=0;
    int ifselected;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}


        setContentView(R.layout.caracter_quiz);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        a3=findViewById(R.id.a3);
        a4=findViewById(R.id.a4);
        a5=findViewById(R.id.a5);
        t=findViewById(R.id.textView);
        back=findViewById(R.id.back);
        next=findViewById(R.id.next);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable simple = getResources().getDrawable(R.drawable.answern);
                Drawable clicked = getResources().getDrawable(R.drawable.answernpressed);
                a1.setBackgroundDrawable(clicked);
                a2.setBackgroundDrawable(simple);
                a3.setBackgroundDrawable(simple);
                a4.setBackgroundDrawable(simple);
                a5.setBackgroundDrawable(simple);
                ifselected=1;
                selected=1;

            }

        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable simple = getResources().getDrawable(R.drawable.answern);
                Drawable clicked = getResources().getDrawable(R.drawable.answernpressed);
                a1.setBackgroundDrawable(simple);
                a2.setBackgroundDrawable(clicked);
                a3.setBackgroundDrawable(simple);
                a4.setBackgroundDrawable(simple);
                a5.setBackgroundDrawable(simple);
                ifselected=1;
                selected=2;

            }

        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable simple = getResources().getDrawable(R.drawable.answern);
                Drawable clicked = getResources().getDrawable(R.drawable.answernpressed);
                a1.setBackgroundDrawable(simple);
                a2.setBackgroundDrawable(simple);
                a3.setBackgroundDrawable(clicked);
                a4.setBackgroundDrawable(simple);
                a5.setBackgroundDrawable(simple);
                ifselected=1;
                selected=3;

            }

        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable simple = getResources().getDrawable(R.drawable.answern);
                Drawable clicked = getResources().getDrawable(R.drawable.answernpressed);
                a1.setBackgroundDrawable(simple);
                a2.setBackgroundDrawable(simple);
                a3.setBackgroundDrawable(simple);
                a4.setBackgroundDrawable(clicked);
                a5.setBackgroundDrawable(simple);
                ifselected=1;
                selected=4;

            }

        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable simple = getResources().getDrawable(R.drawable.answern);
                Drawable clicked = getResources().getDrawable(R.drawable.answernpressed);
                a1.setBackgroundDrawable(simple);
                a2.setBackgroundDrawable(simple);
                a3.setBackgroundDrawable(simple);
                a4.setBackgroundDrawable(simple);
                a5.setBackgroundDrawable(clicked);
                ifselected=1;
                selected=5;

            }

        });

        questions=new ArrayList<Question>();
        lines=new ArrayList<String>();
        a_points=new ArrayList<Integer>();
        BufferedReader reader=null;
        BufferedReader reader1=null;
        try{
            reader=new BufferedReader(new InputStreamReader(getAssets().open("quiz.txt")));
            reader1=new BufferedReader(new InputStreamReader(getAssets().open("points.txt")));
            String line;

            while ((line=reader.readLine())!=null){
                lines.add(line);


            }
            while ((line=reader1.readLine())!=null){
                Integer a=Integer.parseInt(line);
                a_points.add(a);


            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        String qq="",aa1="",aa2="",aa3="",aa4="",aa5="";
        for (int i=0;i<lines.size();i+=6)
        {

            qq=lines.get(i);
            aa1=lines.get(i+1);
            aa2= lines.get(i+2);
            aa3=lines.get(i+3);
            aa4=lines.get(i+4);
            aa5=lines.get(i+5);
            questions.add(new Question(qq,aa1,aa2,aa3,aa4,aa5));
        }
        int i=0;
        for (int j=0;j<10;j++) {
            int ap1 = a_points.get(i);
            int ap2 = a_points.get(i + 1);
            int ap3 = a_points.get(i + 2);
            int ap4 = a_points.get(i + 3);
            int ap5 = a_points.get(i + 4);
            questions.get(j).setA1p(ap1);
            questions.get(j).setA2p(ap2);
            questions.get(j).setA3p(ap3);
            questions.get(j).setA4p(ap4);
            questions.get(j).setA5p(ap5);
            i+=5;
        }

        Question q=questions.get(q_no);
        t.setText("1. "+q.getQ());
        a1.setText(q.getA1());
        a2.setText(q.getA2());
        a3.setText(q.getA3());
        a4.setText(q.getA4());
        a5.setText(q.getA5());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CaracterQuiz.final_points=0;
                Intent i=new Intent(CaracterQuiz.this, MainMenu.class);
                startActivity(i);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ifselected!=0)
                {
                    ifselected=0;
                    Drawable simple = getResources().getDrawable(R.drawable.answern);
                    Drawable clicked = getResources().getDrawable(R.drawable.answernpressed);
                    a1.setBackgroundDrawable(simple);
                    a2.setBackgroundDrawable(simple);
                    a3.setBackgroundDrawable(simple);
                    a4.setBackgroundDrawable(simple);
                    a5.setBackgroundDrawable(simple);

                    if (q_no==9)
                    {
                        final_points+=get_selected_point();

                        Intent i=new Intent(CaracterQuiz.this, CaracterQuizResult.class);
                        startActivity(i);
                        finish();
                    }
                    if (q_no<9)
                    {
                        final_points+=get_selected_point();
                        q_no++;
                        Question q=questions.get(q_no);
                      //  Toast myToast= Toast.makeText(getApplicationContext(),""+final_points, Toast.LENGTH_LONG);
                       // myToast.show();
                        t.setText((q_no+1)+". "+q.getQ());
                        a1.setText(q.getA1());
                        a2.setText(q.getA2());
                        a3.setText(q.getA3());
                        a4.setText(q.getA4());
                        a5.setText(q.getA5());



                    }
                }
                else {
                    Toast myToast= Toast.makeText(getApplicationContext(),"Please, choose an option!", Toast.LENGTH_LONG);
                    myToast.show();
                    return;
                }



            }
        });



    }
    int get_selected_point(){
        int point=0;
        Question q=questions.get(q_no);
        if (selected==1)
            point=q.getA1p();
        else if (selected==2)
            point=q.getA2p();
        else if (selected==3)
            point=q.getA3p();
        else if (selected==4)
            point=q.getA4p();
        else if (selected==5)
            point=q.getA5p();
        return point;
    }

}
