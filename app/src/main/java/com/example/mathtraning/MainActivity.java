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

public class MainActivity extends AppCompatActivity {

    Button regB, logB, nextB;
    EditText logT, regT;
    TextView text;

    final String FILENAME = "stat's";

    public String count, percentage;

    public static String stat;

    boolean ok = false;

    public static int user = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regB = findViewById(R.id.regB);
        logB = findViewById(R.id.logB);
        logT = findViewById(R.id.log);
        regT = findViewById(R.id.Reg);
        text = findViewById(R.id.txt);
        nextB = findViewById(R.id.next);
        regB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput(FILENAME, MODE_APPEND)));
                    String[] name = regT.getText().toString().split(" ");
                    count ="0";
                    percentage="0";
                    bw.write("\n");
                    bw.write(name[0]);
                    bw.write("\n");
                    bw.write(name[1]);
                    bw.write("\n");
                    bw.write("Заданий выполнено верно: ");
                    bw.write("\n");
                    bw.write(count);
                    bw.write("\n");
                    bw.write("Качество выполнения: ");
                    bw.write("\n");
                    bw.write(percentage);
                    bw.close();
                    regT.setText("");
                    text.setText("Пользователь успешно зарегистрирован");
                    text.append("\n");
                    String data=name[0] + ' ' +name [1] + "\n" + "Заданий выполнено верно: " + count + "\n" + "Качество выполнения: " + percentage +"%";
                    text.append(data);
                    ok=true;
                    stat = data;

                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        });
        logB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
                    String[] nameT = logT.getText().toString().split(" ");
                    logT.setText("");
                    br.readLine();
                    String s = br.readLine();
                    String s1 = br.readLine();
                    while (s != null){
                        user++;
                        if (s.equals(nameT[0]) && s1.equals(nameT[1])) {
                            text.setText("Вход выполнен");
                            text.append("\n");
                            String data = nameT[0] + ' ' + nameT[1] + "\n" + br.readLine();
                            double d=(Double.parseDouble(br.readLine()));
                            data = data + String.valueOf(d) + "\n" + br.readLine() + (d/(Double.parseDouble(br.readLine()))*100)+"%";
                            text.append(data);
                            ok=true;
                            stat = data;
                            break;

                        }
                        s = br.readLine();
                        s1 = br.readLine();
                    }
//                    String data = br.readLine() + br.readLine() + ' ' + br.readLine() + "\n" + br.readLine()  + br.readLine() + "\n" + br.readLine() + br.readLine();
//                    text.setText(data);

                    br.close();
                    if (!ok){
                        text.setText("Пользователь не найден");
                        user =0;
                    }
                } catch (FileNotFoundException e) {}
                catch (IOException e) {}

            }
        });
        nextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ok) {
                    ok = false;
                    text.setText("Не выбран пользователь");
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                    Stat.S = stat;
                }
                else {
                    text.setText("Не выбран пользователь");
                }
            }
        });


    }
}