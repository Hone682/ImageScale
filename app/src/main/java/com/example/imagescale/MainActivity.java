package com.example.imagescale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyImageVIew myVIew = new MyImageVIew(this);
        setContentView(myVIew);
    }


}