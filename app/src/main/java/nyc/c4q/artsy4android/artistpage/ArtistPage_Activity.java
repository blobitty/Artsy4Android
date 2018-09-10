package nyc.c4q.artsy4android.artistpage;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.artistpage.ArtistPager_Fragment;
import nyc.c4q.artsy4android.models.Artist;

public class ArtistPage_Activity extends AppCompatActivity {

    private static final String TAG = "HELP!!" ;
    ArtistPager_Fragment artistPager_fragment = new ArtistPager_Fragment();
    FloatingActionButton backFAB;
    Button followFAB;
    TextView artistName, artistNationality, artistHometown;
    String artist, nationality, hometown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_page_);
        artistName = findViewById(R.id.artistpage_name);
        artistNationality = findViewById(R.id.artistpage_nationality);
        artistHometown = findViewById(R.id.artistpage_hometown);
        backFAB = findViewById(R.id.exitArtistPage_FAB);
        followFAB = findViewById(R.id.follow_button);
        Intent intent = getIntent();
        artist = intent.getExtras().get("ARTIST_NAME").toString();
        nationality = intent.getExtras().get("ARTIST_NATIONALITY").toString();
        hometown = intent.getExtras().get("ARTIST_HOMETOWN").toString();

        setTexts(artist, nationality, hometown);

        /**
         * set Texts for two buttons in Activity
         */
        followFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                followFAB.setText(R.string.Following);
                followFAB.setBackground(getResources().getDrawable(R.color.ic_black_background));
            }
        });

        backFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        fTransaction.replace(R.id.artist_pageContainer, artistPager_fragment);
        fTransaction.commit();
    }

    public void setTexts(String artist, String nationality, String hometown){
        artistName.setText(artist);
        artistHometown.setText(hometown);
        artistNationality.setText(nationality);
    }


}
