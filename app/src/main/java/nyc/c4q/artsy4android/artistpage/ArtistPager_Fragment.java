package nyc.c4q.artsy4android.artistpage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.artsy4android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistPager_Fragment extends Fragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ArtistPager_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.artist_pager_container, container, false);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.artist_toolbar);

        tabLayout = view.findViewById(R.id.artist_tabs);
        viewPager = view.findViewById(R.id.artist_viewpager);

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager) {
    }


}
