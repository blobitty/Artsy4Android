package nyc.c4q.artsy4android.model.artistslist;

public class Links {
    Self self;
    Next next;

    private class Next {
        String href;
    }
    private class Self {
        String href;

        public String getSelfHref() {
            return href;
        }
        public String getNextHref() {
            return href;
        }

    }
    public Self getSelf() {
        return self;
    }

    public Next getNext() {
        return next;
    }
}
