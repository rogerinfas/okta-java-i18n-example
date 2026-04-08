import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        String language = "en";

        if (args.length == 1) {
            language = args[0];
        }

        var locale = new Locale(language);
        var messages = ResourceBundle.getBundle("quiz", locale);
        var scanner = new Scanner(System.in);

        System.out.println("=== " + messages.getString("title") + " ===\n");

        System.out.println(messages.getString("q1"));
        System.out.print(messages.getString("answer") + " ");
        scanner.nextLine();

        System.out.println(messages.getString("q2"));
        System.out.print(messages.getString("answer") + " ");
        scanner.nextLine();

        System.out.println(messages.getString("q3"));
        System.out.print(messages.getString("answer") + " ");
        scanner.nextLine();

        System.out.println("\n" + messages.getString("thanks"));
        scanner.close();
    }
}
