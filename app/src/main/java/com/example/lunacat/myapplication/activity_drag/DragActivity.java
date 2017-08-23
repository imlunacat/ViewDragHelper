package com.example.lunacat.myapplication.activity_drag;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lunacat.myapplication.simple.DragFrameLayout;
import com.example.lunacat.myapplication.R;

public class DragActivity extends AppCompatActivity {
    DragFrameLayout mDragFrameLayout;
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.activity_drag);

        mDragFrameLayout = (DragFrameLayout) findViewById(R.id.root_framelayout);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }
}
