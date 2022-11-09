import java.util.ArrayList;

public class User {

    public static String userName;

    public static String password;

    ArrayList<AMedia> seenMovies = new ArrayList<>();

    public User(String userName, String password, ArrayList<AMedia>seenMovies) {

        this.userName = userName;
        this.password = password;
        this.seenMovies= seenMovies;

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

    public ArrayList<AMedia> getSeenMovies() {
        return seenMovies;
    }

    public void setSeenMovies(ArrayList<AMedia> seenMovies) {
        this.seenMovies = seenMovies;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\''+
                '}';
    }
}
