import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {



    public String searchByName(ArrayList<AMedia> movies) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your search");
        String x = s.nextLine();
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
    public ArrayList searchByCategory(ArrayList<AMedia> movies) {

        Scanner s = new Scanner(System.in);
        ArrayList<String> a = new ArrayList<>();
        System.out.println("Enter your search by category");
        String x = s.nextLine();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getCategory().contains(x) || movies.get(i).getCategory().toLowerCase().contains(x) || movies.get(i).getCategory().toUpperCase().contains(x)){
                a.add(movies.get(i).getName());

            }
        }



        return a;

    }

    public String searchByNameOrCategory() {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose to search by name or category by entering which one");
        String c = s.nextLine();
        if (c.equalsIgnoreCase("name")) {
            System.out.println("You chose to search by name");
            return "name";
        }

        if (c.equalsIgnoreCase("category")) {
            System.out.println("You choose to search by category");
            return "category";

        }

        return null;

    }

    public  String yesOrNo() {
        Scanner s = new Scanner(System.in);
        String c = s.nextLine();
        if (c.equalsIgnoreCase("yes")) {
            return "yes";
        }

        if (c.equalsIgnoreCase("no")) {
            return "no";

        }

        return null;





    }

    public static void createMovies(ArrayList<AMedia> movies) {
        try {
            File f = new File("listOfMovies");
            Scanner s = new Scanner(f);


            while (s.hasNextLine()) {
                String[] values;
                values = s.nextLine().trim().split(";");
                String n = values[0];
                int r = Integer.parseInt(values[1]);
                String c = values[2];
                float t = Float.parseFloat(values[3]);

                Movie m = new Movie(n, r, c, t);

                movies.add(m);
            }


        } catch (IOException e) {
            System.out.println("Error");


        }

    }
}

