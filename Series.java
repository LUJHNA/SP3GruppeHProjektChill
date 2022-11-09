public class Series extends AMedia{
    public String episode;
    public String season;

    public Series(String name,  int releaseYear, String category,float rating, String season, String episode) {
        super(name, releaseYear, category,rating);


        this.season = season;
        this.episode = episode;

    }
}
