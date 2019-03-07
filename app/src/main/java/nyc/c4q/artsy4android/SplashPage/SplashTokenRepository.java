package nyc.c4q.artsy4android.SplashPage;

import android.content.SharedPreferences;

import io.reactivex.Single;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.RetrofitService;

class SplashTokenRepository {
    private RetrofitService retrofitService;


    SplashTokenRepository(RetrofitService retrofitService){
        retrofitService = this.retrofitService;
    }
    Single<Token> createToken(String SHARED_PREFS_KEY, final SharedPreferences tokenSharedPrefs) {
        return retrofitService.createToken(Constants.client_id, Constants.client_secret);
    }
}


//        //token = tokenStream unwrapSingle to access response.body();
//        String xappToken = token.getToken();
//                    Log.d(TAG, "onResponse: XAPP= " + xappToken);
//                    SharedPreferences.Editor editor = tokenSharedPrefs.edit();
//                    editor.putString(Constants.TOKEN_KEY, xappToken);
//                    editor.apply();