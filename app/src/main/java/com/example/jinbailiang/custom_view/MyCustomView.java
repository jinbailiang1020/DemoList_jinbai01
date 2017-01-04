package com.example.jinbailiang.custom_view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;


import static android.R.attr.thickness;
import static android.R.attr.width;

/**
 * Created by yess on 2017-01-03.
 * http://blog.csdn.net/aigestudio/article/details/41316141
 */

public class MyCustomView extends View implements Runnable  {

    private Paint paint;
    private Context context;
    private float downX;//ontouchdown事件的x坐标值
    private float downY;//ontouchdown事件的Y坐标值
    private float upX;//ontouchUp事件的x坐标值
    private float upY;//ontouchUp事件的Y坐标值
    private Canvas canvas;
    private int viewHeigth;//mesure后的view高度
    private int viewWidth;//mesure后的view宽度
    private int r;//半径
    private int maxR;//最大半径
    private int originX;//圆心X坐标
    private int originY;//圆心Y坐标
    private double downDistanceToOrigin;//touchdown事件坐标点离远点的距离；
    private double moveDistanceToOrigin;//touchdown事件坐标点离远点的距离；

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initPaint();
    }

    public MyCustomView(Context context) {
        super(context);
        this.context = context;
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);//边界光滑
        paint.setStrokeWidth(10);
        paint.setARGB(0x99, 0x00, 0xcc, 0x00);
        paint.setColor(Color.argb(255, 255, 128, 103));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initData();//必须在onMeasure（）中执行，在这个方法之后才会得出相应view 的长宽，（在onDraw（）中不行）
    }

    /*    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", "dispatchTouchEvent down");
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.i("TAG", "dispatchTouchEvent move");
                return false;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", "dispatchTouchEvent up");
                return false;
        }
        return super.dispatchTouchEvent(event);
    }*/



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getRawX();
                downY = event.getRawY();
               downDistanceToOrigin = Math.sqrt((downX - originX)*(downX - originX) + (downY - originY)*(downY - originY));
                Log.i("TAG", "onTouchEvent down("+downX+","+downY+")");
                return  true;
            case MotionEvent.ACTION_MOVE:
                upX = event.getRawX();
                upY = event.getRawY();
                moveDistanceToOrigin = Math.sqrt((upX - originX)*(upX - originX) + (upY - originY)*(upY - originY));
                Log.i("TAG", "onTouchEvent move("+upX+","+upY+")");
                reSetView();
                return  true;
            case MotionEvent.ACTION_UP:
                Log.i("TAG", "onTouchEvent up");
//               new Thread(this).start();
                return  true;
        }
//        return super.onTouchEvent(event);
        return  false;
    }

    private synchronized void reSetView() {
        double scrollChange = (downDistanceToOrigin - moveDistanceToOrigin)/10;
        r -= scrollChange;
        if(r<0)r=0;
        // 重绘
        Log.i("TAG","new R = "+ r);
       invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        initData();//、、这里执行没有效果？？？  why?
        canvas.drawCircle(originX, originY, r, paint);
    }

    private void initData() {
        viewHeigth = getMeasuredHeight();
        viewWidth = getMeasuredWidth();
        if (viewWidth > viewHeigth) {
            r = viewHeigth / 2;
        } else {
            r = viewWidth / 2;
        }
        maxR = r;
        originX = viewWidth / 2;
        originY =  viewHeigth / 2;
    }

    @Override
    public void run() {
        /*
         * 确保线程不断执行不断刷新界面
         */
        while (true) {
            try {
                /*
                 * 如果半径小于200则自加否则大于200后重置半径值以实现往复
                 */
                if (r > maxR/100) {
                    r -= maxR/100;
                    // 刷新View
                    postInvalidate();
                } else {
                    r = maxR;
                }
                // 每执行一次暂停40毫秒
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
