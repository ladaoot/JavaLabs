package lab1;

public class Primes {
    public static void main(String[] args) {
        for (int i = 2; i < 101; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
