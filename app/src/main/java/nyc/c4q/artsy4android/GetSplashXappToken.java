package nyc.c4q.artsy4android;

import android.content.SharedPreferences;
import android.util.Log;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.RetrofitClient;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nyc.c4q.artsy4android.controller.ArtistsListAdapter.TAG;

public class GetSplashXappToken implements SplashCall {
    private Token tokenData;
    private String xappToken;

    @Override
    public void getXappToken(String SHARED_PREFS_KEY, final SharedPreferences tokenSharedPrefs){

        RetrofitService retroService = RetrofitClient.getRetrofit().create(RetrofitService.class);
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
