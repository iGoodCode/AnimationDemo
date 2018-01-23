package com.example.jinhui.animationdemo.layoutgridlayoutanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.animationdemo.R;

/**
 * Created by jinhui on 2018/1/23.
 * Email:1004260403@qq.com
 *
 * 前面两篇我们讲解了使用layoutAnimation和LayoutTransition实现ViewGroup中Item加载动画的方法，但他们都各自存在问题：
 layoutAnimation虽然是API 1中就已经引入，但只能在动画初次创建时才能使用指定动画。控件创建以后，再往ViewGroup里加Item就不会再有动画。这显然是不合适的！
 LayoutTransition能够实现无论何时往ViewGroup中添加控件都可以给其中控件使用动画。但最大的问题是，它的API等级是11。而且也没有兼容包可供我们使用这个函数。
 这样问题就来了，如果我们想在兼容API 8以上的机型，完成ListView中各个Item进入时都添加动画，这要怎么来做呢？
 今天我们要完成的效果图如下：
 */

public class ListViewItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewitem);
    }
}
