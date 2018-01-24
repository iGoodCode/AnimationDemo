package com.example.jinhui.animationdemo.step2.canvasbase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinhui on 2018/1/23.
 * Email:1004260403@qq.com
 */

public class MyView extends View {

    // 初始化画笔
    Paint paint = new Paint();


    private DrawMode drawMode = DrawMode.Lines;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 在这段代码中，首先对画笔进行基本的样式设置，
     * （对几何图形设置阴影，好像没作用），然后利用DrawCircle（）画了一个圆。
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (drawMode) {
            case Lines:
                doLines(canvas);
                break;
            case Point:
                doPoint(canvas);
                break;
            case Points:
                doPoints(canvas);
                break;
            case Rect:
                doRect(canvas);
                break;
            case RoundRect:
                doRoundRect(canvas);
                break;
            case Circle:
                doCircle(canvas);
                break;
            case Oval:
                doOval(canvas);
                break;
            case Arc:
                doArc(canvas);
                break;
        }

    }

    /**
     * 弧
     * 弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；
     void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)

     参数：
     RectF oval:生成椭圆的矩形
     float startAngle：弧开始的角度，以X轴正方向为0度
     float sweepAngle：弧持续的角度
     boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧

     （1）将画笔设为描边，效果：
     记得 画弧的中心点为矩形的对角线的焦点
     * @param canvas
     */
    private void doArc(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
//        paint.setStyle(Paint.Style.FILL);//填充样式改为填充
        paint.setStrokeWidth(5);//设置画笔宽度

        RectF rect1 = new RectF(100, 10, 400, 200);
        canvas.drawRect(rect1, paint);

        canvas.drawArc(rect1, 110, 90, true, paint);

        RectF rect2 = new RectF(400, 10, 600, 100);
        canvas.drawArc(rect2, 0, 90, false, paint);
    }

    /**
     * 椭圆
     * 椭圆是根据矩形生成的，以矩形的长为椭圆的X轴，矩形的宽为椭圆的Y轴，建立的椭圆图形
     * void drawOval (RectF oval, Paint paint)
     * 参数：
     * RectF oval：用来生成椭圆的矩形
     * @param canvas
     *
     */
    private void doOval(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        RectF rect = new RectF(100, 10, 300, 100);
        canvas.drawRect(rect, paint);//画矩形

        paint.setColor(Color.GREEN);//更改画笔颜色
        canvas.drawOval(rect, paint);//同一个矩形画椭圆
    }

    /**
     * 圆角矩形
     * void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
     参数：
     RectF rect:要画的矩形
     float rx:生成圆角的椭圆的X轴半径
     float ry:生成圆角的椭圆的Y轴半径
     * @param canvas
     */
    private void doRoundRect(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(15);//设置画笔宽度

        RectF rect = new RectF(100, 10, 300, 100);
        canvas.drawRoundRect(rect, 20, 10, paint);
    }

    /**
     * 绘制矩形
     * 矩形工具类RectF与Rect
     * 这两个都是矩形辅助类，区别不大，用哪个都行，根据四个点构建一个矩形结构；在画图时，利用这个矩形结构可以画出对应的矩形或者与其它图形Region相交、相加等等；

     RectF：
     构造函数有下面四个，但最常用的还是第二个，根据四个点构造出一个矩形；
     RectF()
     RectF(float left, float top, float right, float bottom)
     RectF(RectF r)
     RectF(Rect r)

     Rect
     构造函数如下，最常用的也是根据四个点来构造矩形
     Rect()
     Rect(int left, int top, int right, int bottom)
     Rect(Rect r)

     6、矩形
     void drawRect (float left, float top, float right, float bottom, Paint paint)
     void drawRect (RectF rect, Paint paint)
     void drawRect (Rect r, Paint paint)
     参数：
     第一个的写法是直接传入矩形的四个点，画出矩形
     第二、三个构造函数是根据传入RectF或者Rect矩形变量来指定所画的矩形的
     *
     * @param canvas
     */
    private void doRect(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(15);//设置画笔宽度

        canvas.drawRect(10, 10, 100, 100, paint);//直接构造

        RectF rect = new RectF(120, 10, 210, 100);
        canvas.drawRect(rect, paint);//使用RectF构造

        Rect rect2 =  new Rect(230, 10, 320, 100);
        canvas.drawRect(rect2, paint);//使用Rect构造
    }

    /**
     * 绘制多个点
     * void drawPoints (float[] pts, Paint paint)
     * void drawPoints (float[] pts, int offset, int count, Paint paint)
     * 参数：
     * float[] pts:点的合集，与上面直线一直，样式为｛x1,y1,x2,y2,x3,y3,……｝
     * int offset:集合中跳过的数值个数，注意不是点的个数！一个点是两个数值；
     * count:参与绘制的数值的个数，指pts[]里人数值个数，而不是点的个数，因为一个点是两个数值
     * <p>
     * 下面举例说明上面offset与count的含义：（跳过第一个点，画出后面两个点，第四个点不画），注意一个点是两个数值！
     * <p>
     * （同样是上面的四个点：（10，10）、（100，100），（200，200），（400，400），
     * drawPoints里路过前两个数值，即第一个点横纵坐标，画出后面四个数值代表的点，即第二，第三个点，第四个点没画；效果图如下）
     *
     * @param canvas
     */
    private void doPoints(Canvas canvas) {

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        float[] pts = {50, 50};
        canvas.drawPoints(pts, paint);
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(15);//设置画笔宽度

        float[] pts1 = {10, 10, 100, 100, 200, 200, 400, 400};
        canvas.drawPoints(pts1, 2, 4, paint);
    }

    /**
     * 绘制点
     * void drawPoint (float x, float y, Paint paint)
     * 参数：
     * float X：点的X坐标
     * float Y：点的Y坐标
     *
     * @param canvas
     */
    private void doPoint(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(15);//设置画笔宽度

        canvas.drawPoint(100, 100, paint);
    }

    /**
     * 绘制多条直线
     * void drawLines (float[] pts, Paint paint)
     * 有选择的绘制多条直线
     * void drawLines (float[] pts, int offset, int count, Paint paint)
     * 参数：
     * pts:是点的集合，大家下面可以看到，这里不是形成连接线，而是每两个点形成一条直线，pts的组织方式为｛x1,y1,x2,y2,x3,y3,……｝
     * （上面有四个点：
     * （10，10）、（100，100），（200，200），（400，400）），两两连成一条直线；
     * <p>
     * pts：绘制直线的端点数组，每条直线占用4个数据。
     * offset：跳过的数据个数，这些数据将不参与绘制过程。
     * count：实际参与绘制的数据个数。
     *
     * @param canvas
     */
    private void doLines(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(5);//设置画笔宽度

        float[] pts = {10, 10, 100, 100, 200, 200, 400, 400};
        canvas.drawLines(pts, paint);

        // 测试下void drawLines (float[] pts, int offset, int count, Paint paint)
        float[] pts1 = {50, 50, 400, 50,
                400, 50, 400, 600,
                400, 600, 50, 600,
                60, 600, 50, 50};
        // 指定跳过前4个数据，取出12个数据绘制直线。
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);//设置画笔宽度
        canvas.drawPoint(50, 50, paint);

        canvas.drawPoint(400, 50, paint);
        canvas.drawPoint(400, 600, paint);

        canvas.drawPoint(50, 600, paint);
        canvas.drawPoint(60, 600, paint);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);//设置画笔宽度
        canvas.drawLines(pts1, 4, 12, paint);
    }

    /**
     * 圆形
     * void drawCircle (float cx, float cy, float radius, Paint paint)
     参数：
     float cx：圆心点X轴坐标
     float cy：圆心点Y轴坐标
     float radius：圆的半径
     * @param canvas
     */
    private void doCircle(Canvas canvas) {
        //设置画笔基本属性
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);//抗锯齿功能
//        paint.setColor(Color.RED);  //设置画笔颜色
//        paint.setStyle(Paint.Style.FILL);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
//        paint.setStrokeWidth(5);//设置画笔宽度
//        paint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
//        //设置画布背景颜色
//        canvas.drawRGB(255, 255, 255);
//        //画圆
//        canvas.drawCircle(400, 400, 50, paint);
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);//设置填充样式
        paint.setStrokeWidth(15);//设置画笔宽度

        canvas.drawCircle(150, 150, 100, paint);
    }

    public void destroy() {
        releaseBitmap();
    }

    /**
     * 释放图片资源
     */
    private void releaseBitmap() {
    }


    //————————————————— 枚举———————————————————
    public enum DrawMode {
        Lines(1),
        Point(2),
        Points(3),
        Rect(4),
        RoundRect(5),
        Circle(6), 
        Oval(7), 
        Arc(8);

        private int value = 0;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        // 构造函数
        DrawMode(int value) {
            this.value = value;
        }


        public static DrawMode valueOf(int value) {
            switch (value) {
                case 1:
                    return Lines;
                case 2:
                    return Point;
                case 3:
                    return Points;
                case 4:
                    return Rect;
                case 5:
                    return RoundRect;
                case 6:
                    return Circle;
                case 7:
                    return Oval;
                case 8:
                    return Arc;
            }
            return null;
        }

    }

    public void setDrawMode(DrawMode mode) {
        this.drawMode = mode;
        // 刷新子线程界面？
        postInvalidate();
    }


}
