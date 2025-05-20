import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class EmotionalBalanceString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        HashSet<Integer> frequencies = new HashSet<>();

        for (int frequency : frequencyMap.values()) {
            frequencies.add(frequency);
        }

        if (frequencies.size() == 1) {
            System.out.println("Aashriya smiles: Emotional balance found.");
        } else {
            System.out.println("Aashriya wonders: These thoughts were scattered.");
        }

        scanner.close();
    }
}
