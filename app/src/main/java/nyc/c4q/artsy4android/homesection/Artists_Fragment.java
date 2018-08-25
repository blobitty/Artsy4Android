package nyc.c4q.artsy4android.homesection;


import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.adapter.ArtistsList_Adapter;
import nyc.c4q.artsy4android.models.Artists;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.Retrofit_Instance;
import nyc.c4q.artsy4android.network.Retrofit_Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;
import static nyc.c4q.artsy4android.adapter.ArtistsList_Adapter.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class Artists_Fragment extends Fragment {
    View rootView;
    RecyclerView artistFragmentRV;
    List <Artists> artistsList;
    ArtistsList artistsListHolder;
    Retrofit_Instance retroInstance;
    Retrofit retrofit;
    Retrofit_Service retroService;
    private SharedPreferences tokenSharedPrefs;
    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    String xapptoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6IiIsImV4cCI6MTUzNTY2MTI0MiwiaWF0IjoxNTM1MDU2NDQyLCJhdWQiOiI1YWY4ODE4NDc2MjJkZDRhMjhhMTZkZGQiLCJpc3MiOiJHcmF2aXR5IiwianRpIjoiNWI3ZjFhM2FlMDI2OGQ0YWJmMDM2Yzk2In0.sNWPS5zsAWD3wbWMKq0sjB8tK3UHgc7XqNDn3lSOTrI";
    Typeface typeface;



    public Artists_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_artists_, container, false);
        artistFragmentRV = rootView.findViewById(R.id.artist_recyclerView);
        tokenSharedPrefs = getActivity().getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);
        //xapptoken = tokenSharedPrefs.getString(xapptoken, null);
        artistsAPI_Call();
//        typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/adobegaramondttf");
        

        return rootView;
    }


    public void setUpRV(){
        ArtistsList_Adapter artist_adapter = new ArtistsList_Adapter(artistsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        artistFragmentRV.setAdapter(artist_adapter);
        artistFragmentRV.setLayoutManager(linearLayoutManager);
    }

    public void artistsAPI_Call(){
        retroInstance = new Retrofit_Instance();
        retrofit = retroInstance.getRetrofit();
        retroService = retrofit.create(Retrofit_Service.class);
        Call<ArtistsList> getArtistsList = retroService.getArtistsList("contemporary", true, "-trending", 20, xapptoken);
        getArtistsList.enqueue(new Callback<ArtistsList>() {
            @Override
            public void onResponse(Call<ArtistsList> call, Response<ArtistsList> response) {
                artistsListHolder = response.body();
                artistsList = artistsListHolder.get_embedded().getArtists();
                //Loggers to check null references when traversing Data Object
                Log.i(TAG, "onResponse: " + artistsListHolder);
                Log.i(TAG, "onRawResponse: " + response.raw());
                Log.i(TAG, "onCallRequest: " + call.request());
                Log.i(TAG, "artistList Contents " + artistsListHolder.get_embedded());
                Log.i(TAG, "Artist Thumbnail Image " + artistsListHolder.get_embedded().getArtists().get(0).get_links().getThumbnail().getHref());

               setUpRV();
            }

            @Override
            public void onFailure(Call<ArtistsList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
            }
        });
    }

}
