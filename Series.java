public class Series extends AMedia{
    public int episode;
    public int season;

    public Series(String name,  int releaseYear, String category,int rating, int episode, int season) {
        super(name, releaseYear, category,rating);

        this.episode = episode;
        this.season = season;


    }
}
