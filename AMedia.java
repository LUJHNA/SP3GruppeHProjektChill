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



}
