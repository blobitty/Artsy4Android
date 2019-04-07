package nyc.c4q.artsy4android.homesection.artistslist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitService;
import static nyc.c4q.artsy4android.models.Constants.TOKEN_KEY;

public class ArtsistListViewModel extends ViewModel {

    private ListRepository listRepository = new ListRepository(RetrofitService.ApiUtils.retrofitService);
    private MutableLiveData<ArtistsList> listData;


    LiveData<ArtistsList> fetchList(){
        if(listData == null){
         listData = new MutableLiveData<>();
         getArtistList();
        }
        return listData;
    }

    private Disposable getArtistList() {
        return listRepository.artistsAPI_Call(TOKEN_KEY)
                .map(artistsList -> artistsList.get_embedded().getArtists())
                .subscribeOn(Schedulers.io())
                .subscribe();

    }

    @Override
    public void onCleared(){
        getArtistList().dispose();
    }
}
