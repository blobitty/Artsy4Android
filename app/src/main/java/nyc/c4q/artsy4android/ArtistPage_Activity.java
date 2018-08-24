package nyc.c4q.artsy4android;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.artistpage.ArtistPager_Fragment;

public class ArtistPage_Activity extends AppCompatActivity {
    ArtistPager_Fragment artistPager_fragment = new ArtistPager_Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_page_);

        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        fTransaction.replace(R.id.artist_pageContainer, artistPager_fragment);
        fTransaction.commit();
    }
}
