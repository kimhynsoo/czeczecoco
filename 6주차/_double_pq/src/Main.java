import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        TreeMap <Integer,Integer> tree = new TreeMap<>();
        for(int i=0; i<operations.length; i++)
        {
            st=new StringTokenizer(operations[i]);
            String operation =st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(operation.equals("I"))
            {
                tree.put(num,tree.getOrDefault(num,0)+1);
            }
            else if(operation.equals("D"))
            {
                if(!tree.isEmpty())
                {
                    if(num==1)
                    {
                        int maxKey=tree.lastKey();
                        if(tree.get(maxKey)==1)
                        {
                            tree.remove(maxKey);
                        }
                        else
                        {
                            tree.put(maxKey,tree.get(maxKey)-1);
                        }
                    }
                    else if(num==-1)
                    {
                        int minKey=tree.firstKey();
                        if(tree.get(minKey)==1)
                        {
                            tree.remove(minKey);
                        }
                        else
                        {
                            tree.put(minKey,tree.get(minKey)-1);
                        }
                    }
                }

            }
        }
        int []answer={};
        if(tree.isEmpty())
        {
            answer=new int[]{0,0};
        }
        else
        {
            answer = new int[]{tree.lastKey(),tree.firstKey()};
        }

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {

        Solution s =new Solution();
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] result = s.solution(operations);
        System.out.println(Arrays.toString(result));

    }
}