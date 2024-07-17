import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {

            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int avg = avg(array);

            double percent = percent(array, avg);
            System.out.printf("%.3f%%\n",percent);

        }
    }

    static int avg(int[] array) {
        int sum = 0;
        for (int j = 1; j < array.length; j++) {
            sum += array[j];
        }

        return sum / (array.length - 1);
    }

    static double percent(int[] array, int avg) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > avg) {
                count++;
            }
        }
        return count / (double) array[0] * 100;
    }
}
