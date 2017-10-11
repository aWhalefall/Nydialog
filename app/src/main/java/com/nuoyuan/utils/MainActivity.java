package com.nuoyuan.utils;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.nuoyuan.utils.adapter.InnerWaitPayment;
import com.nuoyuan.utils.base.SkinApplication;
import com.nuoyuan.utils.base.SkinBroadCastReceiver;
import com.nuoyuan.utils.changetheme.ISkinUpdate;
import com.nuoyuan.utils.changetheme.SkinPackageManager;
import com.nuoyuan.utils.utils.DialogUtils;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements ISkinUpdate {

    private Button btn_main;
    private Button main_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {
        SkinApplication.getInstance().mActivitys.add(this);
        btn_main = (Button) findViewById(R.id.button);
        main_view = (Button) findViewById(R.id.button1);
    }

    /**
     * 圆角
     *
     * @param view
     */
    public void dialog(View view) {
        DialogUtils.modelOne(this);
    }

    /**
     * 圆角 不吸边
     *
     * @param view
     */
    public void dialog1(View view) {

        DialogUtils.modelTwo(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SkinPackageManager.getInstance(this).mResources != null) {
            updateTheme();
            Log.d("yzy", "onResume-->updateTheme");
        }
    }

    /**
     * list方式
     *
     * @param view
     */
    public void listDialog(View view) {
        ArrayList<InnerWaitPayment> dealList = new ArrayList<>();
        InnerWaitPayment innerWaitPayment = new InnerWaitPayment();
        for (int i = 0; i < 15; i++) {
            try {
                InnerWaitPayment clone = innerWaitPayment.clone();
                clone.Paykey = "ddddd";
                clone.payValue = "dddd" + i;
                dealList.add(clone);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

        }
        DialogUtils.modelThree(this, dealList);
    }

    public void transportdialog(View view) {
        DialogUtils.modelTransportDialog(this);
    }

    public void loading(View view) {
        DialogUtils.loadingDialog(this, View.inflate(this, R.layout.view_progress_layout, null));
    }

    public void callPhone(View view) {
        DialogUtils.showPhoneDialog(this, "400-828-8282");
    }


    //进行主题更新
    @Override
    public void updateTheme() {
        // TODO Auto-generated method stub
        try {
            Resources mResource = SkinPackageManager.getInstance(this).mResources;
            Log.d("ywc", "start and mResource is null-->" + (mResource == null));
            int id1 = mResource.getIdentifier("colorPrimary", "color", "theme.nydialog.com.theme");
            btn_main.setBackgroundColor(mResource.getColor(id1));
            int id2 = mResource.getIdentifier("colorPrimary", "color", "theme.nydialog.com.theme");
            main_view.setBackgroundColor(mResource.getColor(id2));
            //img_skin.setImageDrawable(mResource.getDrawable(mResource.getIdentifier("skin", "drawable","com.skin.plugin")));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            File dir = new File(Environment.getExternalStorageDirectory(), "plugins");
            File skin = new File(dir, "theme.apk");
            if (skin.exists()) {
                SkinPackageManager.getInstance(MainActivity.this).loadSkinAsync(skin.getAbsolutePath(), new SkinPackageManager.loadSkinCallBack() {
                    @Override
                    public void startloadSkin() {
                        Log.d("yzy", "startloadSkin");
                    }

                    @Override
                    public void loadSkinSuccess() {
                        Log.d("yzy", "loadSkinSuccess");
                        MainActivity.this.sendBroadcast(new Intent(SkinBroadCastReceiver.SKIN_ACTION));
                    }

                    @Override
                    public void loadSkinFail() {
                        Log.d("yzy", "loadSkinFail");
                    }
                });
            }

        }

        return true;
    }

}
