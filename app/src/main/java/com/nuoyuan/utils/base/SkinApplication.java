package com.nuoyuan.utils.base;

import android.app.Application;
import android.text.TextUtils;

import com.nuoyuan.utils.changetheme.ISkinUpdate;
import com.nuoyuan.utils.changetheme.SkinPackageManager;

import java.util.ArrayList;

public class SkinApplication extends Application {

    private static SkinApplication mInstance = null;
    public ArrayList<ISkinUpdate> mActivitys = new ArrayList();

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub  
        super.onCreate();
        mInstance = this;
        String skinPath = SkinConfig.getInstance(this).getSkinResourcePath();
        if (!TextUtils.isEmpty(skinPath)) {
            //如果已经换皮肤，那么第二次进来时，需要加载该皮肤
            //onResume( )中进行更新
            SkinPackageManager.getInstance(this).loadSkinAsync(skinPath, null);
        }
        SkinBroadCastReceiver.registerBroadCastReceiver(this);
    }

    public static SkinApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub  
        SkinBroadCastReceiver.unregisterBroadCastReceiver(this);
        super.onTerminate();
    }

    public void changeSkin() {
        for (ISkinUpdate skin : mActivitys) {
            skin.updateTheme();
        }
    }
}