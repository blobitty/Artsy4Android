package nyc.c4q.artsy4android.splashpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.artsy4android.MainActivity;

public class SplashActivity extends AppCompatActivity {

    //SplashTokenRepository splash_xappToken = new SplashTokenRepository();
    private static final String SHARED_PREFS_KEY = "sharedPrefs";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences tokenSharedPrefs = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        //createToken(SHARED_PREFS_KEY, tokenSharedPrefs);

    }
    public void createToken(String SHARED_PREFS_KEY, SharedPreferences sharedPreferences) {
          //splash_xappToken.createToken(SHARED_PREFS_KEY,sharedPreferences);
          Intent intent = new Intent(SplashActivity.this, MainActivity.class);
          startActivity(intent);
          finish();
    }
}
