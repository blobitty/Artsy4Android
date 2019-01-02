package nyc.c4q.artsy4android.homesection.artistslist;

import nyc.c4q.artsy4android.models.Artist;
import nyc.c4q.artsy4android.network.RetrofitService;

public interface ArtitstFragmentContract {

    interface Network{

        void artistsAPI_Call(String xappToken);

    }

    interface RecyclerOnClickListener{

       void onItemClick(Artist artist);

    }

}
