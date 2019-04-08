package nyc.c4q.artsy4android.homesection.artistslist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitService;

public class ArtistsListViewModel extends ViewModel {
    private ListRepository listRepository = new ListRepository(RetrofitService.ApiUtils.retrofitService);
    private MutableLiveData<ArtistsList> listData;
    private String token;

    LiveData<ArtistsList> fetchList(String token){
        if(listData == null){
         listData = new MutableLiveData<>();
         getArtistList(token);
        }
        return listData;
    }

    private Disposable getArtistList(String token) {
        return listRepository.artistsAPI_Call(token)
                .subscribeOn(Schedulers.io())
                .subscribe(data -> listData.postValue(data));

    }

    @Override
    public void onCleared(){

       getArtistList(token).dispose();
    }
}
