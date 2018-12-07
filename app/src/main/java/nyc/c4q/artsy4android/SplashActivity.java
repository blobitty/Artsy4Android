package nyc.c4q.artsy4android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements SplashCall {

    GetSplash_XappToken splash_xappToken = new GetSplash_XappToken();
    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    private SharedPreferences tokenSharedPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tokenSharedPrefs = getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);
        getXappToken(SHARED_PREFS_KEY, tokenSharedPrefs);

    }

    @Override
    public void getXappToken(String SHARED_PREFS_KEY, SharedPreferences sharedPreferences) {
          splash_xappToken.getXappToken(SHARED_PREFS_KEY,sharedPreferences);
          Intent intent = new Intent(SplashActivity.this, MainActivity.class);
          startActivity(intent);
          finish();
    }
    //Makes a retrofit call to obtain xapp token and save xapp string to sharedpreferences

}
