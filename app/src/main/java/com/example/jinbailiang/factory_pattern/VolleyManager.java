package com.example.jinbailiang.factory_pattern;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yess on 2017-01-18.
 */

public class VolleyManager implements HTTPManager {

    @Override
    public void get(Context context) {
        Toast.makeText(context,"VolleyManager.get()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void post(Context context) {
        Toast.makeText(context,"VolleyManager.post()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void put(Context context) {
        Toast.makeText(context,"VolleyManager.put()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void delete(Context context) {
        Toast.makeText(context,"VolleyManager.delete()",Toast.LENGTH_SHORT).show();
    }
}
