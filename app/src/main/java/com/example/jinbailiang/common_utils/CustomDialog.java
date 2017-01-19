package com.example.jinbailiang.common_utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * Created by jinbailiang on 2017-01-18.
 */

public class CustomDialog extends Dialog implements View.OnClickListener {
    private static View contentView;
    private static CustomDialog instance;
    private boolean isClickDismiss;

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
            instance.show();
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
