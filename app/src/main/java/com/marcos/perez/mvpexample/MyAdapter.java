package com.marcos.perez.mvpexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marcos.perez.mvpexample.DataModels.JourneySummary;

import java.util.List;

/**
 * Created by Joan Manel on 15/10/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<JourneySummary> values;

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.activity_travel_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        final JourneySummary trayecto =  values.get(position);
        //holder.travelDuration.setText(String.valueOf(trayecto.getTimeElapsed()));
        holder.travelDistance.setText(String.valueOf(trayecto.getDistanceTraveled()));
        holder.travelPoints.setText(trayecto.getScore());

    }

    @Override
    public int getItemCount() {
        return this.values.size();
    }

    public MyAdapter(List<JourneySummary> myDataset) {
        values = myDataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView travelDistance;
        public TextView travelDuration;
        public TextView travelPoints;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            travelDistance = (TextView) v.findViewById(R.id.distance);
            travelDuration = (TextView) v.findViewById(R.id.duration);
            travelPoints = (TextView) v.findViewById(R.id.points);
        }
    }
}
