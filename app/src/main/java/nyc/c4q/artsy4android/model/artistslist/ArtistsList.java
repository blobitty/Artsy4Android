package nyc.c4q.artsy4android.model.artistslist;

public class ArtistsList {
    String total_count;
    Links _links;
    Embedded _embedded;

    public String getTotal_count() {
        return total_count;
    }

    public Links get_links() {
        return _links;
    }

    public Embedded get_embedded() {
        return _embedded;
    }
}
