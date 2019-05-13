package nyc.c4q.artsy4android.homesection.foryou.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.RecentlyViewed;

public class RecentlyViewedViewHolder extends RecyclerView.ViewHolder {

    private TextView artistName, artworkTitle, cntyBirth;
    private Button followButton;
    private ImageView recentlyViewedIMG;


    //constructor
    public RecentlyViewedViewHolder(View itemView) {
        super(itemView);

        artistName = itemView.findViewById(R.id.artist_name);
        artworkTitle = itemView.findViewById(R.id.artwork_title);
        cntyBirth = itemView.findViewById(R.id.cntry_birthyear);
        followButton = itemView.findViewById(R.id.follow_artist_button);
        recentlyViewedIMG = itemView.findViewById(R.id.recviewed_image);

    }



    public void onBind(RecentlyViewed recentlyViewed){
        artistName.setText(recentlyViewed.getArtistName());
        artworkTitle.setText(recentlyViewed.getArtworkName());

        cntyBirth.setText(concatDetails(
                recentlyViewed.getArtistCountry(),
                recentlyViewed.getBirthYear()));

        bindImage(recentlyViewedIMG, recentlyViewed);
        switchButtonUI(followButton);
    }

    void bindImage(ImageView img, RecentlyViewed recentlyViewed){
        Picasso.get()
                .load(recentlyViewed.getArtistImageURl())
                .into(img);
    }

    void switchButtonUI(Button btn){
        //TODO: Create image/xml for button states

    }

    String concatDetails(String str1, String str2){
        return str1.concat(",").concat(" ").concat(str2);
    }
}
