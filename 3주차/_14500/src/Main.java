import java.io.*;
import java.util.*;
public class Main {

    static int max_count=0;

    static boolean [][] visited;
    static int n,m;
    public static void T_shape(int x, int y,Integer [][] matrix)
    {
        int count=0;
        //튀어나온 방향
        //위
        if(x-1>=0 && y-1>=0 && y+1<m)
        {
            count=matrix[x][y]+matrix[x-1][y]+matrix[x][y-1]+matrix[x][y+1];
            if(max_count<=count)
            {
                max_count=count;
            }
        }
        //아래
        if(x+1<n && y-1>=0 && y+1<m)
        {
            count=matrix[x][y]+matrix[x+1][y]+matrix[x][y-1]+matrix[x][y+1];
            if(max_count<=count)
            {
                max_count=count;
            }
        }
        //왼
        if(y-1>=0 && x-1>=0 && x+1<n)
        {
            count=matrix[x][y]+matrix[x][y-1]+matrix[x-1][y]+matrix[x+1][y];
            if(max_count<=count)
            {
                max_count=count;
            }
        }
        //오른
        if(y+1<m && x-1>=0 && x+1<n)
        {
            count=matrix[x][y]+matrix[x][y+1]+matrix[x-1][y]+matrix[x+1][y];
            if(max_count<=count)
            {
                max_count=count;
            }
        }

    }
    public static void DFS(int x, int y,Integer [][] matrix, boolean[][] visited,int move_count,int count)
    {
        int [] dx ={1,0,0,-1};
        int [] dy ={0,1,-1,0};
        count+=matrix[x][y];
        visited[x][y]=true;

        if(move_count==4)
        {
            if(count>=max_count)
            {
                max_count=count;

            }
            visited[x][y]=false;

            return;
        }
        for(int i=0; i<4; i++)
        {
            int newX=x+dx[i];
            int newY=y+dy[i];
            if(newX>=0&&newX<n&&newY>=0&&newY<m
                &&visited[newX][newY]==false)
            {
                DFS(newX,newY,matrix,visited,move_count+1,count);
            }


        }
        visited[x][y]=false;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String [] line_1 = br.readLine().trim().split(" ");
        n =Integer.parseInt(line_1[0]);
        m =Integer.parseInt(line_1[1]);
        Integer [][] matrix = new Integer[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++)
        {
            String [] line = br.readLine().trim().split(" ");
            for(int j=0; j<m; j++)
            {
                matrix[i][j]=Integer.parseInt(line[j]);
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                DFS(i,j,matrix,visited,1,0);
                T_shape(i,j,matrix);
            }
        }



        System.out.println(max_count);



    }


}