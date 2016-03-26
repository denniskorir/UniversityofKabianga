package com.university.kabianga.universityofkabianga;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Korir on 12/11/2015.
 */
public class CustomAdapter extends BaseAdapter {


    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public CustomAdapter(Context mContext, String[] web, int[] imageid) {
        this.mContext = mContext;
        this.web = web;
        Imageid = imageid;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.dashboard_grid_content, null);
            TextView textView = (TextView) grid.findViewById(R.id.txtDashlable);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imgdash);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
