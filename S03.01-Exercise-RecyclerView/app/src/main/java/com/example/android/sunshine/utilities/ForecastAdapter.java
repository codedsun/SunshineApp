package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

/**
 * Created by suneetsrivastava on 21/02/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    public String[] mWeatherData;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mWeatherTextView.setText(position+"");
    }

    @Override
    public int getItemCount() {
        if(mWeatherData == null)
        return 0;
        else
            return mWeatherData.length;
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView mWeatherTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }


    }
    public  void setWeatherData(String[] weatherData){
        mWeatherData = weatherData;

    }
}
