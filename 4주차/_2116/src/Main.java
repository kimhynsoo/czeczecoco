import java.io.*;
import java.util.Stack;

public class Main {

    static int [][]  dice;
    static int max=-1;
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine().trim());

        dice = new int[n][6];

        for(int i=0; i<n; i++)
        {
            String [] line = br.readLine().trim().split(" ");
            for(int j=0; j< 6; j++)
            {
                dice[i][j]=Integer.parseInt(line[j]);
            }
        }

        for(int i=0; i<6; i++)
        {
            search(0,i,0);
            if(max==6*n)
                break;

        }

        System.out.println(max);
    }

    static void search(int cnt,int bottom, int sum)
    {
        int top = pair(bottom);
        int temp_max=0;
        for(int i=0; i<6; i++)
        {
            if(i==bottom||i==top)
                continue;
            else
                temp_max=Math.max(temp_max,dice[cnt][i]);

        }
        sum+=temp_max;
        if(cnt==n-1)
        {
            max=Math.max(sum,max);
            return;
        }
        for(int i=0; i<6; i++)
        {
            if(dice[cnt][top]==dice[cnt+1][i])
            {
                search(cnt+1,i,sum);
                break;
            }
        }


    }

    static int pair(int n)
    {
        if(n==0)
            return 5;
        else if(n==1)
            return 3;
        else if(n==2)
            return 4;
        else if(n==3)
            return 1;
        else if(n==4)
            return 2;
        else
            return 0;
    }
}