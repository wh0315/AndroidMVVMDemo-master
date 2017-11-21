package io.github.xuyushi.androidmvvmdemo.RecycleDemo;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.github.xuyushi.androidmvvmdemo.R;
import io.github.xuyushi.androidmvvmdemo.databinding.ItemRecycleBinding;

/**
 * Created by xuyushi on 16/3/6.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    public static final String TAG = "NewsAdapter";

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;
    private List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public interface OnItemClickListener {
        void onItemClick(final int id, final News news);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRecycleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_recycle, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.binding.setNews(newsList.get(position));
        holder.binding.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: item" + position);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position, newsList.get(position));
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemRecycleBinding binding;

        MyViewHolder(final ItemRecycleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
