package com.example.jinhui.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.animationdemo.animation.AnimationActivity;
import com.example.jinhui.animationdemo.animatorset.AnimatorSetActivity;
import com.example.jinhui.animationdemo.baseanim.BaseAnimActivity;
import com.example.jinhui.animationdemo.interpolator.InterpolatorActivity;
import com.example.jinhui.animationdemo.layoutgridlayoutanimation.AnimateLayoutChangesLayoutTransitionActivity;
import com.example.jinhui.animationdemo.layoutgridlayoutanimation.LayoutGridLayoutAnimationActivity;
import com.example.jinhui.animationdemo.layoutgridlayoutanimation.listviewitem.ListViewItemActivity;
import com.example.jinhui.animationdemo.propertyanimator.PropertyAnimatorActivity;
import com.example.jinhui.animationdemo.propertyvaluesholder.OfPropertyValuesHolderActivity;
import com.example.jinhui.animationdemo.xml.xml_Value_ObjectAnimator_AnimatorSet;

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
    @BindView(R.id.bt_ofPropertyValuesHolder)
    Button btOfPropertyValuesHolder;
    @BindView(R.id.bt_animatorSet)
    Button btAnimatorSet;
    @BindView(R.id.bt_xml_Value_ObjectAnimator_AnimatorSet)
    Button btXmlValueObjectAnimatorAnimatorSet;
    @BindView(R.id.bt_layout_gridLayoutAnimation)
    Button btLayoutGridLayoutAnimation;
    @BindView(R.id.bt_animateLayoutChanges_LayoutTransition)
    Button btAnimateLayoutChangesLayoutTransition;
    @BindView(R.id.bt_listView_Item)
    Button btListViewItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_base, R.id.bt_interpolator, R.id.bt_xml, R.id.bt_valueAnimator,
            R.id.bt_ofPropertyValuesHolder, R.id.bt_animatorSet, R.id.bt_xml_Value_ObjectAnimator_AnimatorSet,
            R.id.bt_layout_gridLayoutAnimation, R.id.bt_animateLayoutChanges_LayoutTransition, R.id.bt_listView_Item})
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
            case R.id.bt_ofPropertyValuesHolder:
                startActivity(new Intent(this, OfPropertyValuesHolderActivity.class));
                break;
            case R.id.bt_animatorSet:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;
            case R.id.bt_xml_Value_ObjectAnimator_AnimatorSet:
                startActivity(new Intent(this, xml_Value_ObjectAnimator_AnimatorSet.class));
                break;
            case R.id.bt_layout_gridLayoutAnimation:
                startActivity(new Intent(this, LayoutGridLayoutAnimationActivity.class));
                break;
            case R.id.bt_animateLayoutChanges_LayoutTransition:
                startActivity(new Intent(this, AnimateLayoutChangesLayoutTransitionActivity.class));
                break;
            case R.id.bt_listView_Item:
                startActivity(new Intent(this, ListViewItemActivity.class));
                break;
        }
    }

}
