package nyc.c4q.artsy4android.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bobbybah on 5/21/18.
 */

public class Retrofit_Instance {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(String basUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(basUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
