import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeypadCombinations {
    private static Map<Character, String> keypadMap = new HashMap<>();

    static {
        keypadMap.put('2', "abc");
        keypadMap.put('3', "def");
        keypadMap.put('4', "ghi");
        keypadMap.put('5', "jkl");
        keypadMap.put('6', "mno");
        keypadMap.put('7', "pqrs");
        keypadMap.put('8', "tuv");
        keypadMap.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();

        ArrayList<String> result = letterCombinations(digits);
        System.out.println(result);
    }

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, ArrayList<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = keypadMap.get(digit);

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
