import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HomeworkLesson2 {
    static StringBuilder token = new StringBuilder();
    static Integer[] notAllowedChar = {34, 39, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 92, 93, 95, 96}; //decoding from ASCII table
    static boolean needToGenerateNextTokenCharacter = true;
    static List<Integer> listAllowedChar = Arrays.asList(notAllowedChar);
    static boolean needToTryAgainEnterTokenLength = true;

    static void generateToken(int size) {
        for (int i = 0; i < size; i++) {
            needToGenerateNextTokenCharacter = true;
            while (needToGenerateNextTokenCharacter) {
                int number = (int) ((Math.random() * (123-33)) + 33); //range of decoded characters in ASCII table [33,123)
                if (!listAllowedChar.contains(number)) {
                    token.append((char) number);
                    needToGenerateNextTokenCharacter = false;
                }
            }
        }
    }

    static StringBuilder tokenGenerator() {
        System.out.println("Hello, please type an length of token. Allowed values: 5, 10, 15.");
        System.out.println("Try again or enter 0 to stop the program.");

        while (needToTryAgainEnterTokenLength) {
            Scanner scanner = new Scanner(System.in);
            try {
                while (needToTryAgainEnterTokenLength) {
                    int length = scanner.nextInt();
                    if (length == 5 || length == 10 || length == 15) {
                        generateToken(length);
                        needToTryAgainEnterTokenLength = false;
                    } else if (length == 0) {
                        System.out.println("Program is stopped.");
                        needToTryAgainEnterTokenLength = false;
                    } else {
                        System.out.println("Incorrect value. Allowed values: 5, 10, 15.");
                        System.out.println("Try again or enter 0 to stop the program.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect value. Allowed values: 5, 10, 15.");
                System.out.println("Try again or enter 0 to stop the program.");
            }
        }
        return token;
    }

    public static void main(String[] args) {
        System.out.println(tokenGenerator());
    }
}