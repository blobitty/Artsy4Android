package nyc.c4q.artsy4android.homesection.artistslist;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.homesection.artistslist.controller.ArtistsListAdapter;
import nyc.c4q.artsy4android.models.Artist;

import static android.content.Context.MODE_PRIVATE;
import static nyc.c4q.artsy4android.homesection.artistslist.controller.ArtistsListAdapter.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsListFragment extends Fragment{
    View rootView;
    RecyclerView artistFragmentRV;
    ListRepository call = new ListRepository();




    public ArtistsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_artists_, container, false);
        artistFragmentRV = rootView.findViewById(R.id.artist_recyclerView);
        String SHARED_PREFS_KEY = "sharedPrefs";
        SharedPreferences tokenSharedPrefs = this.getActivity().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        String xappToken = tokenSharedPrefs.getString(Constants.TOKEN_KEY, null);
        call.artistsAPI_Call(xappToken);
        List<Artist> artistsList = call.artistsList;
        Log.i(TAG, "MAIN artistsList Size: " + artistsList.size());
        //TODO: Create animation and method waiting for async method to return populated list
        setUpRV(call.artistsList);

        return rootView;
    }

    public void setUpRV(List <Artist> artistsList){
        ArtistsListAdapter artist_adapter = new ArtistsListAdapter(artistsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        artistFragmentRV.setAdapter(artist_adapter);
        artistFragmentRV.setLayoutManager(linearLayoutManager);
    }


}
