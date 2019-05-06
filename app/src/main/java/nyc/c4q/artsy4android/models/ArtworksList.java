package nyc.c4q.artsy4android.models;

import java.util.List;

public class ArtworksList {

    Embedded _embedded;

    public Embedded get_embedded() {
        return _embedded;
    }

       /**Inner class**/
    public class Embedded {

        List<Artwork> artworks;

        public List<Artwork> getArtworks() {
               return artworks;
           }
               /**Inner class**/

    }
}
