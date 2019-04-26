package nyc.c4q.artsy4android.homesection.foryou;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.homesection.foryou.controller.FairsListAdapter;
import nyc.c4q.artsy4android.models.Fairs;
import nyc.c4q.artsy4android.models.FairsList;
import nyc.c4q.artsy4android.network.RetrofitClient;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;
import static nyc.c4q.artsy4android.homesection.artistslist.controller.ArtistsListAdapter.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForYouFragment extends Fragment {
    RecyclerView fairsRV;
    View rootView;
    List<Fairs> fairsList;
    FairsList fairsListHolder;
    Retrofit retrofit;
    RetrofitService retroService;
    String xapptoken;
    private SharedPreferences tokenSharedPrefs;
    private static final String SHARED_PREFS_KEY = "sharedPrefs";
    String[] recentlyViewedURLS = new String[4];
    ImageView recentlyViewed_1, recentlyViewed_2, recentlyViewed_3, recentlyViewed_4;
    ImageView[] imageViewArray = new ImageView[4];


    public ForYouFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tokenSharedPrefs = this.getActivity().getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);
        xapptoken = tokenSharedPrefs.getString(Constants.TOKEN_KEY, null);
        rootView = inflater.inflate(R.layout.fragment_foryou, container, false);
        fairsRV = rootView.findViewById(R.id.artfair_recycler);
        fairsAPI_Call();
        recentlyViewed_1 = rootView.findViewById(R.id.recentlyViewed_IV1);
        recentlyViewed_2 = rootView.findViewById(R.id.recentlyViewed_IV2);
        recentlyViewed_3 = rootView.findViewById(R.id.recentlyViewed_IV3);
        recentlyViewed_4 = rootView.findViewById(R.id.recentlyViewed_IV4);
        viewData_Collector();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recViewed_ImgLoader();

    }

    public void fairsAPI_Call(){
        retrofit = RetrofitClient.getRetrofitClient(Constants.BASEURL);
        retroService = retrofit.create(RetrofitService.class);
        Call<FairsList> getFairsList = retroService.getFairsList("current", "20", xapptoken);
        getFairsList.enqueue(new Callback<FairsList>() {
            @Override
            public void onResponse(Call<FairsList> call, Response<FairsList> response) {
                fairsListHolder = response.body();
                fairsList = fairsListHolder.get_embedded().getFairsList();

                Log.i(TAG, "onResponseFairsListHolder: " + fairsListHolder);
                Log.i(TAG, "onFairsRawResponse: " + response.raw());
                Log.i(TAG, "onResponseFairsEmbedded: " + fairsListHolder.get_embedded().getFairsList());

                setUpRV();
            }

            @Override
            public void onFailure(Call<FairsList> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.toString());
                t.printStackTrace();
            }
        });
    }



    public void setUpRV(){
        FairsListAdapter fairsList_adapter = new FairsListAdapter(fairsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fairsRV.setAdapter(fairsList_adapter);
        fairsRV.setLayoutManager(linearLayoutManager);
    }



    public void recViewed_ImgLoader(){

        for (int i = 0; i < recentlyViewedURLS.length; i++){
            Picasso
                    .get()
                    .load(recentlyViewedURLS[i])
                    //.resize(140, 200)
                    .fit()
                    .centerInside()
                    .into(imageViewArray[i]);
        }
    }

    public void viewData_Collector(){
        recentlyViewedURLS[0] = "https://d32dm0rphc51dk.cloudfront.net/hopJunQLJ3jr3zxagXkC3w/larger.jpg";
        recentlyViewedURLS[1] = "https://d32dm0rphc51dk.cloudfront.net/A3L5cLa-qjh2s4amBh3KVw/large.jpg";
        recentlyViewedURLS[2] = "https://d32dm0rphc51dk.cloudfront.net/NOpIAwQa-3r51Cg9qXKbfA/larger.jpg";
        recentlyViewedURLS[3] = "https://d32dm0rphc51dk.cloudfront.net/9nWa7ol_LQIg_dunHYBoUQ/larger.jpg";
        imageViewArray[0] = recentlyViewed_1;
        imageViewArray[1] = recentlyViewed_2;
        imageViewArray[2] = recentlyViewed_3;
        imageViewArray[3] = recentlyViewed_4;
    }


}
