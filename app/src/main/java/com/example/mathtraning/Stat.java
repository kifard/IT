package com.example.mathtraning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stat extends AppCompatActivity {
    Button rtB;
    TextView txt;

    public static String S;
    public static int user = MainActivity.user-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        rtB = findViewById(R.id.returN);
        txt=findViewById(R.id.txts);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput("stat's")));
            br.readLine();
            for (int i = 0; i < user*6; i++) {
                br.readLine();
            }
            S = br.readLine() + ' ' + br.readLine() + "\n" + br.readLine();
            double d=(Double.parseDouble(br.readLine()));
            S = S + String.valueOf(d) + "\n" + br.readLine() + (d/(Double.parseDouble(br.readLine()))*100)+"%";
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        txt.setText(S);

        rtB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Stat.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}