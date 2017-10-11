package com.nuoyuan.utils.changetheme;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;

import com.nuoyuan.utils.base.SkinConfig;

import java.lang.reflect.Method;

/**
 * 解析皮肤资源包 
 * com.skin.demo.SkinPackageManager 
 * @author yuanzeyao <br/> 
 * create at 2015年1月3日 下午3:24:16 
 */  
public class SkinPackageManager   
{  
  private static SkinPackageManager mInstance;  
  private Context mContext;
  /** 
   * 当前资源包名 
   */  
  public String mPackageName;  
    
  /** 
   * 皮肤资源 
   */  
  public Resources mResources;
    
  private SkinPackageManager(Context mContext)  
  {  
    this.mContext=mContext;  
  }  
    
  public static SkinPackageManager getInstance(Context mContext)  
  {  
    if(mInstance==null)  
    {  
      mInstance=new SkinPackageManager(mContext);  
    }  
      
    return mInstance;  
  }  
    
    
  /** 
   * 异步加载皮肤资源 
   * @param dexPath 
   *        需要加载的皮肤资源 
   * @param callback 
   *        回调接口 
   */  
  public void loadSkinAsync(String dexPath,final loadSkinCallBack callback)  
  {  
    new AsyncTask<String,Void,Resources>()
    {  
  
      protected void onPreExecute()   
      {  
        if(callback!=null)  
        {  
          callback.startloadSkin();  
        }  
      };  
     
      @Override  
      protected Resources doInBackground(String... params)   
      {  
        try {  
          if(params.length==1)  
          {  
            String dexPath_tmp=params[0];  
            PackageManager mPm=mContext.getPackageManager();
            PackageInfo mInfo=mPm.getPackageArchiveInfo(dexPath_tmp,PackageManager.GET_ACTIVITIES);
            mPackageName=mInfo.packageName;  
              
              
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, dexPath_tmp);  
              
            Resources superRes = mContext.getResources();  
            Resources skinResource=new Resources(assetManager, superRes.getDisplayMetrics(), superRes.getConfiguration());  
            SkinConfig.getInstance(mContext).setSkinResourcePath(dexPath_tmp);
            return skinResource;  
          }  
          return null;  
        } catch (Exception e) {  
          return null;  
        }   
          
      };  
        
      protected void onPostExecute(Resources result)   
      {  
        mResources=result;  
         
        if(callback!=null)  
        {  
          if(mResources!=null)  
          {  
            callback.loadSkinSuccess();  
          }else  
          {  
            callback.loadSkinFail();  
          }  
        }  
      };  
        
    }.execute(dexPath);  
  }  
    
  /** 
   * 加载资源的回调接口 
   * com.skin.demo.loadSkinCallBack 
   * @author yuanzeyao <br/> 
   * create at 2015年1月4日 下午1:45:48 
   */  
  public static interface loadSkinCallBack  
  {  
    public void startloadSkin();  
      
    public void loadSkinSuccess();  
      
    public void loadSkinFail();  
  }  
    
    
   
}  