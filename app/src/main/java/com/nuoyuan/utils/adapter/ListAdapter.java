package com.nuoyuan.utils.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.nuoyuan.utils.R;

import java.util.ArrayList;

/**
 * Created by RoryHe on 2017/8/8.
 */
public class ListAdapter extends BaseAdapter {
    private ArrayList<InnerWaitPayment> data;
    private Context context;


    public ListAdapter(Context activity, ArrayList<InnerWaitPayment> dealList) {
        this.context = activity;
        this.data = dealList;
    }

    @Override
    public int getCount() {
        if (data != null) return data.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (data != null) return data.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rootView = View.inflate(context, R.layout.dialog_quit_login, null);
        InnerWaitPayment innerWaitPayment = data.get(position);
        TextView textView = (TextView) rootView.findViewById(R.id.tv_dialog_title);
        textView.setText(innerWaitPayment.payValue);
        return rootView;
    }
}
