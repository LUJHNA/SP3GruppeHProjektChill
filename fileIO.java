import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class fileIO {

    public static ArrayList<String> readMovieData() {
        File movieFile = new File("listOfMovies");
        ArrayList<String> movieData = new ArrayList<>();
        try {
            Scanner input = new Scanner(movieFile);
            input.nextLine();//ignorer header

            while (input.hasNextLine()) {
                movieData.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            movieData = null;
        }
        return movieData;
    }

    public static ArrayList<String> readSeriesData() {
        File seriesFile = new File("listOfSeries");
        ArrayList<String> seriesData = new ArrayList<>();
        try {
            Scanner input = new Scanner(seriesFile);
            input.nextLine();//ignorerer header

            while (input.hasNextLine()) {
                seriesData.add(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            seriesData = null;
        }
        return seriesData;
    }
    public void loginMethodTextFile() {
        Scanner login = new Scanner(System.in);
        System.out.println("Enter User name");
        String userName2 = login.nextLine();

        System.out.println("Enter password");
        String password2 = login.nextLine();

        try {
            File file = new File("Usernames.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String d = reader.nextLine();
                String[] s = d.split(",");
                if (s[0].equals(userName2) && s[1].equals(password2)) {
                    System.out.println("Login successful.");
                } else {
                    System.out.println("Login not successful, check username and password");

                }

            }
            reader.close();


        } catch (Exception e) {
            System.out.println("Error");


        }

    }

   public void registerMethodTextFile(ArrayList<Movie> movies, ArrayList<Series> series, User currentUser) {

        StartMenu menu = new StartMenu();
        Scanner login = new Scanner(System.in);
        System.out.println("Enter new User Name");
       String userName = login.nextLine();
       System.out.println("Enter new password");
       String password = login.nextLine();
       try {
           Writer writer = new FileWriter("UserNames.txt");
           writer.write(userName);
           writer.write(",");
           writer.write(password);
           writer.close();
           menu.loginAndRegister(movies, series, currentUser);


       } catch (Exception e) {
           System.out.println("Error");

       }


   }

}

