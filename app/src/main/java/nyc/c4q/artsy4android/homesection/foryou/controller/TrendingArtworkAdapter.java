package nyc.c4q.artsy4android.homesection.foryou.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.homesection.foryou.viewholder.TrendingArtworkViewHolder;
import nyc.c4q.artsy4android.models.Artwork;

public class TrendingArtworkAdapter extends RecyclerView.Adapter<TrendingArtworkViewHolder> {

    private List<Artwork> artworksList;
    public static final String TAG = "HELP!";


    public TrendingArtworkAdapter(List<Artwork> artworksList) {
        this.artworksList = artworksList;

    }

    @NonNull
    @Override
    public TrendingArtworkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_artwork, parent, false);

        return new TrendingArtworkViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingArtworkViewHolder holder, int position) {
        Artwork artwork = this.artworksList.get(position);

        holder.onBind(artwork);
    }

    @Override
    public int getItemCount() {
        return artworksList.size();
    }
}