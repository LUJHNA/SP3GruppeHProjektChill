import com.sun.tools.javac.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();
        Movie m1 = new Movie("Titanic", 1997,"Drama",10);
        Movie m2 = new Movie("Kage", 1990, "Drama", 7);
        movies.add(m1);
        movies.add(m2);


        Scanner login = new Scanner(System.in);

        System.out.println("Enter Q for login or W to register.");

        String m = login.nextLine();

        if ("Q".equalsIgnoreCase(m)) {

                System.out.println("Enter User name");
                String userName2 = login.nextLine();

                System.out.println("Enter password");
                String password2 = login.nextLine();

                try {
                    File file = new File("Usernames.txt");
                    Scanner reader = new Scanner(file);

                    while(reader.hasNextLine()) {
                        String d = reader.nextLine();
                        String [] s = d.split(",");
                        if (s[0].equals(userName2) && s[1].equals(password2)) {
                            System.out.println("Login succesful.");




                            MainMenu mainMenu = new MainMenu();
                            String x = mainMenu.seriesOrMovie();

                            if (x.equals("movies")) {

                                ArrayList y = mainMenu.searchByCategory(movies);
                                System.out.println("Found " + y);

                            }

                            // if (x.equals(series)) ikke implementeret endnu.


                        } else {

                            System.out.println("Login not succesful, check username and password");
                        }

                    }
                    reader.close();


                } catch (Exception e) {
                    System.out.println("Error");



                }



        }


         if  ("W".equalsIgnoreCase(m)) {

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


            } catch (Exception e) {
                System.out.println("Error");

            }


        }
    }
}