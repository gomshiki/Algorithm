import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        // Queue에 각 작업의 남은 일수를 저장
        for (int i = 0; i < progresses.length; i++) {
            int remainingDays = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            //int remainingDays = (100 - progresses[i]) / speeds[i];
            
            System.out.println(remainingDays);
            queue.add(remainingDays);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Queue를 통해 작업을 순서대로 확인하면서 배포 가능한 기능을 묶음으로 배포
        while (!queue.isEmpty()) {
            int deployCount = 1; // 첫 번째 기능부터 배포 가능하다고 가정
            int deployTime = queue.poll(); // 첫 번째 기능의 배포에 필요한 시간

            // 첫 번째 작업의 배포 시간보다 빨리 끝나는 작업을 모두 함께 배포
            while (!queue.isEmpty() && queue.peek() <= deployTime) {
                queue.poll();
                deployCount++;
            }

            result.add(deployCount); // 배포한 기능의 개수 추가
        }
        
        // List를 배열로 변환하여 반환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}