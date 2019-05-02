package nyc.c4q.artsy4android.homesection.foryou;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;



import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.artsy4android.models.Artwork;
import nyc.c4q.artsy4android.network.RetrofitService;


public class ForYouViewModel {

    ForYouRepository repository = new ForYouRepository(RetrofitService.ApiUtils.retrofitService);
    MutableLiveData<Artwork> listData;
    String token;

    LiveData<Artwork> loadArtwork(){
        if (listData != null) return listData;
        else {
            getArtwork(token);
        }
        return listData;
    }

    Disposable getArtwork(String token){
        return repository.fetchTrendingArtworks()
                .subscribeOn(Schedulers.io())
                .subscribe(data -> listData.postValue(data));

    }
}
