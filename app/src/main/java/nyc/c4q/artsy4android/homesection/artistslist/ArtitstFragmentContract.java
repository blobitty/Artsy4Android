package nyc.c4q.artsy4android.homesection.artistslist;

import nyc.c4q.artsy4android.models.Artist;

public interface ArtitstFragmentContract {

    interface Network{

        void artistsAPI_Call();

    }

    interface RecyclerOnClickListener{

       void onItemClick(Artist artist);

    }

}
