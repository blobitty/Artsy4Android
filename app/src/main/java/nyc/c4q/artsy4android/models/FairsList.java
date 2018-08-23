package nyc.c4q.artsy4android.models;

public class FairsList {
    String total_count;
    FairsList_Links _links;
    FairsList_Embedded _embedded;


    public String getTotal_count() {
        return total_count;
    }

    public FairsList_Links get_links() {
        return _links;
    }

    public FairsList_Embedded get_embedded() {
        return _embedded;
    }

}
