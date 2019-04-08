package nyc.c4q.artsy4android.homesection.artistslist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitService;
import static nyc.c4q.artsy4android.models.Constants.TOKEN_KEY;

public class ArtistsListViewModel extends ViewModel {
    String token;
    private ListRepository listRepository = new ListRepository(RetrofitService.ApiUtils.retrofitService);
    private MutableLiveData<ArtistsList> listData;


    LiveData<ArtistsList> fetchList(String token){
        if(listData == null){
         listData = new MutableLiveData<>();
         getArtistList(token);
        }
        return listData;
    }

    private Disposable getArtistList(String token) {
        return listRepository.artistsAPI_Call(token)
                .map(artistsList -> artistsList.get_embedded().getArtists())
                .subscribeOn(Schedulers.io())
                .subscribe();

    }

    @Override
    public void onCleared(){
        getArtistList(token).dispose();
    }
}
