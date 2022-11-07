public class Series extends AMedia{
    public int episode;
    public int season;

    public Series(String name, int rating, int releaseYear, String category, int episode, int season) {
        super(name, rating, releaseYear, category);

        this.episode = episode;
        this.season = season;


    }
}
