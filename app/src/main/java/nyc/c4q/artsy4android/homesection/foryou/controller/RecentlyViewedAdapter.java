package nyc.c4q.artsy4android.homesection.foryou.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.homesection.foryou.viewholder.RecentlyViewedViewHolder;
import nyc.c4q.artsy4android.models.RecentlyViewed;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedViewHolder> {

    List<RecentlyViewed> recentlyViewedList;

    public RecentlyViewedAdapter(List<RecentlyViewed> recentlyViewedList){
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
