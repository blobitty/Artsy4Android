package nyc.c4q.artsy4android;

import android.Manifest;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.homesection.HomePagerFragment;

public class MainActivity extends AppCompatActivity {
    //TODO: Store and retrieve xapp token in sharedpreferences

    HomePagerFragment homePagerFragment = new HomePagerFragment();
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //set title logo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_artsy_main_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //BottomNavigation icon color switch on state change
        bottomNav = findViewById(R.id.bottom_navigation);

        //load fragments into container
        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        fTransaction.replace(R.id.home_fContainer, homePagerFragment);
        fTransaction.commit();



    }

    public void setBottomNavColors(final BottomNavigationView bottomNav){
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.getIconTintList();
                return true;
            }
        });
    }


}
