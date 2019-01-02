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
import nyc.c4q.artsy4android.controller.ArtistsListAdapter;
import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitInstance;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;
import static nyc.c4q.artsy4android.controller.ArtistsListAdapter.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsFragment extends Fragment{
    View rootView;
    RecyclerView artistFragmentRV;
    List <Artist> artistsList;
//    ArtistsList artistsListHolder;
//    RetrofitInstance retroInstance;
//    Retrofit retrofit;
//    RetrofitService retroService;
    private SharedPreferences tokenSharedPrefs;
    String xappToken;
    ArtistsFragementCall call = new ArtistsFragementCall();
    Call<ArtistsList> listCall;



    public ArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_artists_, container, false);
        artistFragmentRV = rootView.findViewById(R.id.artist_recyclerView);
        String SHARED_PREFS_KEY = "sharedPrefs";
        tokenSharedPrefs = this.getActivity().getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);
        xappToken = tokenSharedPrefs.getString(Constants.TOKEN_KEY, null);
        //artistsAPI_Call();
        listCall = call.artistsAPI_Call(xappToken);
        artistsList = call.artistsList;
        setUpRV();
        return rootView;
    }

    public void setUpRV(){
        ArtistsListAdapter artist_adapter = new ArtistsListAdapter(artistsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        artistFragmentRV.setAdapter(artist_adapter);
        artistFragmentRV.setLayoutManager(linearLayoutManager);
    }


}