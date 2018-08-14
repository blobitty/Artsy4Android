package nyc.c4q.artsy4android.view;

        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import de.hdodenhof.circleimageview.CircleImageView;
        import nyc.c4q.artsy4android.R;
        import nyc.c4q.artsy4android.model.Artists;
        import nyc.c4q.artsy4android.model.artistslist.ArtistsList;

        import static nyc.c4q.artsy4android.adapter.ArtistsList_Adapter.TAG;

public class Artist_ViewHolder extends RecyclerView.ViewHolder{
    CircleImageView artistImage;
    TextView artistName;
    TextView artistNationality;
    ImageView artImageOne;
    ImageView artImageTwo;
    String imageOne_URL, imageTwo_URL, artistImage_URL, artistID;




    public Artist_ViewHolder(View itemView) {
        super(itemView);
        artistImage = itemView.findViewById(R.id.artist_profile_img);
        artistName = itemView.findViewById(R.id.artist_name);
        artistNationality = itemView.findViewById(R.id.artistNationality);
        artImageOne = itemView.findViewById(R.id.artImageOne);
        artImageTwo = itemView.findViewById(R.id.artImageTwo);
    }

    public void onBind(Artists artists) {
        artistName.setText(artists.getName());
        artistNationality.setText(artists.getNationality());
        artistID = artists.getId();
        //load and set itemView images
        setImages(artists);
    }

    public void setImages(Artists artists){
        //load and set artist Image
        if(!artists.getLinks().getThumbnail().getHref().isEmpty()){
            artistImage_URL = artists.getLinks().getThumbnail().getHref();

            Picasso.get()
                    .load(artistImage_URL)
                    .into(artistImage);
            Log.d(TAG, "onBind: " + artistImage_URL);
        }
        //load and set artworkOne
        if(!artists.getLinks().getArtworks().isEmpty()){
            imageOne_URL = artists.getLinks().getArtworks().get(0).get_links().getImage().getHref();

            Picasso.get()
                    .load(imageOne_URL)
                    .into(artImageOne);
            Log.d(TAG, "onBind: " + imageOne_URL);
        }
        //load and set artWorkTwo
        if (artists.getLinks().getArtworks().size() > 1){
            imageTwo_URL = artists.getLinks().getArtworks().get(1).get_links().getImage().getHref();

            Picasso.get()
                    .load(imageTwo_URL)
                    .into(artImageTwo);
        }
    }
}

