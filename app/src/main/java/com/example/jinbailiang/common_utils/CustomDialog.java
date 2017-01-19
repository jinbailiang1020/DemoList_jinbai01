package com.example.jinbailiang.common_utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by jinbailiang on 2017-01-18.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {
    private static View contentView;
    private static CustomDialog instance;
    private boolean isClickDismiss;
    private WindowManager.LayoutParams params;

    public static CustomDialog getInstance(Context context, int layoutId) {
        instance = new CustomDialog(context, layoutId);
        return instance;
    }

    public CustomDialog(Context context, int layoutId) {
        super(context);
        contentView = View.inflate(context, layoutId, null);
    }

    public void initLayoutData(InitLayoutInterface initLayoutInterface) {
        initLayoutInterface.initData(contentView);
        if (instance != null) {
            instance.setContentView(contentView);
            instance.getWindow().setGravity(Gravity.CENTER);
            super.setContentView(contentView);
            if (!instance.isShowing()) instance.show();
            if (params != null) {
                instance.getWindow().setAttributes(params);
            }
        }
    }

    public void setWidthAndHeightPercent(double widthPercent, double heigthPercent) {
        try {
            int screenWidth = instance.getWindow().getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽（像素，如：480px）
            int screenHeight = instance.getWindow().getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高（像素，如：800p）
            int dialogWidth;
            int dialogHeigth;
            if (widthPercent <= 1) {
                dialogWidth = (int) (screenWidth * widthPercent);
            } else {
                dialogWidth = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            if (heigthPercent <= 1) {
                dialogHeigth = (int) (screenHeight * heigthPercent);
            } else {
                dialogHeigth = WindowManager.LayoutParams.WRAP_CONTENT;
            }
            params = new WindowManager.LayoutParams(dialogWidth, dialogHeigth
                    , WindowManager.LayoutParams.TYPE_APPLICATION, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.OPAQUE);
//            params.alpha = 0;//这里设置它的透明度为  全透明；0`1
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (isClickDismiss && instance != null) {
            instance.dismiss();
        }
    }


    interface InitLayoutInterface {
        void initData(View contentView);
    }

    public void setIsClickDismiss(Boolean isClickDismiss) {
        this.isClickDismiss = isClickDismiss;
        contentView.setOnClickListener(this);
    }


}
