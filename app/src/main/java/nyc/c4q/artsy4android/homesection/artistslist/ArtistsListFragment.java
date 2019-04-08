package nyc.c4q.artsy4android.homesection.artistslist;


import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

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
    ProgressBar progressBar;
    RecyclerView artistListRV;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_artistslist_, container, false);
        artistListRV = rootView.findViewById(R.id.artist_recyclerView);
        progressBar = rootView.findViewById(R.id.list_progressbar);
        progressBar.setVisibility(View.VISIBLE);
        //Grab data from sharedprefs
        String SHARED_PREFS_KEY = "sharedPrefs";
        SharedPreferences tokenSharedPrefs = this.getActivity().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);
        String xappToken = tokenSharedPrefs.getString(Constants.TOKEN_KEY, null);


        //viewModel implementation
        ArtistsListViewModel artistsListVM = ViewModelProviders.of(this).get(ArtistsListViewModel.class);
        artistsListVM.fetchList(xappToken).observe(this, networkResult -> {
            List<Artist> artistsList = networkResult.get_embedded().getArtists();
            Log.i(TAG, "MAIN artistsList Size: " + artistsList.size());

            setUpRV(artistsList, artistListRV);
        });



        return rootView;
    }

    void setUpRV(List <Artist> artistsList, RecyclerView recyclerView){
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
        ArtistsListAdapter artist_adapter = new ArtistsListAdapter(artistsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(artist_adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }





}
