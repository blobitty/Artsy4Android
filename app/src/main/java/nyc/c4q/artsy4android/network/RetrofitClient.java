package nyc.c4q.artsy4android.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobbybah on 5/21/18.
 */

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.artsy.net/api/";

    public static Retrofit getRetrofit(){
        if (retrofit == null) return retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
