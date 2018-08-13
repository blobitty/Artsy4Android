package nyc.c4q.artsy4android.homesection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.artsy4android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForYou_Fragment extends Fragment {


    public ForYou_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.foryou_item, container, false);
    }



}
