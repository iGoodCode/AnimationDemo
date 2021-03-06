package com.example.jinhui.animationdemo.step2.path.waveview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.animationdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 */

public class WaveViewActivity extends AppCompatActivity {

    @BindView(R.id.waveview)
    WaveView waveview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waveview);
        ButterKnife.bind(this);

        waveview.startAnim();
    }
}
