public class Series extends AMedia{
    public int episode;
    public int season;

    public Series(String name,  int releaseYear, String category,int rating, int season, int episode) {
        super(name, releaseYear, category,rating);


        this.season = season;
        this.episode = episode;

    }
}
