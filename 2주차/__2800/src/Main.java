import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().trim().split("");
        Stack <Integer> bracket_open_count=new Stack<>();

        List<Integer> bracket_open = new ArrayList<>();
        List<Integer> bracket_close = new ArrayList<>();

        for(int i=0; i<input.length; i++)
        {
            if(input[i].equals("("))
            {
                bracket_open_count.push(i);


            } else if (input[i].equals(")"))
            {
                bracket_close.add(i);
                bracket_open.add(bracket_open_count.pop());

            }
        }
        int bracket= bracket_open.size();
        List<List<Integer>> allCombinations= new ArrayList<>();

        for(int r=1; r<=bracket; r++)
        {
            List<Integer> current = new ArrayList<>();
            Combination(bracket,r,1,current,allCombinations);
        }
        List<String> result=new ArrayList<>();
        for(int i=0; i <allCombinations.size();i++)
        {
            removeBracket(result,input,allCombinations.get(i),bracket_open,bracket_close);

        }
        Set<String> set = new HashSet<>(result);
        List<String> UniqueResult = new ArrayList<>(set);

        Collections.sort(UniqueResult);
        for(String s : UniqueResult)
        {
            bw.write(s);
            if(!s.equals(UniqueResult.get(UniqueResult.size()-1)))
            {
                bw.newLine();
            }


        }
        bw.flush();
        bw.close();



    }
    private static void removeBracket(List<String> result,String [] input, List<Integer> combination, List<Integer> open,List<Integer> close)
    {
        StringBuilder sb = new StringBuilder();
        List<Integer> remove_index=new ArrayList<>();
        for (int c : combination)
        {
            remove_index.add(open.get(c-1));
            remove_index.add(close.get(c-1));

        }
        Collections.sort(remove_index);
        for(int i=0; i<input.length; i++)
        {
            if(!remove_index.isEmpty()&&remove_index.get(0)==i)
            {
                remove_index.remove(0);

            }
            else
            {
                sb.append(input[i]);
            }

        }
        result.add(sb.toString());


    }

    private static void Combination(int n,int r, int start, List<Integer> current, List<List<Integer>> result){
        if(current.size()==r){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i= start; i<=n; i++)
        {
            current.add(i);
            Combination(n,r,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
}