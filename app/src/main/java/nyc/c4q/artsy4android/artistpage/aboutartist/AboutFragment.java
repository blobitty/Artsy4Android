package nyc.c4q.artsy4android.artistpage.aboutartist;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.ArtworksList;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.network.RetrofitClient;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {
    String xappToken;
    SharedPreferences tokenSharedPrefs;
    Artist artist = new Artist();
    ArtworksList artworksList = new ArtworksList();
    String artistID;
    TextView bioBody, stats;
    private Retrofit retrofit = RetrofitClient.getRetrofitClient(Constants.BASEURL);;
    View rootView;

    public AboutFragment() {
        // Required empty public constructor
    }

    //TODO: 1) Decouple code to MVVM architecture 5/13/19

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about, container, false);
        // Inflate the layout for this fragment
        String shared_prefs_key = "sharedPrefs";
        tokenSharedPrefs = this.getActivity().getSharedPreferences(shared_prefs_key, MODE_PRIVATE);
        xappToken = tokenSharedPrefs.getString(Constants.TOKEN_KEY, null);
        bioBody = rootView.findViewById(R.id.biography_body);
        artistID = getActivity().getIntent().getExtras().getString("ARTIST_ID");
        Log.i(TAG, "onCreateView: ARTIST ID = " + artistID);
        artistsAPI_Call();
        artworksAPI_Call(artistID);
        return rootView;
    }

    public void artistsAPI_Call(){
        RetrofitService retroService = retrofit.create(RetrofitService.class);
        Call<Artist> getArtist = retroService.getArtist(artistID, xappToken);
        getArtist.enqueue(new Callback<Artist>() {
            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                artist = response.body();
                Log.i(TAG, "onResponse: " + artist);
                Log.i(TAG, "onRawResponse: " + response.raw());
                Log.i(TAG, "Bio Body " + artist.getBiography());
                bioBody.setText(artist.getBiography());

            }

            @Override
            public void onFailure(Call<Artist> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
                t.printStackTrace();
            }
        });
    }
    public void artworksAPI_Call(String artistID){
        RetrofitService retroService = retrofit.create(RetrofitService.class);
        Call<ArtworksList> getArtworks = retroService.getArtistArtworks(artistID, xappToken);

        getArtworks.enqueue(new Callback<ArtworksList>() {
            @Override
            public void onResponse(Call<ArtworksList> call, Response<ArtworksList> response) {
                artworksList = response.body();
                Log.i(TAG, "ARTWORKS onResponse: " + artworksList);
                Log.i(TAG, "onResponse: " + response.raw());
            }

            @Override
            public void onFailure(Call<ArtworksList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
