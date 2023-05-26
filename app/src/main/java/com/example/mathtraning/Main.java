package com.example.mathtraning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.util.Random;

public class Main extends AppCompatActivity {
    Button minusB, plusB, multB, divB, otvB, back;
    EditText edt;
    TextView txt;

    int count = 0;
    int all =0;

    static int user =0;

    static int ci=1;
    static String S = "";
    static double currask = 0;
    static double cortask = -487194128748912.;



    static Random rn = new Random();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        plusB = findViewById(R.id.plus);
        minusB = findViewById(R.id.minus);
        divB = findViewById(R.id.div);
        multB = findViewById(R.id.mult);
        otvB = findViewById(R.id.otv);
        edt = findViewById(R.id.edt);
        txt = findViewById(R.id.txt);
        back = findViewById(R.id.stat);
        switch (ci){
            case (5): {
                ci = 1;
                break;
            }
            case (6): {
                ci = 10;
                break;
            }
            case (7): {
                ci = 14;
                break;
            }
            default:{
                ci=1;
            }
        }

        plusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum();
                txt.setText(S);
            }
        });
        minusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minus();
                txt.setText(S);
            }
        });
        divB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
                txt.setText(S);
            }
        });
        multB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplication();
                txt.setText(S);
            }
        });
        otvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cortask = Double.parseDouble(edt.getText().toString());
                if (currask == cortask){
                    txt.setText("Верно");
                    count++;
                }
                else txt.setText("Неверно");
                cortask = -487194128748912.;
                all++;
                edt.setText("");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S = "";
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("stat's")));
                    user = MainActivity.user-1;
                    br.readLine();
                    for (int i = 0; i < user; i++) {

                        String data = "\n"+ br.readLine() + "\n" + br.readLine() + "\n" + br.readLine() + "\n" + br.readLine() + "\n" + br.readLine() + "\n"+ br.readLine();

                        S = S+data;
                    }

                        String data = "\n" +br.readLine() + "\n"+ br.readLine() + "\n" + br.readLine() + "\n" +  (Double.parseDouble(br.readLine())+count);
//                        br.readLine();
                        data= data + "\n" + br.readLine() + "\n"+ (Double.parseDouble(br.readLine())+all);
                        S = S+data;

                    while (br.readLine() != null){
                        S =S + "\n" +  br.readLine();
                    }
                    br.close();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("stat's", MODE_PRIVATE)));
                    bw.write(S);
                    bw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(Main.this, Menu.class);
                startActivity(intent);
            }
        });

    }

    public static void sum() throws InputMismatchException {
        int a = rn.nextInt(100 * ci);
        int b = rn.nextInt(100 * ci);

        S = a + " + " + b + " = ";

        currask = a + b;

    }

    public static void multiplication() throws InputMismatchException {
        int a = rn.nextInt(11* ci);
        int b = rn.nextInt(11* ci);

        S = a + " * " + b + " = ";

        currask = a * b;

    }

    public static void minus(){
        int a=0;
        int b=1;
        if (ci ==1) {
            while ((a-b)<0) {
                a = rn.nextInt(100);
                b = rn.nextInt(100);
            }
        }
        else {
            a = rn.nextInt(100 * ci);
            b = rn.nextInt(100 * ci);
        }

        S = a+" - "+b+" =";

        currask = a-b;
    }

    public static void division() throws ArithmeticException{
        int a=3;
        int b=2;
        while (a%b!=0) {
            a = rn.nextInt(100 * ci);
            b = rn.nextInt(25 * ci)+1;
        }

        S=a+" : "+b+"=";

        currask = (double)a/b;


    }
}