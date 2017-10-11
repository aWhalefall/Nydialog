package com.nuoyuan.utils.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by weichyang on 2017/10/11.
 *
 */

public class SkinBroadCastReceiver extends BroadcastReceiver {

    public static final String SKIN_ACTION = "com.change.theme";
    public  static SkinBroadCastReceiver skinBroadCastReceiver=new SkinBroadCastReceiver();

    public static void registerBroadCastReceiver(Context context) {
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(SKIN_ACTION);
        context.registerReceiver(skinBroadCastReceiver, mFilter);
    }

    public static void unregisterBroadCastReceiver(Context context) {
         context.unregisterReceiver(skinBroadCastReceiver);
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(SkinBroadCastReceiver.SKIN_ACTION)){
            SkinApplication.getInstance().changeSkin();
        }

    }


}
