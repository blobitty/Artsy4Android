package nyc.c4q.artsy4android.model;

import java.util.List;

import nyc.c4q.artsy4android.model.artworks.Artworks;

public class Artists {
    /**SLUG OR ID VALUE CAN BE USED AS RETROFIT @PARAM TO DIRECT TO INDIVIDUAL POINT
     */
    String id;
    String slug;
    String created_at;
    String updated_at;
    String name;
    String sortable_name;
    String gender;
    String biography;
    String birthday;
    String deathday;
    String hometown;
    String nationality;
    String location;
    String[] image_versions = new String[4];
    Links _links;

    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getName() {
        return name;
    }

    public String getSortable_name() {
        return sortable_name;
    }

    public String getGender() {
        return gender;
    }

    public String getBiography() {
        return biography;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDeathday() {
        return deathday;
    }

    public String getHometown() {
        return hometown;
    }

    public String getLocation() {
        return location;
    }

    public String getNationality() {
        return nationality;
    }

    public String[] getImage_versions() {
        return image_versions;
    }

    public Links get_links() {
        return _links;
    }

    /**
     * Inner Class objects for JSON
     */
    public class Links {
        Thumbnail thumbnail;
        Img image;
        Self self;
        PermaLink permaLink;
        Artworks artworks;
        PublishedArtworks published_artworks;
        SimilarArtists similar_artists;
        SimilarContemporaryArtists similar_contemporary_artists;
        Genes genes;

        /**
         *
         * getters for outerclass
         */
        public Genes getGenes() {
            return genes;
        }

        public SimilarContemporaryArtists getSimilar_contemporary_artists() {
            return similar_contemporary_artists;
        }
        public SimilarArtists getSimilar_artists() {
            return similar_artists;
        }
        public PublishedArtworks getPublished_artworks() {
            return published_artworks;
        }

        public Artworks getArtworks() {
            return artworks;
        }

        public PermaLink getPermaLink() {
            return permaLink;
        }


        public Self getSelf() {
            return self;
        }

        public Img getImage() {
            return image;
        }
        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        /**
         * end of outer class getters
         */

        /**
         * inner class, including getters and inner inner classes
         */
        public class Thumbnail {
            String href;
            public String getHref() {
                return href;
            }
        }

        public class Img {
            String href;
            boolean templated;

            public String getHref() {
                return href;
            }
            public boolean isTemplated() {
                return templated;
            }
        }

        public class Self {
            String href;
            public String getHref() {
                return href;
            }
        }

        public class PermaLink {
            String href;
            public String getHref() {
                return href;
            }
        }

        public class PublishedArtworks {
            String href;
            public String getHref() {
                return href;
            }
            }

        public class SimilarArtists {
            String href;
            public String getHref() {
                return href;
            }
        }

        public class SimilarContemporaryArtists {
            String href;
            public String getHref() {
                return href;
            }
        }

        public class Genes {
            String href;

            public String getHref() {
                return href;
            }
            }
    }
}
