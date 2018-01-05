package com.example.jinhui.animationdemo.propertyanimator;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.animationdemo.R;
import com.example.jinhui.animationdemo.customevaluator.MyEvaluator;
import com.example.jinhui.animationdemo.customevaluator.ReverseEvaluator;
import com.example.jinhui.animationdemo.custominterpolator.MyInterpolator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/5.
 * Email:1004260403@qq.com
 * 属性动画
 * <p>
 * 有关Animation的文章，讲解了传统的alpha、scale、translate、rotate的用法及代码生成方法。其实这三篇文章讲的所有动画效果叫做Tween Animation（补间动画）
 * 在Android动画中，总共有两种类型的动画View Animation(视图动画)和Property Animator(属性动画)；
 * <p>
 * 其中
 * View Animation包括Tween Animation（补间动画）和Frame Animation(逐帧动画)；
 * Property Animator包括ValueAnimator和ObjectAnimation；
 * 首先，直观上，他们有如下三点不同：
 * 1、引入时间不同：View Animation是API Level 1就引入的。Property Animation是API Level 11引入的，即Android 3.0才开始有Property Animation相关的API。
 * 2、所在包名不同：View Animation在包android.view.animation中。而Property Animation API在包 android.animation中。
 * 3、动画类的命名不同：View Animation中动画类取名都叫XXXXAnimation,而在Property Animator中动画类的取名则叫XXXXAnimator
 * 大家都知道逐帧动画主要是用来实现动画的，而补间动画才能实现控件的渐入渐出、移动、旋转和缩放的；而Property Animator是在Android 3.0版本才引入的，之前是没有的。大家可能会觉得补间动画和逐帧动画已经很全了，
 * <p>
 * 为什么还要引入Property Animator呢？
 * 如何利用补间动画来将一个控件的背景色在一分钟内从绿色变为红色？这个效果想必没办法仅仅通过改变控件的渐入渐出、移动、旋转和缩放来实现吧，而这个效果是可以通过Property Animator完美实现的
 * 这就是第一个原因：Property Animator能实现补间动画无法实现的功能
 * <p>
 * 补间动画和逐帧动画统称为View Animation，也就是说这两个动画只能对派生自View的控件实例起作用；而Property Animator则不同，从名字中可以看出属性动画，应该是作用于控件属性的！正因为属性动画能够只针对控件的某一个属性来做动画，所以也就造就了他能单独改变控件的某一个属性的值！比如颜色！
 * 这就是Property Animator能实现补间动画无法实现的功能的最重要原因。
 * <p>
 * <p>
 * <p>
 * <p>
 * 这就是第一个原因：Property Animator能实现补间动画无法实现的功能
 * 我们得到了第二点不同：View Animation仅能对指定的控件做动画，
 * 而Property Animator是通过改变控件某一属性值来做动画的。
 * 这就得到了第三点不同：补间动画虽能对控件做动画，但并没有改变控件内部的属性值。而Property Animator则是恰恰相反，
 * Property Animator是通过改变控件内部的属性值来达到动画效果的
 */

