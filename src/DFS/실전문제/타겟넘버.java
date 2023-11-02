package DFS.실전문제;

public class 타겟넘버 {

    /**
     * count : 전역변수
     * dfs : 깊이 우선 탐색을 위한 재귀 함수
     * depth : 이지트리 깊이
     * sum : 이전 노드의 합계
     */

    static int count = 0;

    public static int solution(int[] numbers, int target) {

        //dfs 함수 실행
        dfs(numbers, target, 0, 0);

        return count;
    }

    public static void dfs(int[] numbers, int target, int level, int sum) {
        // 배열 마지막 노드까지 탐색이 끝났는지 체크
        if (level == numbers.length) {

            // 합계와 타겟 값이 같으면 count을 1 증가
            if (sum == target) {
                count++;
            }

        } else {
            // 노드값을 더한 경우 다음값 탐색 (재귀호출)
            dfs(numbers, target, level + 1, sum + numbers[level]);
            // 노드값을 뺀 경우 다음값 탐색 ( 재귀호출)
            dfs(numbers, target, level + 1, sum - numbers[level]);
        }
    }


    public static void main(String[] args) {
        int[] numbers2 = {1, 1, 1, 1, 1};

        int solution = solution(numbers2, 3);
        System.out.println("solution = " + solution);



    }
}
