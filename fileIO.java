import java.io.File;
import java.io.FileNotFoundException;
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

}

