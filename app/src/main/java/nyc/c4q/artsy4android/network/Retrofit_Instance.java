package nyc.c4q.artsy4android.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobbybah on 5/21/18.
 */

public class Retrofit_Instance {
    private static Retrofit retrofit = null;
    static final String BASE_URL = "https:/api.artsy.net/api/";
    static final String client_id = "ff1f77e1f11ef2d881a6";
    static final String client_secret = "959788b83c942b13023e73180f768e99";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
