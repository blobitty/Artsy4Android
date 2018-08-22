package nyc.c4q.artsy4android.models;

public class ArtistsList {
    String total_count;
    ArtistList_Links _links;
    Embedded _embedded;

    public String getTotal_count() {
        return total_count;
    }

    public ArtistList_Links get_links() {
        return _links;
    }

    public Embedded get_embedded() {
        return _embedded;
    }
}
