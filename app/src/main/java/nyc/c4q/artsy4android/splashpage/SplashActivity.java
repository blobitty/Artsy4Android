package nyc.c4q.artsy4android.splashpage;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nyc.c4q.artsy4android.MainActivity;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //createToken(SHARED_PREFS_KEY, tokenSharedPrefs);
        SplashViewModel splashModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        splashModel.fetchToken().observe(this, this::createToken);

    }

    public void createToken(Token token) {

        final String SHARED_PREFS_KEY = "sharedPrefs";
        SharedPreferences tokenSharedPrefs = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        Log.d(Constants.TAG, "onResponse: XAPP= " + token.getToken());
                SharedPreferences.Editor editor = tokenSharedPrefs.edit();
                  editor.putString(Constants.TOKEN_KEY, token.getToken());
                    editor.apply();
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
          startActivity(intent);
          finish();
    }
}
