package com.example.jinhui.animationdemo.step2.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
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
            case Line_path:
                doLinePath(canvas);
                break;
            case Rect_path:
                doRectPath(canvas);
                break;
            case Roundrect_path:
                doRoundRectPath(canvas);
                break;
            case Circle_path:
                doCirclePath(canvas);
                break;
            case Oval_path:
                doOvalParh(canvas);
                break;
            case Arc_path:
                doArcPath(canvas);
                break;
            case Paint_style:
                doPaintStyle(canvas);
                break;
            case Paint_style1:
                doPaintStyle1(canvas);
                break;
            case Paint_style2:
                doPaintStyle2(canvas);
                break;
            case Canvas:
                doCanvas(canvas);
                break;
            case Pos_text:
                doPos_text(canvas);
                break;
            case TextOnPath:
                doTextOnPath(canvas);
                break;
            case Typeface:
                doTypeface(canvas);
                break;
            case CustomTypeface:
                doCustomTypeface(canvas);
                break;
        }

    }

    /**
     * 自字义字体
     * <p>
     * 自定义字体的话，我们就需要从外部字体文件加载我们所需要的字形的，从外部文件加载字形所使用的Typeface构造函数如下面三个：
     * Typeface	createFromAsset(AssetManager mgr, String path) //通过从Asset中获取外部字体来显示字体样式
     * Typeface	createFromFile(String path)//直接从路径创建
     * Typeface	createFromFile(File path)//从外部路径来创建字体样式
     * <p>
     * 后面两个从路径加载难度不大，而我们一般也不会用到，这里我们说说从Asset文件中加载；
     * <p>
     * 首先在Asset下建一个文件夹，命名为Fonts，然后将字体文件jian_luobo.ttf 放入其中
     *
     * @param canvas
     */
    private void doCustomTypeface(Canvas canvas) {
        //自定义字体，，，迷你简罗卜
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(60);//设置文字大小
        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充

        AssetManager mgr = getContext().getAssets();//得到AssetManager
        Typeface typeface = Typeface.createFromAsset(mgr, "Fonts/jian_luobo.ttf");//根据路径得到Typeface
        paint.setTypeface(typeface);
        canvas.drawText("欢迎光临Harvic的博客", 10, 100, paint);//两个构造函数
    }

    /**
     * 字体样式设置（Typeface）
     * 在Paint中设置字体样式：
     * <p>
     * paint.setTypeface(typeface);
     * <p>
     * <p>
     * Typeface相关
     * <p>
     * 概述：Typeface是专门用来设置字体样式的，通过paint.setTypeface()来指定。可以指定系统中的字体样式，也可以指定自定义的样式文件中获取。要构建Typeface时，可以指定所用样式的正常体、斜体、粗体等，如果指定样式中，没有相关文字的样式就会用系统默认的样式来显示，一般默认是宋体。
     * <p>
     * 创建Typeface：
     * <p>
     * Typeface	create(String familyName, int style) //直接通过指定字体名来加载系统中自带的文字样式
     * Typeface	create(Typeface family, int style)     //通过其它Typeface变量来构建文字样式
     * Typeface	createFromAsset(AssetManager mgr, String path) //通过从Asset中获取外部字体来显示字体样式
     * Typeface	createFromFile(String path)//直接从路径创建
     * Typeface	createFromFile(File path)//从外部路径来创建字体样式
     * Typeface	defaultFromStyle(int style)//创建默认字体
     * <p>
     * 上面的各个参数都会用到Style变量,Style的枚举值如下:
     * Typeface.NORMAL  //正常体
     * Typeface.BOLD	//粗体
     * Typeface.ITALIC	//斜体
     * Typeface.BOLD_ITALIC //粗斜体
     * （1）、使用系统中的字体
     * <p>
     * 从上面创建Typeface的所有函数中可知，使用系统中自带的字体有下面两种方式来构造Typeface：
     * <p>
     * Typeface	defaultFromStyle(int style)//创建默认字体
     * Typeface	create(String familyName, int style) //直接通过指定字体名来加载系统中自带的文字样式
     * <p>
     * 其实，第一个仅仅是使用系统默认的样式来绘制字体，基本没有可指定性，就不再讲了，使用起来难度也不大，下面只以第二个构造函数为例，指定宋体绘制：
     *
     * @param canvas
     */
    private void doTypeface(Canvas canvas) {
        //使用系统自带字体绘制
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(60);//设置文字大小
        paint.setStyle(Paint.Style.STROKE);//绘图样式，设置为填充

        String familyName = "宋体";
        Typeface font = Typeface.create(familyName, Typeface.NORMAL);
        paint.setTypeface(font);
        canvas.drawText("欢迎光临Harvic的博客", 10, 100, paint);
    }

    /**
     * 沿路径绘制
     * void drawTextOnPath (String text, Path path, float hOffset, float vOffset, Paint paint)
     * void drawTextOnPath (char[] text, int index, int count, Path path, float hOffset, float vOffset, Paint paint)
     * <p>
     * 参数说明：
     * <p>
     * 有关截取部分字体绘制相关参数（index,count），没难度，就不再讲了，下面首重讲hOffset、vOffset
     * float hOffset  : 与路径起始点的水平偏移距离
     * float vOffset  : 与路径中心的垂直偏移量
     *
     * @param canvas
     */
    private void doTextOnPath(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(45);//设置文字大小
        paint.setStyle(Paint.Style.STROKE);//绘图样式，设置为填充

        String string = "风萧萧兮易水寒，壮士一去兮不复返";

//先创建两个相同的圆形路径，并先画出两个路径原图
        Path circlePath = new Path();
        circlePath.addCircle(220, 200, 180, Path.Direction.CCW);//逆向绘制,还记得吗,上篇讲过的
        canvas.drawPath(circlePath, paint);//绘制出路径原形

        Path circlePath2 = new Path();
        circlePath2.addCircle(750, 200, 180, Path.Direction.CCW);
        canvas.drawPath(circlePath2, paint);//绘制出路径原形

        paint.setColor(Color.GREEN);
//hoffset、voffset参数值全部设为0，看原始状态是怎样的
        canvas.drawTextOnPath(string, circlePath, 0, 0, paint);
//第二个路径，改变hoffset、voffset参数值
        canvas.drawTextOnPath(string, circlePath2, 80, 30, paint);
    }

    /**
     * 指定个个文字位置
     * void drawPosText (char[] text, int index, int count, float[] pos, Paint paint)
     * void drawPosText (String text, float[] pos, Paint paint)
     * <p>
     * 说明：
     * 第一个构造函数：实现截取一部分文字绘制；
     * <p>
     * 参数说明：
     * char[] text：要绘制的文字数组
     * int index:：第一个要绘制的文字的索引
     * int count：要绘制的文字的个数，用来算最后一个文字的位置，从第一个绘制的文字开始算起
     * float[] pos：每个字体的位置，同样两两一组，如｛x1,y1,x2,y2,x3,y3……｝
     *
     * @param canvas
     */
    private void doPos_text(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(80);//设置文字大小
        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充

        float[] pos = new float[]{40, 100, 50, 200,
                60, 300, 70, 400};
        canvas.drawPosText("画图示例", pos, paint);//两个构造函数
        float[] pos1 = new float[]{150, 100, 150, 200,
                150, 300, 150, 400, 160, 500,
                170, 600, 180, 700};
        char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        canvas.drawPosText(chars, 2, 3, pos1, paint);
    }

    /**
     * 普通水平绘制
     * 构造函数：
     * <p>
     * void drawText (String text, float x, float y, Paint paint)
     * void drawText (CharSequence text, int start, int end, float x, float y, Paint paint)
     * void drawText (String text, int start, int end, float x, float y, Paint paint)
     * void drawText (char[] text, int index, int count, float x, float y, Paint paint)
     * <p>
     * 说明：
     * 第一个构造函数：最普通简单的构造函数；
     * 第三、四个构造函数：实现截取一部分字体给图；
     * 第二个构造函数：最强大，因为传入的可以是charSequence类型字体，所以可以实现绘制带图片的扩展文字（待续），而且还能截取一部分绘制
     * <p>
     * 这几个函数就不再多说了，很简单，前面我们也一直在用第一个构造函数，文字截取一般用不到，我也不多说了，浪费时间，可能大家看到有个构造函数中，可以传入charSequence类型的字符串，charSequence是可以利用spannableString来构造有图片的字符串的，那这里是不是可以画出带有图片的字符串来呢 ，我想多了，实际证明，canvas画图是不支持Span替换的。所以这里的charSequence跟普通的String没有任何区别的。
     *
     * @param canvas
     */
    private void doCanvas(Canvas canvas) {
    }

    /**
     * 水平拉伸设置（ paint.setTextScaleX(2);）
     * 写三行字，第一行，水平未拉伸的字体；第二行，水平拉伸两倍的字体；第三行，水平未拉伸和水平拉伸两部的字体写在一起，
     * 可以发现，仅是水平方向拉伸，高度并未改变；
     *
     * @param canvas
     */
    private void doPaintStyle2(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(50);//设置文字大小
        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充

//变通样式字体
        canvas.drawText("欢迎光临Harvic的博客", 10, 100, paint);

//水平方向拉伸两倍
        paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
        canvas.drawText("欢迎光临Harvic的博客", 10, 200, paint);

//写在同一位置,不同颜色,看下高度是否看的不变
        paint.setTextScaleX(1);//先还原拉伸效果
        canvas.drawText("欢迎光临Harvic的博客", 10, 300, paint);

        paint.setColor(Color.GREEN);
        paint.setTextScaleX(2);//重新设置拉伸效果
        canvas.drawText("欢迎光临Harvic的博客", 10, 300, paint);
    }

    /**
     * 文字样式设置及倾斜度正负区别
     *
     * @param canvas
     */
    private void doPaintStyle1(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色      

        paint.setStrokeWidth(5);//设置画笔宽度  
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢  
        paint.setTextSize(50);//设置文字大小
        paint.setStyle(Paint.Style.FILL);//绘图样式，设置为填充     

//样式设置  
        paint.setFakeBoldText(true);//设置是否为粗体文字  
        paint.setUnderlineText(true);//设置下划线  
        paint.setStrikeThruText(true);//设置带有删除线效果  

//设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜  
        paint.setTextSkewX((float) -0.25);
        canvas.drawText("欢迎光临Harvic的博客—倾斜度-0.25", 10, 100, paint);

//水平倾斜度设置为：0.25，往左斜  
        paint.setTextSkewX((float) 0.25);
        canvas.drawText("欢迎光临Harvic的博客—倾斜度0.25", 10, 200, paint);
    }

    /**
     * Paint相关设置
     *
     * 普通设置
     paint.setStrokeWidth (5);//设置画笔宽度
     paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
     paint.setStyle(Paint.Style.FILL);//绘图样式，对于设文字和几何图形都有效
     paint.setTextAlign(Align.CENTER);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT
     paint.setTextSize(12);//设置文字大小

     //样式设置
     paint.setFakeBoldText(true);//设置是否为粗体文字
     paint.setUnderlineText(true);//设置下划线
     paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
     paint.setStrikeThruText(true);//设置带有删除线效果

     //其它设置
     paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
     * @param canvas
     */

    /**
     * 绘图样式的区别：
     */
    private void doPaintStyle(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色

        paint.setStrokeWidth(5);//设置画笔宽度
        paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
        paint.setTextSize(50);//设置文字大小

        //绘图样式，设置为填充
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("欢迎光临Harvic的博客—填充", 10, 100, paint);

        //绘图样式设置为描边
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText("欢迎光临Harvic的博客—描边", 10, 200, paint);

        //绘图样式设置为填充且描边
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("欢迎光临Harvic的博客—填充且描边", 10, 300, paint);
    }

    /**
     * 弧形路径
     * void addArc (RectF oval, float startAngle, float sweepAngle)
     * <p>
     * 参数：
     * RectF oval：弧是椭圆的一部分，这个参数就是生成椭圆所对应的矩形；
     * float startAngle：开始的角度，X轴正方向为0度
     * float sweepAngel：持续的度数；
     * 注意：弧形是在椭圆的基础上开始画路径的
     *
     * @param canvas
     */
    private void doArcPath(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        Path path = new Path();
        RectF rect = new RectF(50, 50, 240, 200);
        canvas.drawRect(rect, paint);
        path.addArc(rect, 30, 100);

        canvas.drawPath(path, paint);//画出路径
    }

    /**
     * 椭圆路径
     * <p>
     * void addOval (RectF oval, Path.Direction dir)
     * <p>
     * 参数说明：
     * RectF oval：生成椭圆所对应的矩形
     * Path.Direction :生成方式，与矩形一样，分为顺时针与逆时针，意义完全相同，不再重复
     *
     * @param canvas
     */
    private void doOvalParh(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        Path path = new Path();
        RectF rect = new RectF(50, 50, 240, 200);
        path.addOval(rect, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }

    /**
     * 圆形路径
     * void addCircle (float x, float y, float radius, Path.Direction dir)
     * <p>
     * 参数说明：
     * float x：圆心X轴坐标
     * float y：圆心Y轴坐标
     * float radius：圆半径
     *
     * @param canvas
     */
    private void doCirclePath(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CCW);
        canvas.drawPath(path, paint);
    }

    /**
     * 圆角矩形路径
     * void addRoundRect (RectF rect, float[] radii, Path.Direction dir)
     * void addRoundRect (RectF rect, float rx, float ry, Path.Direction dir)
     * <p>
     * 这里有两个构造函数，部分参数说明如下：
     * 第一个构造函数：可以定制每个角的圆角大小：
     * float[] radii：必须传入8个数值，分四组，分别对应每个角所使用的椭圆的横轴半径和纵轴半径，如｛x1,y1,x2,y2,x3,y3,x4,y4｝，其中，x1,y1对应第一个角的（左上角）用来产生圆角的椭圆的横轴半径和纵轴半径，其它类推……
     * 第二个构造函数：只能构建统一圆角大小
     * float rx：所产生圆角的椭圆的横轴半径；
     * float ry：所产生圆角的椭圆的纵轴半径；
     *
     * @param canvas
     */
    private void doRoundRectPath(Canvas canvas) {

        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        Path path = new Path();
        RectF rect1 = new RectF(50, 50, 240, 200);
        path.addRoundRect(rect1, 10, 15, Path.Direction.CCW);

        RectF rect2 = new RectF(290, 50, 480, 200);
        float radii[] = {10, 15, 20, 25, 30, 35, 40, 45};
        path.addRoundRect(rect2, radii, Path.Direction.CCW);

        canvas.drawPath(path, paint);

    }

    /**
     * 矩形路径
     * void addRect (float left, float top, float right, float bottom, Path.Direction dir)
     * void addRect (RectF rect, Path.Direction dir)
     * <p>
     * 这里Path类创建矩形路径的参数与上篇canvas绘制矩形差不多，唯一不同的一点是增加了Path.Direction参数；
     * Path.Direction有两个值：
     * Path.Direction.CCW：是counter-clockwise缩写，指创建逆时针方向的矩形路径；
     * Path.Direction.CW：是clockwise的缩写，指创建顺时针方向的矩形路径；
     * 问：从效果图中，看不出顺时针生成和逆时针生成的任何区别，怎么会没区别呢？
     * 答：当然没区别啦，无论正时针还是逆时针，仅仅是生成方式不同而已，矩形就那么大画出来的路径矩形当然与矩形一样大了。
     * 问：那生成方式有什么区别呢？
     * 答：生成方式的区别在于，依据生成方向排版的文字！后面我们会讲到文字，文字是可以依据路径排版的，那文字的行走方向就是依据路径的生成方向；
     *
     * @param canvas
     */
    private void doRectPath(Canvas canvas) {
        // 例子1：
//        //先创建两个大小一样的路径
//        //第一个逆向生成
//        paint.setColor(Color.RED);  //设置画笔颜色
//        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
//
//        Path CCWRectpath = new Path();
//        RectF rect1 =  new RectF(50, 50, 240, 200);
//        CCWRectpath.addRect(rect1, Path.Direction.CCW);
//
//        //第二个顺向生成
//        Path CWRectpath = new Path();
//        RectF rect2 =  new RectF(290, 50, 480, 200);
//        CWRectpath.addRect(rect2, Path.Direction.CW);
//
//        //先画出这两个路径
//        canvas.drawPath(CCWRectpath, paint);
//        canvas.drawPath(CWRectpath, paint);

        // 例子2：
        //先创建两个大小一样的路径
        //第一个逆向生成
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        Path CCWRectpath = new Path();
        RectF rect1 = new RectF(50, 50, 240, 200);
        CCWRectpath.addRect(rect1, Path.Direction.CCW);

        //第二个顺向生成
        Path CWRectpath = new Path();
        RectF rect2 = new RectF(290, 50, 480, 200);
        CWRectpath.addRect(rect2, Path.Direction.CW);

        //先画出这两个路径
        canvas.drawPath(CCWRectpath, paint);
        canvas.drawPath(CWRectpath, paint);

        //依据路径写出文字
        String text = "风萧萧兮易水寒，壮士一去兮不复返";
        paint.setColor(Color.GRAY);
        paint.setTextSize(35);
        canvas.drawTextOnPath(text, CCWRectpath, 0, 18, paint);//逆时针生成
        canvas.drawTextOnPath(text, CWRectpath, 0, 18, paint);//顺时针生成
    }

    /**
     * canvas中绘制路径利用：
     * void drawPath (Path path, Paint paint)
     * <p>
     * 1、直线路径
     * <p>
     * void moveTo (float x1, float y1):直线的开始点；即将直线路径的绘制点定在（x1,y1）的位置；
     * void lineTo (float x2, float y2)：直线的结束点，又是下一次绘制直线路径的开始点；lineTo（）可以一直用；
     * void close ():如果连续画了几条直线，但没有形成闭环，调用Close()会将路径首尾点连接起来，形成闭环；
     *
     * @param canvas
     */
    private void doLinePath(Canvas canvas) {
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//填充样式改为描边
        paint.setStrokeWidth(5);//设置画笔宽度

        Path path = new Path();

        path.moveTo(10, 10); //设定起始点
        path.lineTo(10, 100);//第一条直线的终点，也是第二条直线的起点
        path.lineTo(300, 100);//画第二条直线
        path.lineTo(500, 100);//第三条直线
        path.close();//闭环

        canvas.drawPath(path, paint);
    }

    /**
     * 弧
     * 弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；
     * void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
     * <p>
     * 参数：
     * RectF oval:生成椭圆的矩形
     * float startAngle：弧开始的角度，以X轴正方向为0度
     * float sweepAngle：弧持续的角度
     * boolean useCenter:是否有弧的两边，True，还两边，False，只有一条弧
     * <p>
     * （1）将画笔设为描边，效果：
     * 记得 画弧的中心点为矩形的对角线的焦点
     *
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
     *
     * @param canvas
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
     * 参数：
     * RectF rect:要画的矩形
     * float rx:生成圆角的椭圆的X轴半径
     * float ry:生成圆角的椭圆的Y轴半径
     *
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
     * <p>
     * RectF：
     * 构造函数有下面四个，但最常用的还是第二个，根据四个点构造出一个矩形；
     * RectF()
     * RectF(float left, float top, float right, float bottom)
     * RectF(RectF r)
     * RectF(Rect r)
     * <p>
     * Rect
     * 构造函数如下，最常用的也是根据四个点来构造矩形
     * Rect()
     * Rect(int left, int top, int right, int bottom)
     * Rect(Rect r)
     * <p>
     * 6、矩形
     * void drawRect (float left, float top, float right, float bottom, Paint paint)
     * void drawRect (RectF rect, Paint paint)
     * void drawRect (Rect r, Paint paint)
     * 参数：
     * 第一个的写法是直接传入矩形的四个点，画出矩形
     * 第二、三个构造函数是根据传入RectF或者Rect矩形变量来指定所画的矩形的
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

        Rect rect2 = new Rect(230, 10, 320, 100);
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
     * 参数：
     * float cx：圆心点X轴坐标
     * float cy：圆心点Y轴坐标
     * float radius：圆的半径
     *
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
        Arc(8),
        Line_path(9),
        Rect_path(10),
        Roundrect_path(11),
        Circle_path(12),
        Oval_path(13),
        Arc_path(14),
        Paint_style(15),
        Paint_style1(16),
        Paint_style2(17),
        Canvas(18),
        Pos_text(19),
        TextOnPath(20),
        Typeface(21),
        CustomTypeface(22);

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
                case 9:
                    return Line_path;
                case 10:
                    return Rect_path;
                case 11:
                    return Roundrect_path;
                case 12:
                    return Circle_path;
                case 13:
                    return Oval_path;
                case 14:
                    return Arc_path;
                case 15:
                    return Paint_style;
                case 16:
                    return Paint_style1;
                case 17:
                    return Paint_style2;
                case 18:
                    return Canvas;
                case 19:
                    return Pos_text;
                case 20:
                    return TextOnPath;
                case 21:
                    return Typeface;
                case 22:
                    return CustomTypeface;
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
