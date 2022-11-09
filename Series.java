public class Series extends AMedia{

    public int yearTo;
    public int episodeStart;
    public int episodeEnd;
    public int seasonStart;

    public Series(String name,  int releaseYear, int yearTo, String category,float rating, int seasonStart, int episodeStart, int episodeEnd) {
        super(name, releaseYear, category, rating);


        this.yearTo = yearTo;
        this.seasonStart = seasonStart;
        this.episodeStart = episodeStart;
        this.episodeEnd = episodeEnd;

    }

}
