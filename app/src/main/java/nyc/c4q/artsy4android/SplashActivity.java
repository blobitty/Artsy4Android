package nyc.c4q.artsy4android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nyc.c4q.artsy4android.homesection.HomeActivity;
import nyc.c4q.artsy4android.model.Token;
import nyc.c4q.artsy4android.network.Retrofit_Instance;
import nyc.c4q.artsy4android.network.Retrofit_Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static nyc.c4q.artsy4android.recyclerview.Artist_Adapter.TAG;

public class SplashActivity extends AppCompatActivity {

    //TODO: Create new models for the other fragments in the home page

    Retrofit_Instance retrofit_instance;
    Retrofit retrofit;
    Token tokenData;
    String xappToken;
    static final String client_id = "ff1f77e1f11ef2d881a6";
    static final String client_secret = "959788b83c942b13023e73180f768e99";
    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private SharedPreferences tokenSharedPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getService();
        tokenSharedPrefs = getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
        //Makes a retrofit call to obtain xapp token and save xapp string to sharedpref
    public void getService(){
        retrofit_instance = new Retrofit_Instance();
        retrofit = retrofit_instance.getRetrofit();
        Retrofit_Service retroService = retrofit.create(Retrofit_Service.class);
        Call<Token> getTokenData = retroService.createToken(client_id, client_secret);
        getTokenData.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if (response.isSuccessful()){
                    tokenData = response.body();
                    xappToken = tokenData.getToken();
                    Log.d(TAG, "onResponse: " + xappToken);
                    SharedPreferences.Editor editor = tokenSharedPrefs.edit();
                    editor.putString("xapptoken", xappToken);
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
