import java.util.*;
import java.io.*;




public class Main {
    static int N;
    static int [][]consultant;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        consultant = new int [N+1][2];
        int [] dp = new int[N+2];

        for(int i=1;i<=N; i++)
        {
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            consultant[i][0]=t;
            consultant[i][1]=p;

        }
        for(int i=1; i<=N; i++)
        {


            int next=i+consultant[i][0];
            int cost=consultant[i][1];
            if(next<=N+1)
            {
                dp[next]=Math.max(dp[next],dp[i]+cost);
            }
            dp[i+1]=Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[N+1]); //최대 수익 반영




    }


}