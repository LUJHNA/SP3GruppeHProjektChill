

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class StartMenu {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Series> series = new ArrayList<>();
        MainMenu menu = new MainMenu();

        menu.createMovies(movies);
        menu.createSeries(series);


        loginAndRegister();
        setupSearch(movies, series, users);


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
                        System.out.println("Login successful.");
                    } else {
                        System.out.println("Login not successful, check username and password");
                        loginAndRegister();
                    }

                }
                reader.close();


            } catch (Exception e) {
                System.out.println("Error");


            }


        } else if ("W".equalsIgnoreCase(m)) {

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


        } else {
            System.out.println("not valid input");
            loginAndRegister();

        }


    }

    public static void setupSearch(ArrayList<Movie> media, ArrayList<Series> media2, ArrayList<User> users) {
        MainMenu mainMenu = new MainMenu();
        String x = mainMenu.seriesOrMovie();
        mainMenu.makeUser(users);


        if (x.equals("movies")) {

            String x1 = mainMenu.searchByNameOrCategory();

            if (x1.equals("name")) {

                String x2 = mainMenu.searchByNameMovies(media);
                System.out.println("Found " + x2);
                System.out.println("Play: " + x2 + "? yes or no or save, enter answer");
                String x3 = mainMenu.yesOrNo();
                if (x3.equals("yes")) {
                    System.out.println("Playing " + x2);
                    users.get(0).seenMovies.add(x2);
                    System.out.println("Added movie to seen movies");
                    setupSearch(media, media2, users);


                }

                else if (x3.equals("no")) {
                    System.out.println("Search again");
                    setupSearch(media, media2, users);
                }

                else if (x3.equalsIgnoreCase("Save")) {
                    System.out.println("Saved movie");
                    users.get(0).savedMovies.add(x2);
                    setupSearch(media,media2,users);

                }

            }

            if (x1.equals("category")) {
                ArrayList<String> x4 = mainMenu.searchByCategoryMovies(media);
                if (x4.isEmpty()) {
                    System.out.println("Please type in a valid category such as Action, Drama, Romance");
                    x4 = mainMenu.searchByCategoryMovies(media);

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
                            users.get(0).seenMovies.add(x4.get(i));
                            System.out.println("Added " + x4.get(i) + "to seen movies");
                            setupSearch(media, media2, users);
                        }


                        if (x5.equals("no")) {
                            System.out.println("Search again");
                            setupSearch(media, media2, users);

                        }

                        if (x5.equalsIgnoreCase("Save")) {
                            System.out.println("Saved movie");
                            users.get(0).savedMovies.add(x4.get(i));
                            setupSearch(media,media2,users);

                        }


                    }


                }


            }

        }

//TODO Fix this to fit series instead of movies.

        if (x.equals("series")) {
            String x1 = mainMenu.searchByNameOrCategory();

            if (x1.equals("name")) {

                String x2 = mainMenu.searchByNameSeries(media2);
                System.out.println("Found " + x2);
                System.out.println("Play: " + x2 + "? yes or no or save. enter answer");
                String x3 = mainMenu.yesOrNo();
                if (x3.equals("yes")) {

                    System.out.println("Which season to play and episode to play? Write Season + episode");

                    Scanner scanner = new Scanner(System.in);
                    String s1 = scanner.nextLine();

                    System.out.println("Playing " + x2 + " and " + s1);
                    users.get(0).seenSeries.add(x2);
                    System.out.println("Added " + x2 + " to seen series");
                    setupSearch(media, media2, users);
                }

               else if (x3.equals("no")) {
                    System.out.println("Search again");
                    setupSearch(media, media2, users);
                }

               else if (x3.equalsIgnoreCase("Save")) {
                    System.out.println("Saved series");
                    users.get(0).savedSeries.add(x2);
                    setupSearch(media,media2,users);

                }

            } else if (x1.equals("category")) {
                ArrayList<String> x4 = mainMenu.searchByCategorySeries(media2);
                System.out.println("Found: " + x4 + "\n");
                System.out.println("Enter chosen series");
                Scanner sc = new Scanner(System.in);
                String y = sc.nextLine();
                for (int i = 0; i < x4.size(); i++) {
                    if (y.equalsIgnoreCase(x4.get(i))) {
                        System.out.println("Play " + x4.get(i) + "? yes or no, or enter 'save' to save it, enter answer");

                        String x5 = mainMenu.yesOrNo();

                        if (x5.equals("yes")) {

                            System.out.println("Which season to play and episode to play? Write Season + episode");

                            Scanner scanner2 = new Scanner(System.in);
                            String s2 = scanner2.nextLine();

                            System.out.println("PLaying " + x4.get(i) + "and " + s2);
                            System.out.println("Added " + x4.get(i) + "to seen series");
                            users.get(0).seenSeries.add(x4.get(i));
                            setupSearch(media, media2, users);
                        }


                       else if (x5.equals("no")) {
                            System.out.println("Search again");
                            setupSearch(media, media2, users);

                        }

                        else if (x5.equalsIgnoreCase("Save")) {
                            System.out.println("Saved series");
                            users.get(0).savedSeries.add(x4.get(i));
                            setupSearch(media,media2,users);

                        }


                    }


                }


            }


        }
        else if (x.equalsIgnoreCase("seen movies")) {
            System.out.println(users.get(0).seenMovies);

        }

        else if (x.equalsIgnoreCase("saved movies")) {
            System.out.println(users.get(0).savedMovies);

        }

        else if (x.equalsIgnoreCase("seen series")) {
            System.out.println(users.get(0).seenSeries);

        }

        else if (x.equalsIgnoreCase("saved series")) {
            System.out.println(users.get(0).savedSeries);

        }
    }
}