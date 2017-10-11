package com.nuoyuan.utils.base;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by weichyang on 2017/10/11.
 * 获取皮肤地址
 */

public class SkinConfig {

    private static Context context;

     private static SkinConfig mInstance=null;

    private String skinResourcePath="";

    private SkinConfig(Context mContext)
    {
        this.context=mContext;
    }

    public static SkinConfig getInstance(Context mContext)
    {
        context=mContext;
        if(mInstance==null)
        {
            mInstance=new SkinConfig(mContext);
        }
        return mInstance;
    }


    public String getSkinResourcePath() {
        SharedPreferences sp =context.getSharedPreferences("pathfile", MODE_PRIVATE);
        return sp.getString("path", "");
    }


    public void setSkinResourcePath(String skinResourcePath) {
        this.skinResourcePath = skinResourcePath;

        if(context!=null){
            SharedPreferences sp =context.getSharedPreferences("pathfile", MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("path",skinResourcePath);
            editor.commit();
        }

    }
}
