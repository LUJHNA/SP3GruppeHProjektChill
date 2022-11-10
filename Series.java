import java.util.ArrayList;

public class Series extends AMedia {

    public int yearTo;
    public ArrayList<Season> seasons;

    public Series(String name, int releaseYear, int yearTo, String category, float rating, ArrayList<Season> seasons) {
        super(name, releaseYear, category, rating);
        this.yearTo = yearTo;
        this.seasons = seasons;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public int getNumberOfSeasons() {
        return this.seasons.size();
    }

}
