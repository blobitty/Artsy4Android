package nyc.c4q.artsy4android.models;

class FairsList_Links {
    Self self;
    Next next;

    public Next getNext() {
        return next;
    }

    public Self getSelf() {
        return self;
    }

    /**
     * Inner Class
     */
    public class Self {

        String href;

        public String getHref() {
            return href;
        }
    }
    /**
     * Inner Class
     */
    public class Next {
        String href;

        public String getHref() {
            return href;
        }
    }
}
