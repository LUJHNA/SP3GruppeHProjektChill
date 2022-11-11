import java.util.ArrayList;

public class User {

    public static String userName;

    public static String password;

    ArrayList<String> seenMovies = new ArrayList<>();
    
    ArrayList<String> seenSeries = new ArrayList<>();
    
    ArrayList<String> savedMovies = new ArrayList<>();
    
    ArrayList<String> savedSeries = new ArrayList<>();

    public User(String userName, String password, ArrayList<String>seenMovies, ArrayList<String> seenSeries, ArrayList<String> savedMovies, ArrayList<String> savedSeries ) {

        this.userName = userName;
        this.password = password;
        this.seenMovies= seenMovies;
        this.seenSeries = seenSeries;
        this.savedMovies = seenMovies;
        this.savedSeries = savedSeries;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getSeenMovies() {
        return seenMovies;
    }

    public void setSeenMovies(ArrayList<String> seenMovies) {
        this.seenMovies = seenMovies;
    }
    
    


}
