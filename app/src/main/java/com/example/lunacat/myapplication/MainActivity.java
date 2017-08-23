package com.example.lunacat.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lunacat.myapplication.activity_drag.DragActivity;
import com.example.lunacat.myapplication.simple.SimpleDragActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SimpleDragActivity.class);
                i.setAction(Intent.ACTION_MAIN);
                MainActivity.this.startActivity(i);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DragActivity.class);
                i.setAction(Intent.ACTION_MAIN);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
