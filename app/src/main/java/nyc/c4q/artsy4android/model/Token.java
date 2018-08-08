package nyc.c4q.artsy4android.model;

public class Token {

    private String type;
    private String token;
    private String expires_at;
    private Links _links;
    private String client_id;
    private String client_secret;

    public Token(String client_id, String client_secret){
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

    public Links get_links() {
        return _links;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public String getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public String getExpires_at() {
        return expires_at;
    }

    private class Links {
    }
}
