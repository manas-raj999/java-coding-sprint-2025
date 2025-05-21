import java.util.Scanner;
import java.util.LinkedHashSet;

public class VowelPatientNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        LinkedHashSet<String> uniqueVowelNames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.next().toLowerCase();

            if (startsWithVowel(name)) {
                uniqueVowelNames.add(name);
            }
        }

        scanner.close();

        System.out.print(uniqueVowelNames.size());

        for (String name : uniqueVowelNames) {
            System.out.print(" " + name);
        }
        System.out.println();
    }

    public static boolean startsWithVowel(String name) {
        if (name.isEmpty()) {
            return false;
        }

        char firstChar = name.charAt(0);
        return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
                firstChar == 'o' || firstChar == 'u';
    }
}
