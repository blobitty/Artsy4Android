package nyc.c4q.artsy4android.homesection.artistslist;

import nyc.c4q.artsy4android.network.RetrofitInstance;
import retrofit2.Retrofit;

public class ArtistsFragementCall implements ArtitstFragmentContract.Network {


    @Override
    public void artistsAPI_Call() {
        RetrofitInstance retroInst = new RetrofitInstance();

        Retrofit retrofit = retroInst.getRetrofit();

    }
}
