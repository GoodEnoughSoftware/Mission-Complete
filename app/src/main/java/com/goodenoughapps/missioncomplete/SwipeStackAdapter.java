package com.goodenoughapps.missioncomplete;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.goodenoughapps.missioncomplete.R;

import java.util.List;

/**
 * Created by tejpatel on 1/10/17.
 */

public class SwipeStackAdapter extends BaseAdapter {

    private List<String> mData;

    public SwipeStackAdapter(List<String> data) {
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = getLayoutInflater().inflate(R.layout.card, parent, false);
        TextView textViewCard = (TextView) convertView.findViewById(R.id.textViewCard);
        textViewCard.setText(mData.get(position));

        return convertView;
    }
}
