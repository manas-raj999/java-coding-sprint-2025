import java.util.Scanner;

public class ReverseCleanSpeech {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String speechLine = scanner.nextLine();
        scanner.close();

        String result = reverseWords(speechLine);
        System.out.println(result);
    }

    public static String reverseWords(String speechLine) {
        String[] words = speechLine.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