/**
 * ValueAnimator简单使用
 * Property Animator包括ValueAnimator和ObjectAnimator
 * 单从命名上，就能看出来这个东东的含义。ValueAnimator从名字可以看出，这个Animation是针对值的！ValueAnimator不会对控件做任何操作，
 * 我们可以给它设定从哪个值运动到哪个值，通过监听这些值的渐变过程来自己操作控件。
 * <p>
 * 常用方法:
 * ofInt与ofFloat
 * <p>
 * 常用函数:
 * 设置动画时长，单位是毫秒
 * ValueAnimator setDuration(long duration)
 * 获取ValueAnimator在运动时，当前运动点的值
 * Object getAnimatedValue();
 * 开始动画
 * void start()
 * 设置循环次数,设置为INFINITE表示无限循环
 * void setRepeatCount(int value)
 * 设置循环模式
 * value取值有RESTART，REVERSE，
 * void setRepeatMode(int value)
 * 取消动画
 * void cancel()
 * <p>
 * setDuration()、getAnimatedValue()、start()
 * 这三个函数在上面的实例中已经使用过，setDuration(long duration)是设置一次动画的时长，单位是毫秒，start()是开始动画，唯一有点难度的是Object getAnimatedValue()，它的声明为：
 * Object getAnimatedValue();
 * 它的意义就是获取动画在当前运动点的值，所以这个对象只能用于在动画运动中。返回的值是Object,上面我们说过，通过getAnimatedValue()得到的值的实际类型与初始设置的值相同，如果我们利用ofInt（）设置的动画，那通过getAnimatedValue()得到的值为类型就是Int类型。如果我们利用ofFloat（）设置的动画，通过getAnimatedValue()得到的值类型就是Float类型。
 * 总而言之，通过getAnimatedValue()值类型与初始设置动画时的值类型相同
 * <p>
 * setRepeatCount()、setRepeatMode()、cancel（）
 * setRepeatCount(int value)用于设置动画循环次数,设置为0表示不循环，设置为ValueAnimation.INFINITE表示无限循环。
 * cancel()用于取消动画
 * <p>
 *
 * 两个监听器：添加监听器
 * <p>
 * AnimatorUpdateListener \\ AnimatorListener
 * /**
 * 监听器一：监听动画变化时的实时值
 * public static interface AnimatorUpdateListener {
 * void onAnimationUpdate(ValueAnimator animation);
 * }
 * //添加方法为：public void addUpdateListener(AnimatorUpdateListener listener)
 * /**
 * 监听器二：监听动画变化时四个状态
 * public static interface AnimatorListener {
 * void onAnimationStart(Animator animation);
 * void onAnimationEnd(Animator animation);
 * void onAnimationCancel(Animator animation);
 * void onAnimationRepeat(Animator animation);
 * }
 * //添加方法为：public void addListener(AnimatorListener listener)
 *
 * 取消监听
 * // 移除AnimatorUpdateListener
 * void removeUpdateListener(AnimatorUpdateListener listener);
 * void removeAllUpdateListeners();
 * // 移除AnimatorListener
 * void removeListener(AnimatorListener listener);
 * void removeAllListeners();
 *
 * 其它函数:
 *  上面我们讲了ValueAnimator中常用的一些函数，但是还有一些函数虽然不常用
 *
 *  延时多久时间开始，单位是毫秒
 *  public void setStartDelay(long startDelay)
 *  完全克隆一个ValueAnimator实例，包括它所有的设置以及所有对监听器代码的处理
 *  public ValueAnimator clone()
 *  setStartDelay(long startDelay)非常容易理解，就是设置多久后动画才开始。
 但clone()这个函数就有点难度了；首先是什么叫克隆。就是完全一样！注意是完全一样！
 就是复制出来一个完全一样的新的ValueAnimator实例出来。对原来的那个ValueAnimator是怎么处理的，在这个新的实例中也是全部一样的。
 */
public class PropertyAnimatorActivity extends AppCompatActivity {

    private static final String TAG = PropertyAnimatorActivity.class.getSimpleName();
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.bt_cancel_anim)
    Button btCancelAnim;
    private ValueAnimator repeatAnimator;
    ValueAnimator newAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertyanimator);
        ButterKnife.bind(this);

        /**
         * 在上面的代码中，我们通过addUpdateListener添加了一个监听，在监听传回的结果中，是表示当前状态的ValueAnimator实例，我们通过animation.getAnimatedValue()得到当前值。
         * 然后通过Log打印出来，结果如下：
         * 45/? E/PropertyAnimatorActivity: curValue:38
         01-05 04:05:17.580 7945-7945/? E/PropertyAnimatorActivity: curValue:44
         01-05 04:05:17.596 7945-7945/? E/PropertyAnimatorActivity: curValue:51
         01-05 04:05:17.613 7945-7945/? E/PropertyAnimatorActivity: curValue:58
         01-05 04:05:17.630 7945-7945/? E/PropertyAnimatorActivity: curValue:66
         01-05 04:05:17.647 7945-7945/? E/PropertyAnimatorActivity: curValue:74
         这就是ValueAnimator的功能：ValueAnimator对指定值区间做动画运算，我们通过对运算过程做监听来自己操作控件。
         总而言之就是两点：

         ValueAnimator只负责对指定的数字区间进行动画运算
         我们需要对运算过程进行监听，然后自己对控件做动画操作
         */
        // 创建ValueAnimator实例
//        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
//        animator.setDuration(1000);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int) animation.getAnimatedValue();
//                Log.e(TAG, "curValue:" + curValue);
//            }
//        });
//        animator.start();
//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 400f, 50f, 300f);
//        animator.setDuration(3000);
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Float curValueFloat = (Float) animation.getAnimatedValue();
//                int curValue = curValueFloat.intValue();
//                tv.layout(curValue, curValue, curValue + tv.getWidth(), curValue + tv.getHeight());
//            }
//        });
//        animator.start();

    }

    @OnClick({R.id.btn, R.id.tv, R.id.bt_cancel_anim})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                // 基本动画
//                repeatAnimator = doAnimation();
                // 动画监听
//                repeatAnimator = doAnimatorListener();
                // 重复动画
//                 doClone();
                repeatAnimator = doArgbAnimation();

