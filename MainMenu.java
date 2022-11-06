import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {



    public String searchByNameMovie(ArrayList<Movie> movies) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your search");
        String x = s.nextLine();
        System.out.println("search by name");
       for(int i = 0; i < movies.size(); i++) {
           if (movies.get(i).name.equalsIgnoreCase(x)) {
               return x;

           }

       }

      return null;
    }

    // SearchByNameSeries her. ikke implementeret endnu.


    public String seriesOrMovie() {

        Scanner s = new Scanner(System.in);
        System.out.println("Choose to watch series or movies by entering which one");
        String c = s.nextLine();
        if (c.equalsIgnoreCase("series")) {
            System.out.println("You chose series");
            return "series";
        }

       if (c.equalsIgnoreCase("movies")) {
           System.out.println("You chose movies");
           return "movies";

       }

      return null;

    }


}
