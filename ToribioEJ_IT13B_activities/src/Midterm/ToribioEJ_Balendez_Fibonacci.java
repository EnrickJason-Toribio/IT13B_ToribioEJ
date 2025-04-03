package Midterm;

public class ToribioEJ_Balendez_Fibonacci {

    public static void main(String[] args) {
        int f = 10;
        for (int n = 0; n < f; n++) {
            System.out.print(f(n) + ", ");
        }
    }

    public static int f(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
}

