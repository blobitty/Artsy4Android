package nyc.c4q.artsy4android.network;

import java.util.List;

import nyc.c4q.artsy4android.model.Artists;
import nyc.c4q.artsy4android.model.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Retrofit_Service {


        @POST("tokens/xapp_token")
        Call<Token>createToken(@Query("client_id") String client_id, @Query("client_secret") String client_secret);

        //@GET("")

}
