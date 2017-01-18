package com.example.jinbailiang.factory_pattern;

import android.content.Context;

/**
 * Created by yess on 2017-01-18.
 */

public interface HTTPManager {
    public void get(Context context);
    public void post(Context context);
    public void put(Context context);
    public void delete(Context context);


}
