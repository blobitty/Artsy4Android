package nyc.c4q.artsy4android.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobbybah on 5/21/18.
 */

public class RetrofitInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.artsy.net/api/";

    public  Retrofit getRetrofit(){
        if (retrofit == null) return retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
