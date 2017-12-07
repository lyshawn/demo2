package com.example.a9splay_user.demo2;

import android.app.Application;

import com.niceplay.authclient_three.NPPlayGameSDK;

/**
 * Created by 9splay_user on 2017/12/6.
 */

public class MyApplication extends Application {

    private String appid = "DEMO";

    private String apikey = "daf964f8d22c46d7ce4fb15a555aeece";


    @Override
    public void onCreate() {

        super.onCreate();

        NPPlayGameSDK.setSSL(true);

        NPPlayGameSDK.getInstance().initPlayGameServices(this, appid, apikey,NPPlayGameSDK.ZH_TW, "com.example.a9splay_user.demo2.MainActivity");

        //NPPlayGameSDK.getInstance().initPlayGameServices(this, appid, apikey , language);

        //NPPlayGameSDK.getInstance().initPlayGameServices(this, appid, apikey , MainActivityFullPath);

        //NPPlayGameSDK.getInstance().initPlayGameServices(this, appid, apikey , language , MainActivityFullPath);

    }
}
