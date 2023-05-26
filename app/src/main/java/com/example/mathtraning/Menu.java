package com.example.mathtraning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    Button primB,zadB,statB;
    public String clas = "5";
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        primB = findViewById(R.id.primeri);
        zadB=findViewById(R.id.zadachi);
        statB = findViewById(R.id.statB);
        edt = findViewById(R.id.clas);

        edt.setText(clas);
        primB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Main.class);
                startActivity(intent);
                Main.ci = Integer.parseInt(edt.getText().toString());
            }
        });
        statB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Stat.class);
                startActivity(intent);
            }
        });
        zadB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Tasks.class);
                startActivity(intent);
                Tasks.ci = Integer.parseInt(edt.getText().toString());
            }
        });

    }
}