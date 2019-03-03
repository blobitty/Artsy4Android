package nyc.c4q.artsy4android.SplashPage;

import android.content.SharedPreferences;
import android.util.Log;

import io.reactivex.Single;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.RetrofitClient;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.artsy4android.controller.ArtistsListAdapter.TAG;

class SplashTokenCall {
    private Token token;
    private RetrofitService retrofitService;


    SplashTokenCall(RetrofitService retrofitService, Token token){
        retrofitService = this.retrofitService;
        token = this.token;
    }
    Single<Token> createToken(String SHARED_PREFS_KEY, final SharedPreferences tokenSharedPrefs) {
        //RetrofitService retroService = RetrofitClient.getRetrofit(Constants.BASEURL).create(RetrofitService.class);

        Single<Token> tokenStream = retrofitService.createToken(Constants.client_id, Constants.client_secret);
//        //token = tokenStream unwrapSingle to access response.body();
//        String xappToken = token.getToken();
//                    Log.d(TAG, "onResponse: XAPP= " + xappToken);
//                    SharedPreferences.Editor editor = tokenSharedPrefs.edit();
//                    editor.putString(Constants.TOKEN_KEY, xappToken);
//                    editor.apply();
        return tokenStream;

    }
}
