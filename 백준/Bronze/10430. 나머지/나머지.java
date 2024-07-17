import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = array[0];
        int B = array[1];
        int C = array[2];

        sb.append(firstMethod(A, B, C)).append("\n")
                .append(secondMethod(A, B, C)).append("\n")
                .append(thirdMethod(A, B, C)).append("\n")
                .append(fourthMethod(A, B, C)).append("\n");

        System.out.println(sb);

    }

    static int firstMethod(int A, int B, int C) {
        return (A + B) % C;
    }

    static int secondMethod(int A, int B, int C) {
        return ((A % C) + (B % C)) % C;
    }

    static int thirdMethod(int A, int B, int C) {
        return (A * B) % C;
    }

    static int fourthMethod(int A, int B, int C) {
        return ((A % C) * (B % C)) % C;
    }
}
