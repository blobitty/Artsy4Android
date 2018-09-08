package nyc.c4q.artsy4android.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Fairs;
import nyc.c4q.artsy4android.view.FairsList_ViewHolder;

public class FairsList_Adapter extends RecyclerView.Adapter<FairsList_ViewHolder> {
    List<Fairs> fairsList;

    public FairsList_Adapter(List<Fairs> fairsList){
        this.fairsList = fairsList;
    }

    @Override
    public FairsList_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewChild = LayoutInflater.from(parent.getContext()).inflate(R.layout.fairs_item, parent, false);
        return new FairsList_ViewHolder(viewChild);
    }

    @Override
    public void onBindViewHolder(FairsList_ViewHolder holder, int position) {
        Fairs fairs = fairsList.get(position);
        holder.onBind(fairs);
    }

    @Override
    public int getItemCount() {
        return fairsList.size();
    }
}
