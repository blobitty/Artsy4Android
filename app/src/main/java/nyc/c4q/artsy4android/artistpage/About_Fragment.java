package nyc.c4q.artsy4android.artistpage;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.controller.ArtistsList_Adapter;
import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.Retrofit_Instance;
import nyc.c4q.artsy4android.network.Retrofit_Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class About_Fragment extends Fragment {
    String xappToken;
    SharedPreferences tokenSharedPrefs;
    Artist artist = new Artist();
    String artistID;
    TextView bioBody, stats;
    private Retrofit_Instance retroInstance;
    private Retrofit retrofit;
    View rootView;

    public About_Fragment() {
        // Required empty public constructor
    }

    //TODO: 1) Create call for single artist via ID

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
        return rootView;
    }

    public void artistsAPI_Call(){
        retroInstance = new Retrofit_Instance();
        retrofit = retroInstance.getRetrofit();
        Retrofit_Service retroService = retrofit.create(Retrofit_Service.class);

        Call<Artist> getArtist = retroService.getArtist(artistID, xappToken);
        getArtist.enqueue(new Callback<Artist>() {
            @Override
            public void onResponse(Call<Artist> call, Response<Artist> response) {
                artist = response.body();
                Log.i(TAG, "onResponse: " + artist);
                Log.i(TAG, "onRawResponse: " + response.raw());
                Log.i(TAG, "Bio Body " + artist.getBiography().toString());
                bioBody.setText(artist.getBiography().toString());

            }

            @Override
            public void onFailure(Call<Artist> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
                t.printStackTrace();
            }
        });
    }

}
