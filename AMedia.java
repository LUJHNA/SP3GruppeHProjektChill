public abstract class AMedia {
    public String name;
    public int rating;

    public int releaseYear;

    public String category;

    public AMedia(String name, int releaseYear, String category, int rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
