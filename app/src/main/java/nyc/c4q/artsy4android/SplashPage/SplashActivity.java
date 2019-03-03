package nyc.c4q.artsy4android.SplashPage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.artsy4android.MainActivity;

public class SplashActivity extends AppCompatActivity implements SplashCall {

    SplashTokenCall splash_xappToken = new SplashTokenCall();
    private static final String SHARED_PREFS_KEY = "sharedPrefs";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences tokenSharedPrefs = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        createToken(SHARED_PREFS_KEY, tokenSharedPrefs);

    }

    @Override
    public void createToken(String SHARED_PREFS_KEY, SharedPreferences sharedPreferences) {
          splash_xappToken.createToken(SHARED_PREFS_KEY,sharedPreferences);
          Intent intent = new Intent(SplashActivity.this, MainActivity.class);
          startActivity(intent);
          finish();
    }
    //Makes a retrofit call to obtain xapp token and save xapp string to sharedpreferences

}
