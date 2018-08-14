package nyc.c4q.artsy4android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.model.Artists;
import nyc.c4q.artsy4android.model.artistslist.ArtistsList;
import nyc.c4q.artsy4android.view.Artist_ViewHolder;

public class ArtistsList_Adapter extends RecyclerView.Adapter<Artist_ViewHolder> {
    List<Artists> artistsList;
    public static final String TAG = "HELP!";

    public ArtistsList_Adapter(List<Artists> artistsList){
        this.artistsList = artistsList;
    }

    @Override
    public Artist_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.artistsfragment_item, parent, false);

        return new Artist_ViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(Artist_ViewHolder holder, int position) {
        Artists artists = artistsList.get(position);

        holder.onBind(artists);
    }

    @Override
    public int getItemCount() {
        return artistsList.size();
    }
}
