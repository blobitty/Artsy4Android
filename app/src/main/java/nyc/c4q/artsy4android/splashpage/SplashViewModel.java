package nyc.c4q.artsy4android.splashpage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.RetrofitService;

public class SplashViewModel extends ViewModel {

    private SplashTokenRepository splashTokenRepo = new SplashTokenRepository(RetrofitService.ApiUtils.retrofitService);
    private MutableLiveData<Token> data;

    LiveData<Token> fetchToken(){

        if(data == null){
            data = new MutableLiveData<>();
            loadToken();
        }
        return data;
    }

    private Disposable loadToken() {

        //creates a disposable single source that emits one item which should be a data
        return splashTokenRepo.createToken(Constants.client_id, Constants.client_secret)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( token -> data.postValue(token));
    }

    @Override
    public void onCleared(){
        loadToken().dispose();
    }


}
