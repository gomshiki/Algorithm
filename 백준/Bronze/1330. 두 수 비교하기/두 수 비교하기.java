import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a = array[0];
        int b = array[1];

        if(a > b){
            sb.append(">");
        }else if(a < b){
            sb.append("<");
        }else{
            sb.append("==");
        }

        System.out.println(sb.toString());
    }

}
