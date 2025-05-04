import java.util.*;
import java.io.*;
class Point{
    int x;
    int y;

    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;

    }
}
public class Main {

    static int N,M;
    static int[][] city;
    static ArrayList<Point> House;
    static ArrayList<Point> Chicken;
    static int min_distance=10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        city=new int [N][N];
        for(int i=0; i<N; i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        House = new ArrayList<>();
        Chicken= new ArrayList<>();

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(city[i][j]==1)
                {
                    House.add(new Point(i,j));
                }
                else if(city[i][j]==2)
                {
                    Chicken.add(new Point(i,j));
                }
            }
        }
        boolean[] visited=new boolean[Chicken.size()];
        combination(visited,0,Chicken.size(),M);

        System.out.println(min_distance);



    }

    static void combination( boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            distance(Chicken,House,visited);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void distance(ArrayList<Point> chicken, ArrayList<Point> house,boolean [] visited)
    {

        int count=0;
        int [] dis = new int[house.size()];
        for(int i=0; i<visited.length; i++)
        {
            if(visited[i])
            {

                Point selected_chicken = chicken.get(i);
                if(count==0)
                {
                    for(int j=0; j< house.size(); j++)
                    {
                        dis[j]=Math.abs(selected_chicken.x-house.get(j).x)+Math.abs(selected_chicken.y-house.get(j).y);
                    }
                }
                else {
                    for(int j=0; j< house.size(); j++)
                    {
                        dis[j]=Math.min(dis[j],Math.abs(selected_chicken.x-house.get(j).x)+Math.abs(selected_chicken.y-house.get(j).y));
                    }
                }
                count++;
            }
        }
        int sum=0;
        for(int i=0; i<dis.length; i++)
        {
            sum+=dis[i];
        }

        min_distance=Math.min(sum,min_distance);

    }

}