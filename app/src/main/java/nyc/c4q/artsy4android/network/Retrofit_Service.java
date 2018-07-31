package nyc.c4q.artsy4android.network;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Retrofit_Service {

    /**
     * put service and retrofit endpoint here
     */

        @POST("tokens/xapp_token")
        fun getToken(@Query("client_id") clientId: String, @Query("client_secret") clientSecret: String);

        @GET("artworks")
        fun getArt(@Query("size") size: Int = 10);

        @GET("artworks")
        fun getArtByCursor(@Query("cursor", encoded = true) cursor: String, @Query("size") size: Int = 10);

        @GET("artists")
        fun getArtists(@Query("size") size: Int = 10);

        @GET("artists")
        fun getArtistsByCursor(@Query("cursor", encoded = true) cursor: String, @Query("size") size: Int = 10);

        @GET("artists")
        fun getArtistsByArtworkId(@Query("artwork_id", encoded = true)id: String);
}
