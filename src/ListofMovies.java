import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ListofMovies {

    private ArrayList <String> movies;

    //scanning the file
    public ListofMovies (String pathname) {
        movies = new ArrayList<>();
        File file = new File("movies.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                movies.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }
    //picking a random mmovie title
    public String getRandomMovie() {
        int movieIndex = (int) (Math.random() * movies.size());
        return movies.get(movieIndex);
    }
}