//                final TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400,
//                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400);
//                animation.setFillAfter(true);
//                animation.setDuration(1000);
//                tv.startAnimation(animation);
                break;
            case R.id.tv:
                Toast.makeText(this, "clicked me", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_cancel_anim:
                /**
                 * 针对AnimatorUpdateListener和AnimatorListener，每个监听器都有两个方法来移除；
                 * 我们就以移除AnimatorListener来简单讲一下，
                 * removeListener(AnimatorListener listener)用于在animator中移除指定的监听器，
                 * 而removeAllListeners()用于移除animator中所有的AnimatorListener监听器；
                 *下面上在添加监听器的例子基础上，不改变doAnimatorListener()的代码，
                 * 仍然是textview做动画时添加AnimatorListener的状态监听。然后点击cancelAnim时，移除AnimatorListener，代码如下：
                 *
                 * 当点击btnCancel时移除animator中所有的AnimatorListener，
                 * 但注意的是，我们在移除AnimatorListener后，并没有cancel动画效果，
                 * 所以动画会一直不停的运动下去。但移除AnimatorListener之后，Log应该就不会再打印了。
                 */
                repeatAnimator.removeAllListeners();
                repeatAnimator.cancel();
//                cloneCancel();

                break;
        }
    }

    /**
     * 我们上面讲了IntEvaluator和FloatEvalutor，还说了Evalutor一般来讲不能通用，会报强转错误，也就是说，只有在数值类型相同的情况下，Evalutor才能共用。
     其实除了IntEvaluator和FloatEvalutor，在android.animation包下，还有另外一个Evalutor叫ArgbEvalutor。
     ArgbEvalutor是用来做颜色值过渡转换的。可能是谷歌的开发人员觉得大家对颜色值变换可能并不知道要怎么做，所以特地给我们提供了这么一个过渡Evalutor；
     我们先来简单看一下ArgbEvalutor的源码：
     * 我们在这里关注两个地方，第一返回值是int类型，这说明我们可以使用ofInt()来初始化动画数值范围。
     * 第二：颜色值包括A,R,G,B四个值，每个值是8位所以用16进制表示一个颜色值应该是0xffff0000（纯红色）
     下面我们就使用一下ArgbEvaluator，并看看效果：

     我们将动画的数据范围定义为(0xffffff00,0xff0000ff)，即从黄色，变为蓝色。
     在监听中，我们根据当前传回来的颜色值，将其设置为textview的背景色

     ArgbEvalutor的实现原理 :看源码：
     这段代码分为三部分，第一部分根据startValue求出其中A,R,G,B中各个色彩的初始值；第二部分根据endValue求出其中A,R,G,B中各个色彩的结束值，最后是根据当前动画的百分比进度求出对应的数值
     我们先来看第一部分：根据startValue求出其中A,R,G,B中各个色彩的初始值
     int startInt = (Integer) startValue;
     int startA = (startInt >> 24);
     int startR = (startInt >> 16) & 0xff;
     int startG = (startInt >> 8) & 0xff;
     int startB = startInt & 0xff;
     我们的初始值是0xffffff00,那么求出来的startA = 0xff,startR = oxff,startG = 0xff,startB = 0x00;
     关于通过位移和与运算如何得到指定位的值的问题，我就不再讲了，大家如果不理解，可以搜一下相关运算符使用方法的文章。
     同样，我们看看第二部分根据endValue求出其中A,R,G,B中各个色彩的结束值：
     int endInt = (Integer) endValue;
     int endA = (endInt >> 24);
     int endR = (endInt >> 16) & 0xff;
     int endG = (endInt >> 8) & 0xff;
     int endB = endInt & 0xff;
     原理与startValue求A,R,G,B对应值的一样，所以对于我们上面例子中初始值ofInt(0xffffff00,0xff0000ff)中的endValue:0xff0000ff所对应的endA = 0xff,endR = ox00;endG = 0x00;endB = 0xff;
     最后一部分到了，就是如何根据进度来求得变化的值，我们先看看下面这句是什么意思：
     startA + (int)(fraction * (endA - startA)))
     对于这个公式大家应该很容易理解，与IntEvaluator中的计算公式一样，就是根据透明度A的初始值、结束值求得当前进度下透明度A应该的数值。
     同理
     startR + (int)(fraction * (endR - startR)表示当前进度下的红色值
     startG + (int)(fraction * (endG - startG))表示当前进度下的绿色值
     startB + (int)(fraction * (endB - startB))表示当前进度下的蓝色值
     然后通过位移和或运算将当前进度下的A,R,G,B组合起来就是当前的颜色值了
     */
    private ValueAnimator doArgbAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(3000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.setBackgroundColor(curValue);

            }
        });

        animator.start();
        return animator;
    }

    /**
     * 我们既移除了repeatAnimator的监听器又取消了动画。但有用吗？
     * 必须当然是没用的，因为我们start的动画对象是从repeatAnimator克隆来的newAnimator。这好比是克隆羊，原来的羊和克隆羊什么都是一样的，但你把原来的羊杀了，克隆的羊会死吗？用大脚指头想都知道不会！
     * 所以如果要取消当前的动画必须通过newAnimator.cancel()来取消
     */
    private void cloneCancel() {
//        repeatAnimator.removeAllUpdateListeners();
//        repeatAnimator.cancel();
        newAnimator.cancel();
    }

    /**
     * 我们利用clone()克隆了一个doRepeatAnim()生成的对象。然后调用setStartDelay(1000);
     * 将动画开始时间设为1000毫秒后开始动画。最后调用start（）函数开始动画。
     */
    private void doClone() {
        repeatAnimator = doRepeatAnim();
        //克隆一个新的ValueAnimator，然后开始动画
        newAnimator = repeatAnimator.clone();
        newAnimator.setStartDelay(1000);
        newAnimator.start();
    }

    private ValueAnimator doRepeatAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0,400);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        return animator;
    }

    /**
     * 关于监听器一：AnimatorUpdateListener就是监听动画的实时变化状态，
     * 在onAnimationUpdate(ValueAnimator animation)中的animation表示当前状态动画的实例。
     * 这里就不再细讲这个监听器了
     * <p>
     * 这里我们主要讲讲监听器AnimatorListener；
     * 在AnimatorListener中，主要是监听Animation的四个状态，start、end、cancel、repeat；
     * <p>
     * 当动画开始时，会调用onAnimationStart(Animator animation)方法，
     * 当动画结束时调用onAnimationEnd(Animator animation)，
     * 当动画取消时，调用onAnimationCancel(Animator animation)函数，
     * 当动画重复时，会调用onAnimationRepeat(Animator animation)函数。
     * <p>
     * 添加AnimatorListener的方法是addListener(AnimatorListener listener) ；
     * 下面我们就举个例子来看一下AnimatorListener的使用方法。
     * 我们在上面doRepeatAnim()函数的基础上，添加上AnimatorListener，代码如下：
     *
     * @return
     */
    private ValueAnimator doAnimatorListener() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                Log.e(TAG, "animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e(TAG, "animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e(TAG, "animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e(TAG, "animation repeat");
            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(1000);
        animator.start();
        return animator;
    }

    /**
     * layout函数在改变控件位置时是永久性的，即通过更改控件left,top,right,bottom这四个点的坐标来改更改坐标位置的，
     * <p>
     * 而不仅仅是从视觉上画在哪个位置，所以通过layout函数更改位置后，控件在新位置是可以响应点击事件的。
     * 大家可能注意到了,layout（）函数中上下左右点的坐标是以屏幕坐标来标准的。所以在效果图中可以看到，
     * textview的运动轨迹是从屏幕的左上角(0,0)点运行到（400，400）点。
     */

    /**
     * Evaluator其实就是一个转换器，他能把小数进度转换成对应的数值位置
     *
     * @return
     */
    private ValueAnimator doAnimation() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        animator.setDuration(1000);

        /**
         * curValue：计算当前的值 = 100 + （400 - 100）* 显示进度
         * 类似于（当前的值 = 100 + （400 - 100）* 显示进度
         其中100和400就是我们设置的ofInt(100,400)中的值，这个公式应该是比较容易理解的，就相当于我们做一个应用题：
         小明从100的位置开始出发向400的位置开始跑去，在走到全程距离20%位置时，请问小明在哪个数字点上？
         当前的值 = 100 + （400 -100）* 0.2； ）
         */
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
//                tv.layout(curValue, curValue, curValue + tv.getWidth(), curValue + tv.getHeight());
                // 左右值不变，上下变
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
            }
        });
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        本节补充插值器、转换器
//        animator.setInterpolator(new BounceInterpolator());
//        animator.setEvaluator(new IntEvaluator());
//        animator.setEvaluator(new MyEvaluator());
        // 实现倒序输出实例
        animator.setEvaluator(new ReverseEvaluator());
//        animator.setInterpolator(new MyInterpolator());
        animator.start();
//        ValueAnimator animator = ValueAnimator.ofFloat(0f, 400f, 50f, 300f);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Float curValueFloat = (Float) animation.getAnimatedValue();
//                int curValue = curValueFloat.intValue();
//                tv.layout(curValue, curValue, curValue + tv.getWidth(), curValue + tv.getHeight());
//            }
//        });
//        animator.setRepeatMode(ValueAnimator.REVERSE);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setDuration(3000);
//        animator.start();
        return animator;
    }


}
