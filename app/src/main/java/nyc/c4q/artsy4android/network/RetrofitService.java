package nyc.c4q.artsy4android.network;

import java.util.List;

import io.reactivex.Single;
import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.Constants;
import nyc.c4q.artsy4android.models.Fairs;
import nyc.c4q.artsy4android.models.FairsList;
import nyc.c4q.artsy4android.models.Search_Results;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.models.Artwork;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {


        @POST("tokens/xapp_token")
        Single<Token> createToken(@Query("client_id") String client_id, @Query("client_secret") String client_secret);

        @GET("artists")
        Single<ArtistsList> getArtistsList(@Query("similarity_type") String similarity_type,
                                           @Query("artworks") boolean artworks,
                                           @Query("sort") String sort,
                                           @Query("size") int size,
                                           @Header("X-Xapp-Token") String xappToken);

        @GET("artists/{artist_id}")
        Call<Artist> getArtist(@Path("artist_id") String artist_id, @Header("X-Xapp-Token") String xappToken);

        @GET("fairs")
        Single<FairsList> getFairsList(@Query("status") String status, @Query("size") String size,@Header("X-Xapp-Token") String xappToken);

        @GET("fairs/{fair_id}")
        Call<Fairs> getFair(@Path("fair_id") String fair_id);

        @GET("search")
        Call<List<Search_Results>> getSearchResults(@Query("q") String q,
                                                    @Query("size") int size,
                                                    @Query("type") String type);
        @GET("artworks/{artist_id}")
        Call<Artwork> getArtistArtworks(@Query("id") String id, @Header("X-Xapp-Token") String xappToken);

        @GET
        Single<Artwork> getTrendingArtworks(@Query("size") String size);

        class ApiUtils{
            public static RetrofitService retrofitService = RetrofitClient
                    .getRetrofitClient(Constants.BASEURL)
                    .create(RetrofitService.class);

        }

}

