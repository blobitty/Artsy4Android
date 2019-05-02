package nyc.c4q.artsy4android.homesection.foryou;

import io.reactivex.Single;
import nyc.c4q.artsy4android.models.Artwork;
import nyc.c4q.artsy4android.models.FairsList;
import nyc.c4q.artsy4android.network.RetrofitService;

public class ForYouRepository {

    private RetrofitService retrofitService;

    public ForYouRepository(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;

    }

    Single<FairsList> fetchCurrentFairs(String xappToken) {
        return retrofitService.getFairsList("current", "20", xappToken);
    }

    Single<Artwork> fetchTrendingArtworks(){
        return retrofitService.getTrendingArtworks("30");
    }
}
