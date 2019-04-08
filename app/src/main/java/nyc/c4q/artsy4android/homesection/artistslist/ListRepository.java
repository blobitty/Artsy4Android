package nyc.c4q.artsy4android.homesection.artistslist;

import io.reactivex.Single;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitClient;
import nyc.c4q.artsy4android.network.RetrofitService;

import static nyc.c4q.artsy4android.models.Constants.BASEURL;


class ListRepository {

    private RetrofitService retrofitservice;

    ListRepository(RetrofitService retrofitService){
       this.retrofitservice = retrofitService;
   }


    Single<ArtistsList> artistsAPI_Call(String xappToken) {
        //listRepository service interface so that we can use interface methods
        return retrofitservice.getArtistsList("contemporary", true, "-trending", 20, xappToken);
    }
}
