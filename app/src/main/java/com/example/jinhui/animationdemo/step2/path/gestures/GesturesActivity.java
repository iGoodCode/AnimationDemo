package com.example.jinhui.animationdemo.step2.path.gestures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.animationdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/25.
 * Email:1004260403@qq.com
 */

public class GesturesActivity extends AppCompatActivity {

    @BindView(R.id.bt_reset1)
    Button btReset1;
    @BindView(R.id.gestures1View)
    Gestures1View Gestures1View;
    @BindView(R.id.gestures2View)
    Gestures2View Gestures2View;
    @BindView(R.id.bt_reset2)
    Button btReset2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_reset1, R.id.bt_reset2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_reset1:
                Gestures1View.reset();
                break;
            case R.id.bt_reset2:
                Gestures2View.reset();
                break;
        }
    }
}
