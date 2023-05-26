package com.example.mathtraning;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.Random;

public class Tasks extends AppCompatActivity {
    static String S[] = new String[2];
    public  static int ci;
    int count =0;
    int all=0;
    Button otvB,backB;
    TextView txt, atxt;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        otvB = findViewById(R.id.otv);
        backB = findViewById(R.id.back);
        txt = findViewById(R.id.tasktext);
        edt = findViewById(R.id.edtT);
        atxt = findViewById(R.id.atext);




        switch (ci){
            case(5):
                tasks5();
            break;
            case (6):
                tasks6();
                break;
            default:{
                tasks5();
                break;
            }
        }
        txt.setText(S[1]);
        otvB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (S[0].equals(edt.getText().toString())){
                    atxt.setText("Верно");
                    count++;
                }
                else atxt.setText("Неверно");
                all++;
                edt.setText("");
                switch (ci){
                    case(5):
                        tasks5();
                        break;
                    case (6):
                        tasks6();
                        break;
//                    default:{
//                        tasks5();
//                        break;
//                    }
                }
                txt.setText(S[1]);
            }
        });
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    int user;
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


                    Intent intent = new Intent(Tasks.this, Menu.class);
                    startActivity(intent);
                }

        });

    }
        public static void tasks5(){
            Random rn = new Random();
            int n = rn.nextInt( 4);
            int answer;//ответ
            switch (n){
                case (1):{
                    int a = rn.nextInt(8);
                    int b = rn.nextInt(8);
                    int h = rn.nextInt(8);
                    int d = rn.nextInt(8);
                    int f = rn.nextInt(24)+10;

                    answer = f-a+b-h+d;
                    S[0] = Integer.toString(answer);
                    S[1]= ("Из автобуса на остановке вышло " + a + " пассажиров, а вошло " + b +". На следующей остановке вышло "+h+", вошло "+d+". Сколько пассажиров стало в автобусе, если вначале в автобусе было "+f+" пассажира?");
                    break;

                }
                case (2):{
                    int a = rn.nextInt( 26);
                    int b = rn.nextInt( 10);
                    int c = rn.nextInt(8);

                    answer = a+b;

                    String data1 = "год";
                    String data2 = "год";

                    if(a%10==1 || a==1){
                        data1 = "год";
                    }
                    if(a%10>1 && a%10<5 && a!=1 && (a>20 || a<10)){
                        data1 = "года";
                    }
                    else {
                        data1 = "лет";
                    }


                    if(b%10==1 || b==1){
                        data2 = "год";
                    }
                    if(b%10>1 && b%10<5 && b!=1 && b>20  && (b>20 || b<10)){
                        data2 = "года";
                    }
                    else {
                        data2 = "лет";
                    }


                    S[0] = Integer.toString(answer);

                    S[1] = ("Папе " + a + " " + data1 + ", он на "+ b + " " + data2 + " моложе дедушки и в " + c + " раза старше сына. Сколько лет дедушке?");
                    break;

                }
                case (3):{
                    int a = rn.nextInt( 10)+1;
                    int b = rn.nextInt( 100)+1;

                    while(b%a != 0){
                        a = rn.nextInt( 10)+1;
                        b = rn.nextInt( 100)+1;
                    }

                    answer = b/a;

                    S[0] = Integer.toString(answer);

                    S[1] = ("У Вики было в " + a + " раза меньше апельсин, чем у Оли. При этом у Оли было на " + b + " апельсин больше, чем у Вики. Сколько апельсин у Оли?");
                    break;
                }

                default:{
                    int a = rn.nextInt(8);
                    int b = rn.nextInt(8);
                    int h = rn.nextInt(8);
                    int d = rn.nextInt(8);
                    int f = rn.nextInt(24)+10;

                    answer = f-a+b-h+d;
                    S[0] = Integer.toString(answer);
                    S[1]= ("Из автобуса на остановке вышлоf " + a + " пассажиров, а вошло " + b +". На следующей остановке вышло "+h+", вошло "+d+". Сколько пассажиров стало в автобусе, если вначале в автобусе было "+f+" пассажира?");
                    break;
                }

            }
        }
    public static void tasks6() {
        Random rn = new Random();
        int n = rn.nextInt(2)+1;
        int answer;//ответ
        switch (n) {
            case (1): {
                int a = rn.nextInt(15)+1;
                int b = rn.nextInt(8)+1;
                int c = rn.nextInt(50)+1;
                int d = rn.nextInt(13)+1;

                while (b%a!=0){
                     a = rn.nextInt(15)+1;
                     b = rn.nextInt(8)+1;
                }
                while ((b/a)%d!=0){
                     d = rn.nextInt(13)+1;

                }
                int f = rn.nextInt(6)+1+d;

                answer = b/a/d*f*c;
                S[0] = Integer.toString(answer);
                S[1] = ( d +" осликов за "+  a + " дня съедают " + b +  " мешков корма. Сколько корма надо "+ f +" осликам на "+ c + " дней?");
                break;
            }
            case (2): {

                int b = rn.nextInt(15)+1;
                int a =b + rn.nextInt(61)+1;
                while ((a-b)%2!=0){
                    b = rn.nextInt(15)+1;
                    a = rn.nextInt(61)+1+b;

                }
                answer = (a-b)/2;
                S[0] = Integer.toString(answer);
                S[1] = (" Егорка и Настя поделили по-братски между собой " + a +" конфет, причем Насте досталось на " + b + " конфет больше. Сколько конфет съел Егорка? ");
                break;
            }
            default:{
                int a = rn.nextInt(15)+1;
                int b = rn.nextInt(8)+1;
                int c = rn.nextInt(50)+1;
                int d = rn.nextInt(13)+1;

                while (b%a!=0){
                    a = rn.nextInt(15)+1;
                    b = rn.nextInt(8)+1;
                }
                while ((b/a)%d!=0){
                    d = rn.nextInt(13)+1;

                }
                int f = rn.nextInt(6)+1+d;

                answer = b/a/d*f*c;
                S[0] = Integer.toString(answer);
                S[1] = ( d +" осликоf за "+  a + " дня съедают " + b +  " мешков корма. Сколько корма надо "+ f +" осликам на "+ c + " дней?");
                break;
            }
        }
    }

    }
