import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 데이터 입력받기
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int W = Integer.parseInt(str[1]);

        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int[][] world = new int[H][W];

        for (int i = 0; i < W; i++) {

            for (int j = H - 1; j >= H - heights[i]; j--) {
                world[j][i] = 1;

            }

        }

        int count = 0;

        for(int i = world.length-1 ; i >= 0 ; i-- ){

            int start = 0;
            int end = 0;
            boolean normal = false;

            for (int j = 0; j < world[0].length - 1; j++) {
                if(world[i][j] == 1 && world[i][j+1] == 0){
                    start = j;
                    normal = true;
                }
                if(normal && world[i][j] == 0 && world[i][j+1] == 1){
                    end = j+1;
                    count += end - start - 1;

                }
            }
        }

        System.out.println(count);

    }
}
