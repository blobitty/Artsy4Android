package nyc.c4q.artsy4android.view;

        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import de.hdodenhof.circleimageview.CircleImageView;
        import nyc.c4q.artsy4android.R;
        import nyc.c4q.artsy4android.models.Artists;
        import nyc.c4q.artsy4android.models.Artworks;
        import nyc.c4q.artsy4android.network.Retrofit_Instance;
        import retrofit2.Retrofit;

        import static nyc.c4q.artsy4android.adapter.ArtistsList_Adapter.TAG;

public class Artist_ViewHolder extends RecyclerView.ViewHolder{
    CircleImageView artistImage;
    TextView artistName;
    TextView artistNationality;
    ImageView artImageOne;
    ImageView artImageTwo;
    Artworks artworks;
    String imageOne_URL, imageTwo_URL, artistImage_URL, artistID;
    Retrofit_Instance retroInstance;
    Retrofit retrofit;
    String xapptoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6IiIsImV4cCI6MTUzNDg3NjEzMywiaWF0IjoxNTM0MjcxMzMzLCJhdWQiOiI1YWY4ODE4NDc2MjJkZDRhMjhhMTZkZGQiLCJpc3MiOiJHcmF2aXR5IiwianRpIjoiNWI3MzFmNjViYzczZTYwNTBmNjQ4MTEwIn0.dJxCO8epG7O6OlOmG-MvWWZS8vPxg6BlyNaSQq4nbc0";




    public Artist_ViewHolder(View itemView) {
        super(itemView);
        artistImage = itemView.findViewById(R.id.artist_profile_img);
        artistName = itemView.findViewById(R.id.artist_name);
        artistNationality = itemView.findViewById(R.id.artistNationality);
        artImageOne = itemView.findViewById(R.id.artImageOne);
        artImageTwo = itemView.findViewById(R.id.artImageTwo);

    }

    public void onBind(Artists artistsList) {
        artistName.setText(artistsList.getName());
        artistNationality.setText(artistsList.getNationality());
        artistID = artistsList.getId();
        //load and set itemView images
        setImages(artistsList);
    }

    public void setImages(Artists artists){
        //load and set artist Image
        if(!artists.get_links().getThumbnail().getHref().isEmpty()){
            artistImage_URL = artists.get_links().getThumbnail().getHref();

            Picasso.get()
                    .load(artistImage_URL)
                    .into(artistImage);
            Log.d(TAG, "onBind Image One: " + artistImage_URL);
        }
        /**
         * Breakpoint for Bug
         */
//
       //load and set artworkOne
//        if(artists.get_links().getArtworks() != null){
//            imageOne_URL = artists.get_links().getArtworks().get(0).get_links().getImage().getHref();
//
//            Picasso.get()
//                    .load(imageOne_URL)
//                    .into(artImageOne);
//            Log.d(TAG, "onBind Image Two: " + imageOne_URL);
//        }
//        //load and set artWorkTwo
//        if (artists.get_links().getArtworks().size() > 1){
//            imageTwo_URL = artists.get_links().getArtworks().get(0).get_links().getImage().getHref();
//            Picasso.get()
//                    .load(imageTwo_URL)
//                    .into(artImageTwo);
    }
}

