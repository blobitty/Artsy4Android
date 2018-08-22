package nyc.c4q.artsy4android.models;

public class Links {
    Thumbnail thumbnail;
    Img image;
    Partner partner;
    Self self;
    Permalink permalink;
    Genes genes;
    Artists artists;
    Similar_Artworks similar_artworks;
    Collection_Users collection_users;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public Img getImage() {
        return image;
    }

    public Partner getPartner() {
        return partner;
    }

    public Self getSelf() {
        return self;
    }

    public Permalink getPermalink() {
        return permalink;
    }

    public Genes getGenes() {
        return genes;
    }

    public Artists getArtists() {
        return artists;
    }

    public Similar_Artworks getSimilar_artworks() {
        return similar_artworks;
    }

    public Collection_Users getCollection_users() {
        return collection_users;
    }

    public class Thumbnail{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Img{
        String href;
        boolean templated;

        public boolean isTemplated() {
            return templated;
        }

        public String getHref() {
            return href;
        }
    }
    public class Partner{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Self{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Permalink{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Genes{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Artists{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Similar_Artworks{
        String href;

        public String getHref() {
            return href;
        }
    }
    public class Collection_Users{
        String href;

        public String getHref() {
            return href;
        }
    }
}
