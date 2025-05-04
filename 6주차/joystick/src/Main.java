import java.util.*;
class Solution {
    public int solution(String name) {
        int n=name.length();
        int answer = 0;
        for(int i=0; i<n; i++)
        { //65~90 "A" ~"Z"
            int ascii=name.charAt(i);
            //answer+=13-Math.abs(78-ascii);
            answer+=Math.min(ascii-'A','Z'-ascii+1);
        }

        int move = n-1; //최대 move
        for(int i=0; i<n; i++)
        {
            //i, n-next , Math.min(i,n-next)
            //일단 i만큼 과 n-next 만큼은 무조건 가야해. 그리고 i에서 왼쪽으로 돌아갈지 n-next에서 오른쪽으로 돌아갈지 짧은 길을 택하는 거야.
            int next=i+1;
            while(next<n && name.charAt(next)=='A')
            {
                next++;
            }
            move=Math.min(move,i+n-next+Math.min(i,n-next));
        }
        answer+=move;

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "ABA";
        System.out.println(s.solution(a));
    }
}