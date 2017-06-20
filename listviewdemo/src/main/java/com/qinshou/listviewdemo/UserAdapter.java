package com.qinshou.listviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Description:
 * Created on 2017/6/20
 */
public class UserAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> data = new ArrayList<>();

    public UserAdapter(Context context, ArrayList<User> data) {
        mContext = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_user, null);
            holder = new ViewHolder();
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvNumber = (TextView) convertView.findViewById(R.id.tvNumber);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.iv.setBackgroundResource(data.get(position).res);
        holder.tvName.setText(data.get(position).name);
        holder.tvNumber.setText(data.get(position).number);


        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView tvName, tvNumber;
    }
}
