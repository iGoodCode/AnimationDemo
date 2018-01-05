package com.example.jinhui.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.animationdemo.animation.AnimationActivity;
import com.example.jinhui.animationdemo.baseanim.BaseAnimActivity;
import com.example.jinhui.animationdemo.interpolator.InterpolatorActivity;
import com.example.jinhui.animationdemo.propertyanimator.PropertyAnimatorActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/4.
 * Email:1004260403@qq.com
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_base)
    Button btBase;
    @BindView(R.id.bt_interpolator)
    Button btInterpolator;
    @BindView(R.id.bt_xml)
    Button btXml;
    @BindView(R.id.bt_valueAnimator)
    Button btValueAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_base, R.id.bt_interpolator, R.id.bt_xml, R.id.bt_valueAnimator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_base:
                startActivity(new Intent(this, BaseAnimActivity.class));
                break;
            case R.id.bt_interpolator:
                startActivity(new Intent(this, InterpolatorActivity.class));
                break;
            case R.id.bt_xml:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case R.id.bt_valueAnimator:
                startActivity(new Intent(this, PropertyAnimatorActivity.class));
                break;

        }
    }


}
