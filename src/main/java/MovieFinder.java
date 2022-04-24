import java.net.URLEncoder;
import java.util.Scanner;
public class MovieFinder {
    public static String movieName;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter movie name: ");
        movieName = scanner.nextLine();
        if (movieName==null || movieName.isEmpty()) {
            System.out.println("Enter correct movie name");
            System.exit(0);
        }
        String urlEncodedStr= URLEncoder.encode(movieName,java.nio.charset.StandardCharsets.UTF_8.name());
        StartMovieFinder movieFinder = new StartMovieFinder(urlEncodedStr);
        System.out.println("Start movie search...");
        movieFinder.start();

    }
}

