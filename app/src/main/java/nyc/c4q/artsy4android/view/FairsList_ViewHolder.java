package nyc.c4q.artsy4android.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Fairs;

public class FairsList_ViewHolder extends RecyclerView.ViewHolder{
    Button fairsButton;

    public FairsList_ViewHolder(View itemView) {
        super(itemView);

        fairsButton = itemView.findViewById(R.id.fair_button);
    }

    public void onBind(Fairs fairs){
        fairsButton.setText(fairs.getName());
    }
}
