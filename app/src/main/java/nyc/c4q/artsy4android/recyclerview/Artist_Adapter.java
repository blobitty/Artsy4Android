package nyc.c4q.artsy4android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.model.Artist;

public class Artist_Adapter extends RecyclerView.Adapter<Artist_ViewHolder> {
    List<Artist> artistList;

    Artist_Adapter(List<Artist> artistList){
        this.artistList = artistList;
    }

    @Override
    public Artist_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_artist_, parent, false);

        return new Artist_ViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(Artist_ViewHolder holder, int position) {
        Artist artist = artistList.get(position);

        holder.onBind(artist);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }
}
