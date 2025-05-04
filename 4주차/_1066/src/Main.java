import java.util.*;
import java.io.*;

public class Main {
    public static ArrayList<Integer> [] tree;
    public static boolean [] check;
    public static int count =0;

    public static void deleteNode(int idx)
    {
        check[idx]=true;
        for(int x : tree[idx])
        {
            if(!check[x])
            {
                deleteNode(x);
            }
        }
    }


    public static void DFS(int idx)
    {
        int cnt = 0;
        if(check[idx])
            return;

        for(int x : tree[idx])
        {
            if(!check[x])
            {
                DFS(x);
                cnt++;
            }

        }

        if(!check[idx]&&cnt==0)
        {
            count++;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        tree = new ArrayList[n];
        check = new boolean[n];
        int root =0;
        String [] line = br.readLine().trim().split(" ");

        for(int i=0; i<n; i++)
        {
            tree[i]=new ArrayList<>();
        }

        for(int i=0; i<n; i++)
        {
            int x = Integer.parseInt(line[i]);
            if(x==-1)
            {
                root = i;
            }
            else
            {
                tree[x].add(i);
            }
        }

        int deleteIDX= Integer.parseInt(br.readLine().trim());

        deleteNode(deleteIDX);
        DFS(root);

        System.out.println(count);


    }
}