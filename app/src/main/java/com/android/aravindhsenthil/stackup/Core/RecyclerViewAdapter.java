package com.android.aravindhsenthil.stackup.Core;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.aravindhsenthil.stackup.R;

import java.util.ArrayList;

/**
 * Created by Aravindh senthil on 6/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder> {

    public RecyclerViewAdapter(ArrayList<ListBean> mListBeen, OnClickInterface onClickInterface) {
        this.mListBeen = mListBeen;
        this.mOnClickInterface = onClickInterface;

    }

    private ArrayList<ListBean> mListBeen;
    private OnClickInterface mOnClickInterface;

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView title, name;
        private ImageView image;

        private ListViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_row, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {
        holder.title.setText(mListBeen.get(position).getmTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickInterface.Click(position, v);
            }
        });
//        holder.image.setText(movie.getGenre());
        holder.name.setText(mListBeen.get(position).getmName());
    }

    @Override
    public int getItemCount() {
        return mListBeen.size();
    }
}
