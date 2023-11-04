package BFS.실전문제.PROGRAMMERS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {


    /**
     * @param n : 컴퓨터 갯수
     * @param computers : 연결정보
     * @return 연결된 내트워크 개수
     */

    /**
     * 예시 1)
     *  n : 3,
     *  computers : [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
     *  return : 2
     */

    /**
     * 예시 2)
     *  n : 3,
     *  computers : [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
     *  return : 1
     */

    public static int solution(int n, int[][] computers){


        int answer = 0;

        return answer;


    }

    static void bfs(int n, int[][] computers){

        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[computers.length][computers[0].length];

        int startX = 0;

        // 시작점은 1로 초기화
        visited[0][0] = 1;

        // [1,1,0]
        queue.offer(new int[startX]);

        while(!queue.isEmpty()){

            // 큐에 값 빼기
            int[] temp = queue.remove();




            for (int i = 0; i < temp.length; i++) {

            }


        }

    }

    public static void main(String[] args) {



        int n = 3;

        int[][] computers1 = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] computers2 = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};

        solution(n,computers1);
    }

}
