import java.io.*;
import java.util.*;

public class Main {

    static int N,W;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());


        W=Integer.parseInt(st.nextToken());
        int [] count = new int[N+1];
        for(int i=0; i<N-1; i++)
        {
            st=new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            count[u]++;
            count[v]++;

        }

        int w_leaf=0;
        for(int i=2; i<N+1; i++)
        {
            if(count[i]==1)
                w_leaf++;
        }

        System.out.println((double)W/w_leaf);
    }
}