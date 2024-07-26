import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {

            String word = br.readLine();

            set.add(word);

            StringBuilder sb = new StringBuilder(word);
            String reverseWord = sb.reverse().toString();
            
            if (set.contains(reverseWord)) {
                System.out.println(reverseWord.length() + " " + reverseWord.charAt(reverseWord.length() / 2));
                break;
            }

        }

    }
}
