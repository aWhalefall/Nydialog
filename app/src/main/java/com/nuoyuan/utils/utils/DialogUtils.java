package com.nuoyuan.utils.utils;

import android.content.Context;
import android.view.View;

import com.nuoyuan.utils.R;
import com.nuoyuan.utils.adapter.InnerWaitPayment;
import com.nuoyuan.utils.adapter.ListAdapter;

import java.util.ArrayList;


/**
 * Created by weichyang on 2017/9/6.
 */

public class DialogUtils {

    /**
     * 样式1 模板
     *
     * @param activity
     */
    public static void modelOne(Context activity) {

        NyDialog.Builder builder = new NyDialog.Builder(activity);
        builder.setTitle("测试");
        builder.setTitleColor(activity.getResources().getColor(R.color.colorAccent));//标题
        //setContentView(rootView).
        builder.setTextContent("哈哈哈");//内容
        // builder.setContainerBackground(getResources();
        // builder.getColor(R.color.color_d2d2d2));//按钮背影，默认只有一个按钮
        //builder.setBackgroundColor(getResources().getColor(R.color.color_f8f8f8)); //总容器背影，含叉号码
        builder.setBottomDivideColor(R.color.colorAccent);
        builder.setTitleDividerColor(R.color.colorAccent); //分割线颜色， 需要修改

        builder.setTitleVisible(true);

        //builder.setBtnNeutralBackgroundResource(R.drawable.btn_com_buy_selected);
        // builder.setNeutralButtonText("中间");
        //builder.setNeutralButtonVisible(true);

        // 背景色
        builder.setVisibleAreaBackgroundResource(R.drawable.circle_bg); //互斥
        //builder.setVisibleAreaBackgroundColor(getResources().getColor(R.color.main_color_white));

        builder.setBottomViableAreaBackgroundColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setPositiveBtnText("确定");
        builder.setNegativeButtonText("取消");

        //  builder.setBtnNegativeBackgroundResource(R.drawable.btn_com_buy_selected); //shap
        //  builder.setBtnPositiveBackgroundResource(R.drawable.btn_com_buy_selected);

        builder.setPositiveBtnTextColor(activity.getResources().getColor(R.color.text_666666));
        builder.setNegativeButtonTextColor(activity.getResources().getColor(R.color.text_666666));
        builder.setCancelBottomViewVisible(true);

        NyDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 样式2 模板 按钮不吸边
     *
     * @param activity
     */
    public static void modelTwo(Context activity) {
        NyDialog.Builder builder = new NyDialog.Builder(activity);
        builder.
                setTitle("测试").setTitleColor(activity.getResources().getColor(R.color.colorAccent)).//标题
                //setContentView(rootView).
                        setTextContent("哈哈哈").//内容
                // setContainerBackground(getResources().getColor(R.color.color_d2d2d2)).//按钮背影，默认只有一个按钮
                //setBackgroundColor(getResources().getColor(R.color.color_f8f8f8)). //总容器背影，含叉号码
                        setTitleDividerColor(R.color.colorAccent); //分割线颜色， 需要修改

        builder.setTitleVisible(true);

        //builder.setBtnNeutralBackgroundResource(R.drawable.btn_com_buy_selected);
        //builder.setNeutralButtonText("中间");
        //builder.setNeutralButtonVisible(true);

        // 背景色
        builder.setVisibleAreaBackgroundResource(R.drawable.circle_bg); //互斥
//        builder.setVisibleAreaBackgroundColor(getResources().getColor(R.color.main_color_white));
        builder.setmBottomDividerVisiable(View.GONE);
        builder.setBottomViableAreaBackgroundColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setPositiveBtnText("确定");
        builder.setNegativeButtonText("取消");
        builder.setBottomViewPadding(0, 0, 0, 10);
        builder.setBtnNegativeBackgroundResource(R.drawable.btn_com_buy_selected);
        builder.setBtnPositiveBackgroundResource(R.drawable.btn_com_buy_selected);

        builder.setPositiveBtnTextColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setNegativeButtonTextColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setCancelBottomViewVisible(true);

        NyDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * 样式2 模板 按钮不吸边
     *
     * @param activity
     */
    public static void modelThree(Context activity, ArrayList<InnerWaitPayment> dealList) {
        NyDialog.Builder builder = new NyDialog.Builder(activity);
        builder.setTitle("测试");
        builder.setTitleColor(activity.getResources().getColor(R.color.colorAccent));//标题
        builder.setBottomDivideColor(R.color.colorAccent);
        builder.setTitleDividerColor(R.color.colorAccent); //分割线颜色， 需要修改
        ListAdapter listAdapter = new ListAdapter(activity, dealList);
        builder.setListContent(listAdapter);
        builder.setTitleVisible(true);
        builder.setBottomViewPadding(0, 10, 0, 10);
        builder.setVisibleAreaBackgroundColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setBottomViableAreaBackgroundColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setPositiveBtnText("确定");
        builder.setNegativeButtonText("取消");
        builder.setBtnNegativeBackgroundResource(R.drawable.btn_com_buy_selected); //shap
        builder.setBtnPositiveBackgroundResource(R.drawable.btn_com_buy_selected);
        builder.setPositiveBtnTextColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setNegativeButtonTextColor(activity.getResources().getColor(R.color.main_color_white));
        builder.setCancelBottomViewVisible(false);
        NyDialog dialog = builder.create();
        dialog.show();
    }
}
