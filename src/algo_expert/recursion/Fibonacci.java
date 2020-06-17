package algo_expert.recursion;

public class Fibonacci {
    public static int getNthFib(int n) {
        if (n == 2)
            return 1;
        if (n == 1)
            return 0;
        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    public static int getNthFibb(int n) {
        int[] lastTwo = {0, 1};
        int counter   = 3;
        while(counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }
}
