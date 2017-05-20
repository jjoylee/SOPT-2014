package com.example.joylee.sopt_5week;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by JoyLee on 2017-05-06.
 */

public class ApplicationController extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "NanumBarunGothicBold.ttf"))
                .addBold(Typekit.createFromAsset(this,"NanumBarunGothic.ttf"))
                .addCustom1(Typekit.createFromAsset(this,"NanumMyeongjo.ttc"))
                .addCustom2(Typekit.createFromAsset(this,"NanumMyeongjoExtraBold.ttf"));
    }
}
