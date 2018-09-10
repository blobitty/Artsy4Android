package nyc.c4q.artsy4android.artistpage;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Token;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class About_Fragment extends Fragment {
    String xappToken;
    SharedPreferences tokenSharedPrefs;
    Artist artist = new Artist();
    String artistID;

    public About_Fragment() {
        // Required empty public constructor
    }

    //TODO: 1) Create call for single artist via ID

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String shared_prefs_key = "sharedPrefs";
        tokenSharedPrefs = this.getActivity().getSharedPreferences(shared_prefs_key, MODE_PRIVATE);
        xappToken = tokenSharedPrefs.getString(Constants.TOKEN_KEY, null);
        Intent intent = getActivity().getIntent();
        artistID = intent.getExtras().getString("ARTIST_ID");
        Log.i(TAG, "onCreateView: ARTIST ID = " + artistID);


        return inflater.inflate(R.layout.fragment_about, container, false);
    }

}
