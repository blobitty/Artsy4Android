package nyc.c4q.artsy4android.homesection.artistslist;

import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.models.ArtistsList;
import nyc.c4q.artsy4android.network.RetrofitService;
import retrofit2.Call;

public interface ArtitstFragmentContract {

    interface Network{

        Call<ArtistsList> artistsAPI_Call(String xappToken);

    }

    interface RecyclerOnClickListener{

       void onItemClick(Artist artist);

    }

}
