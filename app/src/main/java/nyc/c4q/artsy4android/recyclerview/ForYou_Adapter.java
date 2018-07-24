package nyc.c4q.artsy4android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;

public class ForYou_Adapter extends RecyclerView.Adapter<ForYou_ViewHolder> {
    List<ForYou_Model> forYouList;

    ForYou_Adapter(List<ForYou_Model>forYouList){
        this.forYouList = forYouList;
    }

    @Override
    public ForYou_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_for_you_, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(ForYou_ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
