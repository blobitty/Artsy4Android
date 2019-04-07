package nyc.c4q.artsy4android.homesection.artistslist.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.homesection.artistslist.viewholder.ArtistsListViewHolder;

public class ArtistsListAdapter extends RecyclerView.Adapter<ArtistsListViewHolder> {
    List<Artist> artistsList;
    public static final String TAG = "HELP!";

    public ArtistsListAdapter(List<Artist> artistsList){
        this.artistsList = artistsList;
    }

    @Override
    public ArtistsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.artistsfragment_item, parent, false);

        return new ArtistsListViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ArtistsListViewHolder holder, int position) {
        Artist artists = artistsList.get(position);

        holder.onBind(artists);
    }

    @Override
    public int getItemCount() {
        return artistsList.size();
    }
}
