public class Series extends AMedia{

    public int yearTo;
    public int episodeStart;
    public int episodeEnd;
    public int season;

    public Series(String name,  int releaseYear, int yearTo, String category,float rating, int season, int episodeStart, int episodeEnd) {
        super(name, releaseYear, category, rating);
        this.yearTo = yearTo;
        this.season = season;
        this.episodeStart = episodeStart;
        this.episodeEnd = episodeEnd;

    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public int getEpisodeStart() {
        return episodeStart;
    }

    public void setEpisodeStart(int episodeStart) {
        this.episodeStart = episodeStart;
    }

    public int getEpisodeEnd() {
        return episodeEnd;
    }

    public void setEpisodeEnd(int episodeEnd) {
        this.episodeEnd = episodeEnd;
    }

    public int getSeason() {
        return season;
    }

    public void setSeasonStart(int season) {
        this.season = season;
    }
}
