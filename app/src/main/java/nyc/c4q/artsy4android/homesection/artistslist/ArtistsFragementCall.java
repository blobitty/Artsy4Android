package nyc.c4q.artsy4android.homesection.artistslist;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitInstance;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;



import static nyc.c4q.artsy4android.controller.ArtistsListAdapter.TAG;

public class ArtistsFragementCall implements ArtitstFragmentContract.Network {
    List<Artist> artistsList;
    ArtistsList artistsListHolder;

    @Override
    public void artistsAPI_Call(String xappToken) {
        RetrofitService retrofitService;
        //class for retrofit implementation
        RetrofitInstance retroInst = new RetrofitInstance();
        //factory method for call with baseURL
        Retrofit retrofit = retroInst.getRetrofit();
        //call service interface so that we can use interface methods
        retrofitService = retrofit.create(RetrofitService.class);

        Call<ArtistsList> getArtistsList = retrofitService.getArtistsList("contemporary", true, "-trending", 20, xappToken);
        getArtistsList.enqueue(new Callback<ArtistsList>() {
            @Override
            public void onResponse(@NonNull Call<ArtistsList> call, @NonNull Response<ArtistsList> response) {
                artistsListHolder = response.body();
                artistsList = artistsListHolder.get_embedded().getArtists();
                //Loggers to check null references when traversing nested data Object
                Log.i(TAG, "onResponse: " + artistsListHolder);
                Log.i(TAG, "onRawResponse: " + response.raw());
                //TODO:Change Implementation of how we set up the UI for onSuccess/onFailure
                // setUpRV();
            }

            @Override
            public void onFailure(@NonNull Call<ArtistsList> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
            }
        });
    }
}
