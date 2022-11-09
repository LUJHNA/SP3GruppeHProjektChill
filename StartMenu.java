

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {

        ArrayList<AMedia> movies = new ArrayList<>();
        ArrayList<AMedia> series = new ArrayList<>();

        MainMenu menu = new MainMenu();
        menu.createMovies(movies);
        menu.createSeries(series);



        loginAndRegister();
        setupSearch(movies, series);


    }

    public static void loginAndRegister() {
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

                while (reader.hasNextLine()) {
                    String d = reader.nextLine();
                    String[] s = d.split(",");
                    if (s[0].equals(userName2) && s[1].equals(password2)) {
                        System.out.println("Login succesful.");

                    } else {

                        System.out.println("Login not succesful, check username and password");
                        loginAndRegister();
                    }

                }
                reader.close();


            } catch (Exception e) {
                System.out.println("Error");


            }


        }


        if ("W".equalsIgnoreCase(m)) {

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
                loginAndRegister();


            } catch (Exception e) {
                System.out.println("Error");

            }


        }


    }

    public static void setupSearch(ArrayList<AMedia> media, ArrayList<AMedia> media2) {
        MainMenu mainMenu = new MainMenu();
        String x = mainMenu.seriesOrMovie();

        if (x.equals("movies")) {

            String x1 = mainMenu.searchByNameOrCategory();

            if (x1.equals("name")) {

                String x2 = mainMenu.searchByName(media);
                System.out.println("Found " + x2);
                System.out.println("Play: " + x2 + "? yes or no, enter answer");
                String x3 = mainMenu.yesOrNo();
                if (x3.equals("yes")) {
                    System.out.println("Playing " + x2);

                }

                if (x3.equals("no")) {
                    System.out.println("Search again");
                    setupSearch(media, media2);
                }

            }

            if (x1.equals("category")) {
                ArrayList<String> x4 = mainMenu.searchByCategory(media);
                if (x4.isEmpty()) {
                    System.out.println("Please type in a valid category such as Action, Drama, Romance");
                    x4 = mainMenu.searchByCategory(media);

                }


                System.out.println("Found: " + x4 + "\n");
                System.out.println("Enter chosen movie");
                Scanner sc = new Scanner(System.in);
                String y = sc.nextLine();
                for (int i = 0; i < x4.size(); i++) {
                    if (y.equalsIgnoreCase(x4.get(i))) {
                        System.out.println("Play " + x4.get(i) + "? yes or no, enter answer");
                        String x5 = mainMenu.yesOrNo();

                        if (x5.equals("yes")) {
                            System.out.println("Playing: " + x4.get(i));

                        }


                        if (x5.equals("no")) {
                            System.out.println("Search again");
                            setupSearch(media, media2);

                        }


                    }


                }


            }

        }

//TODO Fix this to fit series instead of movies.

        if (x.equals("series")) {
            String x1 = mainMenu.searchByNameOrCategory();

            if (x1.equals("name")) {

                String x2 = mainMenu.searchByName(media);
                System.out.println("Found " + x2);
                System.out.println("Play: " + x2 + "? yes or no, enter answer");
                String x3 = mainMenu.yesOrNo();
                if (x3.equals("yes")) {

                    //ASK WHICH SEASON AND EPISODE TO PLAY
                    System.out.println("Playing " + x2);

                }

                if (x3.equals("no")) {
                    System.out.println("Search again");
                    setupSearch(media, media2);
                }

            }

            if (x1.equals("category")) {
                ArrayList<String> x4 = mainMenu.searchByCategory(media);
                System.out.println("Found: " + x4 + "\n");
                System.out.println("Enter chosen series");
                Scanner sc = new Scanner(System.in);
                String y = sc.nextLine();
                for (int i = 0; i < x4.size(); i++) {
                    if (y.equalsIgnoreCase(x4.get(i))) {
                        System.out.println("Play " + x4.get(i) + "? yes or no, enter answer");
                        String x5 = mainMenu.yesOrNo();

                        if (x5.equals("yes")) {
                            System.out.println("Playing: " + x4.get(i));

                        }


                        if (x5.equals("no")) {
                            System.out.println("Search again");
                            setupSearch(media, media2);

                        }


                    }


                }


            }

        }
    }
}