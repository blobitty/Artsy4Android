package nyc.c4q.artsy4android.network;

import java.util.List;

import nyc.c4q.artsy4android.models.Artists;
import nyc.c4q.artsy4android.models.Fairs;
import nyc.c4q.artsy4android.models.Search_Results;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.models.Artworks;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Retrofit_Service {


        @POST("tokens/xapp_token")
        Call<Token>createToken(@Query("client_id") String client_id, @Query("client_secret") String client_secret);

        @GET("artists")
        Call<ArtistsList> getArtistsList(@Query("similarity_type") String similarity_type,
                                           @Query("artworks") boolean artworks,
                                           @Query("sort") String sort,
                                           @Query("size") int size,
                                           @Header("X-Xapp-Token") String xappToken);

        @GET("artists/{artist_id}")
        Call<Artists> getArtist(@Path("artist_id") String artist_id);

        @GET("fairs/{status}")
        Call<List<Fairs>> getFairsList(@Query("status") String status);

        @GET("fairs/{fair_id}")
        Call<Fairs> getFair(@Path("fair_id") String fair_id);

        @GET("search")
        Call<List<Search_Results>> getSearchResults(@Query("q") String q,
                                                    @Query("size") int size,
                                                    @Query("type") String type);
        @GET("artworks/{id}")
        Call<Artworks> getArtworks(@Path("id") String id, @Header("X-Xapp-Token") String xappToken);

}

