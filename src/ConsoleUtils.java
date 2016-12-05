import java.io.IOException;
import java.util.Scanner;

public class ConsoleUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntFromUser() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("Wrong input, please try again: ");
        }
        return scanner.nextInt();
    }

    public static int getIntFromUser(int min, int max) {
        int inputtedNumber = getIntFromUser();
        while (inputtedNumber < min || inputtedNumber > max) {
            System.err.print("Wrong input, please try again: ");
            inputtedNumber = getIntFromUser();
        }
        return inputtedNumber;
    }

    public static String getLineFromUser() {
        while (!scanner.hasNextLine()) {
            scanner.next();
            System.err.print("Wrong input, please try again: ");
        }

        String res;

        while ((res = scanner.nextLine()).isEmpty());

        return res;
    }

    public static String getWordFromUser() {
        String res;

        while ((res = scanner.next()).isEmpty());

        return res;
    }

    public static int waitForEnterKeyPress() {
        try {
            return System.in.read();
        } catch (IOException e) {
            return 0;
        }
    }

    public static void clearScreen(){
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
