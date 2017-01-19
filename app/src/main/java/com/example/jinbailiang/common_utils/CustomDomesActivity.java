package com.example.jinbailiang.common_utils;

import android.app.Activity;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinbailiang.demos_jinbai.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.facebook.fresco.helper.utils.DensityUtil;

public class CustomDomesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_domes);


        findViewById(R.id.btn_showCustomDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = CustomDialog.getInstance(CustomDomesActivity.this, R.layout.dialog_custom_demos_item);
                customDialog.initLayoutData(new CustomDialog.InitLayoutInterface() {
                    @Override
                    public void initData(View contentView) {
                        SimpleDraweeView iv_thumbnail = (SimpleDraweeView) contentView.findViewById(R.id.simpleDraweeView);
                        ViewGroup.LayoutParams lvp = iv_thumbnail.getLayoutParams();
                        lvp.width = DensityUtil.getDisplayWidth(CustomDomesActivity.this);
                        iv_thumbnail.setAspectRatio(0.6f); // 设置宽高比
                        ImageLoader.loadDrawable(iv_thumbnail, R.drawable.meizi,
                                DensityUtil.getDisplayWidth(CustomDomesActivity.this), DensityUtil.getDisplayHeight(CustomDomesActivity.this));
                    }
                });
            }
        });
    }
}
