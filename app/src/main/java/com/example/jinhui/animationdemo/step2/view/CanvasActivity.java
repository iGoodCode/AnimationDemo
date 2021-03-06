package com.example.jinhui.animationdemo.step2.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.animationdemo.R;
import com.example.jinhui.animationdemo.step2.MyView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/1/24.
 * Email:1004260403@qq.com
 */

public class CanvasActivity extends AppCompatActivity {


    @BindView(R.id.myView)
    MyView myView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent != null){
            int value = intent.getIntExtra("drawMode", 0);
            MyView.DrawMode drawMode = MyView.DrawMode.valueOf(value);
            myView.setDrawMode(drawMode);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myView != null){
            myView.destroy();
            myView = null;
        }
    }
}
