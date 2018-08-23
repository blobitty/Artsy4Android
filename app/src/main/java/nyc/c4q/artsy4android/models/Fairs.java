package nyc.c4q.artsy4android.models;

public class Fairs {
    String created_at;
    String updated_at;
    String name;
    String about;
    String contact;
    String summary;
    String start_at;
    String end_at;
    String status;
    boolean published;
    Fairs_Links _links;
    String id;


    public String getId() {
        return id;
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

    public String getAbout() {
        return about;
    }

    public String getContact() {
        return contact;
    }

    public String getSummary() {
        return summary;
    }

    public String getStart_at() {
        return start_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public String getStatus() {
        return status;
    }

    public boolean isPublished() {
        return published;
    }

    public Fairs_Links get_links() {
        return _links;
    }
    /**
     * Inner Class(1)
     */
    public class Fairs_Links {

        Self self;
        Shows shows;

        public Self getSelf() {
            return self;
        }

        public Shows getShows() {
            return shows;
        }

        /**
         * Inner Inner Classes(2)
         */
        public class Self {
            String href;

            public String getHref() {
                return href;
            }
        }
        public class Shows {
            String href;

            public String getHref() {
                return href;
            }
        }
    }
}
