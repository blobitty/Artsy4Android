package nyc.c4q.artsy4android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nyc.c4q.artsy4android.homesection.HomeActivity;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.Retrofit_Instance;
import nyc.c4q.artsy4android.network.Retrofit_Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static nyc.c4q.artsy4android.controller.ArtistsList_Adapter.TAG;

public class SplashActivity extends AppCompatActivity {

    Retrofit_Instance retrofit_instance;
    Retrofit retrofit;

    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private SharedPreferences tokenSharedPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tokenSharedPrefs = getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);


    }
        //Makes a retrofit call to obtain xapp token and save xapp string to sharedpreferences
//        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
//    startActivity(intent);
//    finish();
}
