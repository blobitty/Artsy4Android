package nyc.c4q.artsy4android.homesection;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.artsy4android.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Artist_Fragment artist_fragment = new Artist_Fragment();
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.home_fContainer, artist_fragment).commit();
    }

}
