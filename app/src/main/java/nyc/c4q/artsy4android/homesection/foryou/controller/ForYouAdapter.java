package nyc.c4q.artsy4android.homesection.foryou.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.homesection.foryou.viewholder.ForYouViewHolder;
import nyc.c4q.artsy4android.models.Artwork;

public class ForYouAdapter extends RecyclerView.Adapter<ForYouViewHolder> {

    List<Artwork> artworkList;
    public static final String TAG = "HELP!";


    public ForYouAdapter(List<Artwork> artworkList) {
        this.artworkList = artworkList;

    }

    @NonNull
    @Override
    public ForYouViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_artwork, parent, false);

        return new ForYouViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ForYouViewHolder holder, int position) {
        Artwork artwork = artworkList.get(position);

        holder.onBind(artwork);
    }

    @Override
    public int getItemCount() {
        return artworkList.size();
    }
}