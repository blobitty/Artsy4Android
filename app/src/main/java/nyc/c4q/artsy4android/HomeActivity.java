package nyc.c4q.artsy4android;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.homesection.HomePagerFragment;

public class HomeActivity extends AppCompatActivity {

    HomePagerFragment homePagerFragment = new HomePagerFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        fTransaction.replace(R.id.home_fContainer, homePagerFragment);
        fTransaction.commit();

    }

}
