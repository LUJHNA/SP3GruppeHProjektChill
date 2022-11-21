import java.sql.*;
import java.util.ArrayList;

public class MediaDB {

    Connection connection;

    String url = "jdbc:mysql://localhost/media?" + "autoReconnect=true&useSSL=false";
    String userName = "root";
    String password = "1234morten";


    public void createMovies2(ArrayList<Movie> movies ) {

        establishConnection();
        String query = "SELECT * FROM listofmovies";

        try {
            PreparedStatement query2 = connection.prepareStatement(query);



            ResultSet resultSet = query2.executeQuery();
            while(resultSet.next()) {

                String movieName = resultSet.getString("name");
                int movieRelease = resultSet.getInt("releaseYear");
                String movieCategory = resultSet.getString("category");
                int movieRating = resultSet.getInt("rating");
                Movie movie = new Movie(movieName, movieRelease, movieCategory, movieRating);
                movies.add(movie);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }








    }


    public void createSeries2(ArrayList<Series> series) {

        establishConnection();
        String query = "SELECT * FROM listofseries";

        try {
            PreparedStatement query2 = connection.prepareStatement(query);



            ResultSet resultSet = query2.executeQuery();
            while(resultSet.next()) {

                String seriesName = resultSet.getString("name");
                int seriesRelease = resultSet.getInt("releaseYear");
                int seriesTo = resultSet.getInt("yearTo");
                String seriesCategory = resultSet.getString("category");
                int seriesRating = resultSet.getInt("rating");
                String seasonSeries = resultSet.getString("seasons");

                ArrayList<Season> listOfSeasons = new ArrayList<>();
                String [] series2 = seasonSeries.trim().split(",");

                for (int i = 0; i < series2.length-1; i++){
                    String [] episodes = series2[i].trim().split("-");
                    int seasonNumber = Integer.parseInt(episodes[0]);
                    int episodeNumber = Integer.parseInt(episodes[1]);

                    Season season = new Season(seasonNumber, episodeNumber);
                    listOfSeasons.add(season);


                }




                Series series1 = new Series(seriesName, seriesRelease, seriesTo, seriesCategory, seriesRating, listOfSeasons);
                series.add(series1);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }







    private void establishConnection() {

        try {
            connection = DriverManager.getConnection(url, userName, password);


        } catch (SQLException e) {
            e.printStackTrace();


        }
    }


}
