package com.example.jinbailiang.dispatch_event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.jinbailiang.demos_jinbai.R;

/**
 * Created by yess on 2017-01-04.
 */

public class DispatchEventTestFragment02 extends Fragment {

    private MyLinearLayout layout;
    private TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.fragment_blank_fragment02,null);
        initView(v);
        return v;
    }

    private void initView(View v) {
        layout = (MyLinearLayout)v.findViewById(R.id.framLayout);
        textView = (TextView)v.findViewById(R.id.textView);
        textView.setOnTouchListener(new View.OnTouchListener() {
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

                return true;
            }
    });

}
}