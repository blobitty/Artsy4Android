package nyc.c4q.artsy4android.homesection.foryou.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Artwork;

import static nyc.c4q.artsy4android.homesection.artistslist.controller.ArtistsListAdapter.TAG;


public class TrendingArtworkViewHolder extends RecyclerView.ViewHolder {

    private ImageView artworkIMG;
    private TextView artworkTitle;
    private ImageButton likeButton;

    //constructor
    public TrendingArtworkViewHolder(View itemView) {
        super(itemView);

        artworkIMG = itemView.findViewById(R.id.trending_artwork_img);
        artworkTitle = itemView.findViewById(R.id.artwork_title);
        likeButton = itemView.findViewById(R.id.favorite_artwork_button);
    }

    public void onBind(Artwork artwork){

        setArtworkImage(artwork);
        artworkTitle.setText(artwork.getTitle());
        //TODO: When Like Button is pressed change color 5/10/19.

    }

    public void setArtworkImage(Artwork artwork){
        if(artwork.get_links().getThumbnail().getHref().isEmpty()){
            String artWorkImage_URL = artwork.get_links().getThumbnail().getHref();

            Picasso.get()
                    .load(artWorkImage_URL)
                    .into(artworkIMG);
            Log.d(TAG, "Thumbnail Image: " + artWorkImage_URL);

        }

    }
}
