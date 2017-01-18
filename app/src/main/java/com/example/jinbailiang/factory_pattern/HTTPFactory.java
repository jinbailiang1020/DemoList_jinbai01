package com.example.jinbailiang.factory_pattern;

/**
 * Created by yess on 2017-01-18.
 */

public class HTTPFactory {
    public static HTTPManager getHTTPManager(){
//        return new OKHTTPManager();
        return new VolleyManager();
    }

}
