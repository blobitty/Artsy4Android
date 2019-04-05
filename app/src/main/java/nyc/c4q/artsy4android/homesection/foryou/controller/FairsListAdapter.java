package nyc.c4q.artsy4android.homesection.foryou.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Fairs;
import nyc.c4q.artsy4android.homesection.foryou.viewholder.FairsListViewHolder;

public class FairsListAdapter extends RecyclerView.Adapter<FairsListViewHolder> {
    List<Fairs> fairsList;

    public FairsListAdapter(List<Fairs> fairsList){
        this.fairsList = fairsList;
    }

    @Override
    public FairsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewChild = LayoutInflater.from(parent.getContext()).inflate(R.layout.fairs_item, parent, false);
        return new FairsListViewHolder(viewChild);
    }

    @Override
    public void onBindViewHolder(FairsListViewHolder holder, int position) {
        Fairs fairs = fairsList.get(position);
        holder.onBind(fairs);
    }

    @Override
    public int getItemCount() {
        return fairsList.size();
    }
}
