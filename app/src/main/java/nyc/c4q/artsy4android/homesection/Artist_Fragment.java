package nyc.c4q.artsy4android.homesection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.model.Artists;

/**
 * A simple {@link Fragment} subclass.
 */
public class Artist_Fragment extends Fragment {
    View rootView;
    RecyclerView artistFragmentRV;
    List <Artists> artists;



    public Artist_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_artist_, container, false);
        artistFragmentRV = rootView.findViewById(R.id.artist_recyclerView);
        setUpRV();
        return rootView;
    }

    public void getArtists(){

    }


    public void setUpRV(){
//        Artist_Adapter artist_adapter = new Artist_Adapter(artists);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        artistFragmentRV.setAdapter(artist_adapter);
//        artistFragmentRV.setLayoutManager(linearLayoutManager);
    }

}
