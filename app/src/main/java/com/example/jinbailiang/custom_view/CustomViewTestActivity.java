package com.example.jinbailiang.custom_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jinbailiang.demos_jinbai.R;

public class CustomViewTestActivity extends AppCompatActivity {

    private MyCustomView myCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_test);
        myCustomView = (MyCustomView)findViewById(R.id.myCustomView);
    }
}
