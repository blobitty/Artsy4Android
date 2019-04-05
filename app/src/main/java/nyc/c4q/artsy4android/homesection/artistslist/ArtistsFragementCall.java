package nyc.c4q.artsy4android.homesection.artistslist;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.network.RetrofitClient;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static nyc.c4q.artsy4android.homesection.artistslist.controller.ArtistsListAdapter.TAG;

public class ArtistsFragementCall implements ArtitstFragmentContract.Network {

    List<Artist> artistsList = new ArrayList<>();
    @Override
    public Call<ArtistsList> artistsAPI_Call(String xappToken) {

        //call service interface so that we can use interface methods
        RetrofitService retrofitService = RetrofitClient.getRetrofitClient(Constants.BASEURL).create(RetrofitService.class);
        Call<ArtistsList> getArtistsList = retrofitService.getArtistsList("contemporary", true, "-trending", 20, xappToken);
        getArtistsList.enqueue(new Callback<ArtistsList>() {
            @Override
            public void onResponse(@NonNull Call<ArtistsList> call, @NonNull Response<ArtistsList> response) {
                ArtistsList artistsListHolder = response.body();
                artistsList = artistsListHolder.get_embedded().getArtists();

                //Loggers to check null references when traversing nested data Object
                Log.i(TAG, "onResponse: " + artistsListHolder);
                Log.i(TAG, "artistsList Size: " + artistsList.size());
            }
            @Override
            public void onFailure(@NonNull Call<ArtistsList> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
            }
        });
        return getArtistsList;
    }
}
