import java.util.*;

public class AlchemistsFraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.nextLine();
        System.out.println(solveFraction(formula));
    }

    static String solveFraction(String formula) {
        List<String> fractions = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == '+' || c == '-') {
                if (current.length() > 0) {
                    fractions.add(current.toString());
                    current = new StringBuilder();
                }
                if (c == '-')
                    current.append('-');
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            fractions.add(current.toString());
        }

        int resultNum = 0, resultDen = 1;

        for (String frac : fractions) {
            String[] parts = frac.split("/");
            int num = Integer.parseInt(parts[0]);
            int den = Integer.parseInt(parts[1]);

            resultNum = resultNum * den + num * resultDen;
            resultDen = resultDen * den;

            int g = gcd(Math.abs(resultNum), resultDen);
            resultNum /= g;
            resultDen /= g;
        }

        return resultNum + "/" + resultDen;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
