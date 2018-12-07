package nyc.c4q.artsy4android;

import android.content.SharedPreferences;
import android.util.Log;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.Retrofit_Instance;
import nyc.c4q.artsy4android.network.Retrofit_Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.artsy4android.controller.ArtistsList_Adapter.TAG;

public class GetSplash_XappToken implements SplashCall {
    private Token tokenData;
    private String xappToken;

    @Override
    public void getXappToken(String SHARED_PREFS_KEY, final SharedPreferences tokenSharedPrefs){

        Retrofit_Service retroService = Retrofit_Instance.getRetrofit().create(Retrofit_Service.class);
        Call<Token> getTokenData = retroService.createToken(Constants.client_id, Constants.client_secret);
        getTokenData.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()){
                    tokenData = response.body();
                    xappToken = tokenData.getToken();
                    Log.d(TAG, "onResponse: XAPP= " + xappToken);
                    SharedPreferences.Editor editor = tokenSharedPrefs.edit();
                    editor.putString(Constants.TOKEN_KEY, xappToken);
                    editor.apply();


                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
            }
        });
    }
}
