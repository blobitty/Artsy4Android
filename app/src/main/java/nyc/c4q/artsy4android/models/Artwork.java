package nyc.c4q.artsy4android.models;

import java.util.List;

public class Artwork {

    String id;
    String slug;
    String created_art;
    String updated_art;
    String title;
    String category;
    String medium;
    String date;
    Artwork_Dimensions dimensions;
    boolean published;
    String website;
    String signature;
    String series;
    String provenance;
    String literaturel;
    String exhibition_history;
    String collecting_institution;
    String additional_information;
    String image_rights;
    String blurb;
    boolean unique;
    int cultural_maker;
    long iconicity;
    boolean can_inquire;
    boolean can_acquire;
    boolean can_share;
    String sale_message;
    boolean sold;
    List<String> image_versions;
    Links _links;


    /**
     * Getters
     */
    public boolean isPublished() {
        return published;
    }

    public String getWebsite() {
        return website;
    }

    public String getSignature() {
        return signature;
    }

    public String getSeries() {
        return series;
    }

    public String getProvenance() {
        return provenance;
    }

    public String getLiteraturel() {
        return literaturel;
    }

    public String getExhibition_history() {
        return exhibition_history;
    }

    public String getCollecting_institution() {
        return collecting_institution;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public String getImage_rights() {
        return image_rights;
    }

    public String getBlurb() {
        return blurb;
    }

    public boolean isUnique() {
        return unique;
    }

    public int getCultural_maker() {
        return cultural_maker;
    }

    public long getIconicity() {
        return iconicity;
    }

    public boolean isCan_inquire() {
        return can_inquire;
    }

    public boolean isCan_acquire() {
        return can_acquire;
    }

    public boolean isCan_share() {
        return can_share;
    }

    public String getSale_message() {
        return sale_message;
    }

    public boolean isSold() {
        return sold;
    }

    public List<String> getImage_versions() {
        return image_versions;
    }

    public Links get_links() {
        return _links;
    }


    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getCreated_art() {
        return created_art;
    }

    public String getUpdated_art() {
        return updated_art;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getMedium() {
        return medium;
    }

    public String getDate() {
        return date;
    }

    public Artwork_Dimensions getDimensions() {
        return dimensions;
    }
}