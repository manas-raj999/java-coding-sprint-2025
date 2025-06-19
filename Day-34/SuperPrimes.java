import java.util.*;

public class SuperPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> primes = sieveOfEratosthenes(n);
        List<Integer> superPrimes = new ArrayList<>();

        for (int i = 0; i < primes.size(); i++) {
            int position = i + 1;
            if (isPrime(position)) {
                superPrimes.add(primes.get(i));
            }
        }

        for (int i = 0; i < superPrimes.size(); i++) {
            if (i > 0)
                System.out.print(" ");
            System.out.print(superPrimes.get(i));
        }
        System.out.println();
    }

    static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    static boolean isPrime(int num) {
        if (num < 2)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
