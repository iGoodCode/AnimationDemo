package com.example.jinhui.animationdemo.interpolator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.animationdemo.R;

/**
 * Created by jinhui on 2017/12/29.
 * Email:1004260403@qq.com
 *
 * 插值器学习篇
 * 自定义控件三部曲之动画篇（二）——Interpolator插值器
 * Interpolator属性是Animation类的一个XML属性，所以alpha、scale、rotate、translate、set都会继承得到这个属性。Interpolator被译为插值器，其实我不大能从字面上理解为什么会这样译，其实他是一个指定动画如何变化的东东，跟PS里的动作有点类似：随便拿来一张图片，应用一个动作，图片就会指定变化。
 * Interpolator的系统值有下面几个：
 * 意义如下：

 AccelerateDecelerateInterpolator   在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
 AccelerateInterpolator                     在动画开始的地方速率改变比较慢，然后开始加速
 AnticipateInterpolator                      开始的时候向后然后向前甩
 AnticipateOvershootInterpolator     开始的时候向后然后向前甩一定值后返回最后的值
 BounceInterpolator                          动画结束的时候弹起
 CycleInterpolator                             动画循环播放特定的次数，速率改变沿着正弦曲线
 DecelerateInterpolator                    在动画开始的地方快然后慢
 LinearInterpolator                            以常量速率改变
 OvershootInterpolator                      向前甩一定值后再回到原来位置
 */

public class InterpolatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
    }
}
