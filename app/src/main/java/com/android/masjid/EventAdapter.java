package com.android.masjid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hanani on 2/3/2016.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item
    public class ViewHolder extends RecyclerView.ViewHolder{

        public CardView cardView;
        public TextView tvTitle;
        public TextView tvDate;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView)v.findViewById(R.id.cardView);
            tvTitle = (TextView) v.findViewById(R.id.tvTitle);
            tvDate = (TextView) v.findViewById(R.id.tvDate);
        }
    }

    List<Event> events;
    Context context;

    EventAdapter(List<Event> events, Context context){
        this.events = events;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvTitle.setText(events.get(position).title);
        holder.tvDate.setText(events.get(position).date);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventActivity.class);
                intent.putExtra(EventActivity.TITLE, events.get(position).title);
                intent.putExtra(EventActivity.DATE, events.get(position).date);
                intent.putExtra(EventActivity.SPEAKER, events.get(position).speaker);
                intent.putExtra(EventActivity.TIME, events.get(position).time);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

//    public void add(int position, String item) {
//        mDataset.add(position, item);
//        notifyItemInserted(position);
//    }
//
//    public void remove(String item) {
//        int position = mDataset.indexOf(item);
//        mDataset.remove(position);
//        notifyItemRemoved(position);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        final String name = mDataset.get(position);
//        holder.tvTitle.setText(mDataset.get(position));
//        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                remove(name);
//            }
//        });
//    }
}
