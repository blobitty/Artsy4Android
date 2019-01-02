package nyc.c4q.artsy4android.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Fairs;

public class FairsListViewHolder extends RecyclerView.ViewHolder{
    Button fairsButton;

    public FairsListViewHolder(View itemView) {
        super(itemView);

        fairsButton = itemView.findViewById(R.id.fair_button);
    }
    //set text for fairs recyclerview items in the 'ForYouFragment"
    public void onBind(Fairs fairs){
        fairsButton.setText(fairs.getName());
    }
}
