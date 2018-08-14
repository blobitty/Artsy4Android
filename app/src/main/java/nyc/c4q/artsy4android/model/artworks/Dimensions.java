package nyc.c4q.artsy4android.model.artworks;

class Dimensions {
    In in;
    Cm cm;

    public In getIn() {
        return in;
    }

    public Cm getCm() {
        return cm;
    }

    public class In {
        String text;
        double height;
        double width;
        double depth;
        double diameter;

        public String getText() {
            return text;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }

        public double getDepth() {
            return depth;
        }

        public double getDiameter() {
            return diameter;
        }
    }

    public class Cm {
        String text;
        double height;
        double width;
        double depth;
        double diameter;

        public String getText() {
            return text;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }

        public double getDepth() {
            return depth;
        }

        public double getDiameter() {
            return diameter;
        }
    }
}
