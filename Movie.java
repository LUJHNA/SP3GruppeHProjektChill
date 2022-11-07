public class Movie extends AMedia {


    public Movie(String name, int releaseYear, String category, int rating) {
        super(name, releaseYear, category, rating);
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

}





