import java.util.Scanner;

public class RecursiveRoyalScribe {
    private static String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private static String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private static String[] thousands = { "", "Thousand", "Million", "Billion" };

    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return convertToWords(num).trim();
    }

    private static String convertToWords(int num) {
        if (num == 0)
            return "";
        if (num < 20)
            return ones[num] + " ";
        if (num < 100)
            return tens[num / 10] + " " + convertToWords(num % 10);
        if (num < 1000)
            return ones[num / 100] + " Hundred " + convertToWords(num % 100);

        for (int i = 3; i >= 1; i--) {
            int unit = (int) Math.pow(1000, i);
            if (num >= unit) {
                return convertToWords(num / unit) + thousands[i] + " " + convertToWords(num % unit);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(numberToWords(num));
        sc.close();
    }
}
