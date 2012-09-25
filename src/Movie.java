/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/21/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movie {
    private String movieName;
    private String directorName;
    private String movieRating;

    public Movie(String name,String dName,String rating)
    {
        movieName=name;
        directorName=dName;
        movieRating=rating;
    }

    public void displayMovieDetails()
    {
        System.out.print(movieName+" "+directorName+" ");
        if(movieRating.equals("N/A"))
            System.out.println(movieRating);
        else
        {
            for(int counter=1;counter<=Integer.parseInt(movieRating);counter++)
                System.out.print("*");
            System.out.print(System.getProperty("line.separator"));

        }
    }

}
