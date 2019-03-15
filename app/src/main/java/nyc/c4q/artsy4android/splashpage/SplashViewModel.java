package nyc.c4q.artsy4android.splashpage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.RetrofitService;

public class SplashViewModel extends ViewModel {

    SplashTokenRepository splashTokenRepo = new SplashTokenRepository(RetrofitService.ApiUtils.retrofitService);
    private MutableLiveData<Token> token;

    public LiveData<Token> fetchToken(){
        if(token == null){
            token = new MutableLiveData<Token>();
            loadToken();
        }
        return token;
    }

    private Disposable loadToken() {
        //creates a disposable single source that emits one item which should be a token
        return splashTokenRepo.createToken(Constants.client_id, Constants.client_secret)
                  .subscribe();
    }

    @Override
    public void onCleared(){
        loadToken().dispose();
    }


}
