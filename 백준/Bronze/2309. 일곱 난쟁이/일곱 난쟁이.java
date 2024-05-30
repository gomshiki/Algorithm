import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int totalSum = Arrays.stream(arr).sum();

        int targetSum = totalSum - 100;

        int removeVal1 = 0;
        int removeVal2 = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if(arr[i] + arr[j] == targetSum){
                    removeVal1 = arr[i];
                    removeVal2 = arr[j];
                    break;
                }
            }
        }
        int finalRemoveVal = removeVal1;
        int finalRemoveVal1 = removeVal2;

        Arrays.stream(arr).filter(x -> x != finalRemoveVal && x != finalRemoveVal1).sorted().forEach(System.out::println);



    }
}
