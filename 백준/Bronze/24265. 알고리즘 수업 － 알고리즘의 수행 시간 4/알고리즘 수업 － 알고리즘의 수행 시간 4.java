import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        System.out.println((n * (n - 1l) / 2l + "\n" + 2));
    }
}


