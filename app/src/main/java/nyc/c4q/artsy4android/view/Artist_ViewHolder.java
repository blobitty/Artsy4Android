package nyc.c4q.artsy4android.view;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import java.io.File;

        import de.hdodenhof.circleimageview.CircleImageView;
        import nyc.c4q.artsy4android.ArtistPage_Activity;
        import nyc.c4q.artsy4android.R;
        import nyc.c4q.artsy4android.models.Artists;
        import nyc.c4q.artsy4android.models.Artworks;
        import nyc.c4q.artsy4android.network.Retrofit_Instance;
        import retrofit2.Retrofit;

        import static nyc.c4q.artsy4android.adapter.ArtistsList_Adapter.TAG;

public class Artist_ViewHolder extends RecyclerView.ViewHolder{
    CircleImageView artistImage;
    TextView artistName, artistNationality, artistLifeSpan, artistHometown;
    String artistImage_URL, artistID;
    Artists artists = new Artists();






    public Artist_ViewHolder(final View itemView) {
        super(itemView);
        artistImage = itemView.findViewById(R.id.artist_profile_img);
        artistName = itemView.findViewById(R.id.artist_name);
        artistNationality = itemView.findViewById(R.id.artistNationality);
        artistLifeSpan = itemView.findViewById(R.id.life_spanTV);
        artistHometown = itemView.findViewById(R.id.hometownTV);
        artistImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send itemview data
                Bundle itemViewBundle = new Bundle();
                itemViewBundle.putString("ARTIST_NAME", artistName.getText().toString());
                itemViewBundle.putString("ARTIST_NATIONALOTY", artistNationality.getText().toString());
                itemViewBundle.putString("ARTIST_HOMETOWN", artistHometown.getText().toString());
               itemView.getContext().startActivity(new Intent(itemView.getContext(), ArtistPage_Activity.class));
            }
        });

    }

    public void onBind(Artists artists) {
        String lifeSpan = artists.getBirthday() + "-" + artists.getDeathday();
        artistName.setText(artists.getName());
        artistNationality.setText(artists.getNationality());
        artistLifeSpan.setText(lifeSpan);
        artistHometown.setText(artists.getHometown());
        artistID = artists.getId();
        //load and set itemView images
        setImages(artists);
    }

    public void setImages(Artists artists){
        //load and set artist Image
        if(!artists.get_links().getThumbnail().getHref().isEmpty()){
            artistImage_URL = artists.get_links().getThumbnail().getHref();

            Picasso.get()
                    .load(artistImage_URL)
                    .into(artistImage);
            Log.d(TAG, "Thumbnail Image: " + artistImage_URL);
        }
    }
}

