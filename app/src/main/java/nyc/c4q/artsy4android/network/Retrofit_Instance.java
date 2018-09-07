package nyc.c4q.artsy4android.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobbybah on 5/21/18.
 */

public class Retrofit_Instance {
    private static Retrofit retrofit = null;
    public static Retrofit_Instance instance;
    static final String BASE_URL = "https:/api.artsy.net/api/";

    public Retrofit getRetrofit(){
        return retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
