package nyc.c4q.artsy4android.homesection.foryou;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import io.reactivex.disposables.Disposable;
import nyc.c4q.artsy4android.models.Artwork;
import nyc.c4q.artsy4android.network.RetrofitService;


public class ForYouViewModel {

    ForYouRepository repository = new ForYouRepository(RetrofitService.ApiUtils.retrofitService);
    MutableLiveData<List<Artwork>> listData;

    LiveData<List<Artwork>> loadArtwork(){
        if (listData != null) return listData;
        else {

        }
    }

    Disposable getArtwork(String token)
}
