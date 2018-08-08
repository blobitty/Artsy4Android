package nyc.c4q.artsy4android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.model.Artists;

public class Artist_Adapter extends RecyclerView.Adapter<Artist_ViewHolder> {
    List<Artists> artistsList;
    public static final String TAG = "HELP!";

    public Artist_Adapter(List<Artists> artistsList){
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
//        try{
//            return artistsList.size();
//        }catch (NullPointerException e){
//            Log.d(TAG, "YOU HAVE AN EMPTY LIST: " + artistsList.size());
//            return artistsList.size();
//        }
        //TODO: connect to artsy api to populate list
        return 1;
    }
}
