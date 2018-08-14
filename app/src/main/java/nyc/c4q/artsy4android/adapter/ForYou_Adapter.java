package nyc.c4q.artsy4android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;

/**
 * needs model to hold data from Artsy API
 */

//_Adapter extends RecyclerView.Adapter<ForYou_ViewHolder> {
//    List<ForYou> forYouList;
//
//    ForYou_Adapter(List<ForYou>forYouList){
//        this.forYouList = forYouList;
//    }
//
//    @Override
//    public ForYou_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_for_you_, parent, false);
//
//        return new ForYou_ViewHolder(childView);
//    }
//
//    @Override
//    public void onBindViewHolder(ForYou_ViewHolder holder, int position) {
//        ForYou forYou = forYouList.get(position);
//        holder.onBind(forYou);
//    }
//
//    @Override
//    public int getItemCount() {
//        return forYouList.size();
//    }
//}
