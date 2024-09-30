import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] board) {
        // O, X 개수 세기
        int oCnt = 0, xCnt = 0;
        for(String str : board){
            for(char c : str.toCharArray()){
                if(c == 'O') oCnt++;
                if(c == 'X') xCnt++;
            }
        }
        
        // X가 O보다 많아서는 안됨, O 가 X보다 정확히 1개 많거나 같아야함
        if (xCnt > oCnt || oCnt - xCnt > 1) return 0;
        
        boolean oWin = isWin(board, 'O');
        boolean xWin = isWin(board, 'X');
        
        // 둘다 승리하면 안됨
        if(oWin && xWin) return 0;
        // O가 승리했을때 O가 X보다 1개 많아야함
        if(oWin && oCnt != xCnt + 1) return 0;
        // X가 승리했을때 O와 X 개수는 같아야함
        if(xWin && oCnt != xCnt) return 0;
        return 1;
    }
    
    private boolean isWin(String[] board, char ch){
        // 가로, 세로, 대각선 모든 승리조건 확인
        for(int i = 0 ; i < 3 ;i++){
            // 가로
            if(   board[i].charAt(0) == ch
               && board[i].charAt(1) == ch
               && board[i].charAt(2) == ch
              ) {
                return true;
            }
            // 세로
            if(  board[0].charAt(i) == ch
              && board[1].charAt(i) == ch
              && board[2].charAt(i) == ch
              ){
                return true;
            } 
        }
        // 대각선
        if(board[0].charAt(0) == ch){
            if(board[1].charAt(1) == ch){
                if(board[2].charAt(2) == ch){
                    return true;
                }
            }
        }
        if(board[0].charAt(2) == ch){
            if(board[1].charAt(1) == ch){
                if(board[2].charAt(0) == ch){
                    return true;
                }
            }
        }
        return false;
    }
}