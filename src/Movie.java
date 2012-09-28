/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/21/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movie {
    String movieName;
    String directorName;
    String movieRating;

    public Movie(String name, String dName, String rating) {
        movieName = name;
        directorName = dName;
        movieRating = rating;
    }

    String displayMovieDetails() {
        String result;
        result = movieName + " " + directorName + " ";
        if (movieRating.equals("N/A"))
            result += (movieRating);
        else {
            for (int counter = 1; counter <= Integer.parseInt(movieRating); counter++)
                result = result + "*";
        }
        return result;
    }
}
