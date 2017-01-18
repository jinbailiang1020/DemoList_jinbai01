package com.example.jinbailiang.factory_pattern;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jinbailiang on 2017-01-18.
 */

public class OKHTTPManager implements  HTTPManager {


    @Override
    public void get(Context context) {
        Toast.makeText(context,"OKHTTPManager.get()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void post(Context context) {
        Toast.makeText(context,"OKHTTPManager.post()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void put(Context context) {
        Toast.makeText(context,"OKHTTPManager.put()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delete(Context context) {
        Toast.makeText(context,"OKHTTPManager.delete()",Toast.LENGTH_SHORT).show();
    }
}
