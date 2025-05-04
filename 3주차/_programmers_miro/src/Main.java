import java.util.*;
public class Main {


    public static class Point{
        public int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    static int [] dx ={-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int [][] me ;

    public static int solution(int[][] maps)
    {

        int n=maps.length;
        int m= maps[0].length;
        me = new int [n][m];


        BFS(0,0,n,m,maps);
        if(me[n-1][m-1]==0)
        {
            return -1;
        }
        else
        {
            return me[n-1][m-1]+1;

        }

    }

    public static void BFS(int x,int y,int n , int m,int [][] maps)
    {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        maps[x][y]=0;
        while(!Q.isEmpty())
        {
            Point tmp = Q.poll();
            for(int i=0; i<4; i++)
            {
                int nx =tmp.x +dx[i];
                int ny =tmp.y +dy[i];
                if(nx>=0 && nx <n &&ny>=0 && ny<m
                        && maps[nx][ny]==1){
                    maps[nx][ny]=0;
                    Q.offer(new Point(nx,ny));
                    me[nx][ny]=me[tmp.x][tmp.y]+1;
                }
            }


        }
    }

    public static void main(String[] args) {
        int [][] map ={{1,0,1},{1,1,1}};
        System.out.println(solution(map));

    }
}