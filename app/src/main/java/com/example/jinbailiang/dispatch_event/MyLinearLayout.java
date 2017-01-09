package com.example.jinbailiang.dispatch_event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by yess on 2017-01-04.
 */

public class MyLinearLayout extends LinearLayout {


    public MyLinearLayout(Context context) {
        super(context);
    }
    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.i("DispatchEvent","dispatchTouchEvent ACTION_DOWN");
//                return  true;//不执行onTouchEvent down
                break;
            case MotionEvent.ACTION_MOVE:

                Log.i("DispatchEvent","dispatchTouchEvent ACTION_MOVE");
                return  true;//在这里消费掉move事件，不传递给viewPager滑动；？//无效
//                break;
            case MotionEvent.ACTION_UP:
                Log.i("DispatchEvent","dispatchTouchEvent ACTION_UP");
                break;

        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.i("DispatchEvent","onInterceptTouchEvent ACTION_DOWN");
                break;
//            return  true;//在这里消费掉move事件，不传递给viewPager滑动；？无效！
            case MotionEvent.ACTION_MOVE:
                Log.i("DispatchEvent","onInterceptTouchEvent ACTION_MOVE");
                return  true;//在这里消费掉move事件，不传递给viewPager滑动；？无效！
//                break;
            case MotionEvent.ACTION_UP:
                Log.i("DispatchEvent","onInterceptTouchEvent ACTION_UP");
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

/*    @Override
    public void setOnTouchListener(OnTouchListener l) {
        l = new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        Log.i("DispatchEvent","setOnTouchListener ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("DispatchEvent","setOnTouchListener ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("DispatchEvent","setOnTouchListener ACTION_UP");
                        break;
                }

                return false;
            }
        };
        super.setOnTouchListener(l);
    }*/


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                Log.i("DispatchEvent","onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("DispatchEvent","onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("DispatchEvent","onTouchEvent ACTION_UP");
                break;

        }
        return super.onTouchEvent(event);
    }
}
