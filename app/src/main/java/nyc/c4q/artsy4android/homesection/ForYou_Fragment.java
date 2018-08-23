package nyc.c4q.artsy4android.homesection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.artsy4android.R;
import nyc.c4q.artsy4android.adapter.FairsList_Adapter;
import nyc.c4q.artsy4android.models.Fairs;
import nyc.c4q.artsy4android.models.FairsList;
import nyc.c4q.artsy4android.network.Retrofit_Instance;
import nyc.c4q.artsy4android.network.Retrofit_Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static nyc.c4q.artsy4android.adapter.ArtistsList_Adapter.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForYou_Fragment extends Fragment {
    RecyclerView fairsRV;
    View rootView;
    List<Fairs> fairsList;
    FairsList fairsListHolder;
    Retrofit_Instance retroInstance;
    Retrofit retrofit;
    Retrofit_Service retroService;
    String xapptoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6IiIsImV4cCI6MTUzNTY2MTI0MiwiaWF0IjoxNTM1MDU2NDQyLCJhdWQiOiI1YWY4ODE4NDc2MjJkZDRhMjhhMTZkZGQiLCJpc3MiOiJHcmF2aXR5IiwianRpIjoiNWI3ZjFhM2FlMDI2OGQ0YWJmMDM2Yzk2In0.sNWPS5zsAWD3wbWMKq0sjB8tK3UHgc7XqNDn3lSOTrI";



    public ForYou_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.foryou_item, container, false);
        fairsRV = rootView.findViewById(R.id.artFair_recycler);
        fairsAPI_Call();
        return rootView;
    }

    public void fairsAPI_Call(){
        retroInstance = new Retrofit_Instance();
        retrofit = retroInstance.getRetrofit();
        retroService = retrofit.create(Retrofit_Service.class);
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
        FairsList_Adapter fairsList_adapter = new FairsList_Adapter(fairsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fairsRV.setAdapter(fairsList_adapter);
        fairsRV.setLayoutManager(linearLayoutManager);
    }


}
