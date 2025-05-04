import java.util.*;
import java.io.*;
class Point{
    int x,y;

    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int case_num=1;
    static void print(List<Point> tree)
    {
        System.out.println("tt");
        for(Point p : tree)
        {
            System.out.println(p.x + "  " + p.y);
        }
    }

    static void check(List<Point > tree)
    {
        HashSet <Integer> x_set = new HashSet<>();
        HashSet <Integer> y_set = new HashSet<>();
        HashSet <Integer> all_nodes = new HashSet<>();

        for(Point p : tree)
        {
            int x= p.x;
            int y= p.y;

            if(!y_set.isEmpty()&&y_set.contains(y))
            {
                //들어오는 간선이 두개
                System.out.printf("Case %d is not a tree.\n",case_num++);
                return;
            }
//            else if(x_set.contains(y) && y_set.contains(x) )
//            {
//                //순환구조
//                System.out.printf("Case %d is not a tree.\n",case_num++);
//                return;
//            }
            else
            {
                x_set.add(x);
                y_set.add(y);
                all_nodes.add(x);
                all_nodes.add(y);
            }

        }
        HashSet <Integer> diff =new HashSet<>(x_set);

        diff.removeAll(y_set);
        if(diff.size()==1) {
            if(all_nodes.size()-1==tree.size())
                System.out.printf("Case %d is a tree.\n", case_num++);
            else
                System.out.printf("Case %d is not a tree.\n",case_num++);
        }
        else
            System.out.printf("Case %d is not a tree.\n",case_num++);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        List<Point> tree = new ArrayList<>();





        while(true)
        {
            String line = br.readLine();
            if(line==null || line.isEmpty())
                continue;

            StringTokenizer st = new StringTokenizer(line);

            while(st.hasMoreTokens())
            {
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());

                if(x==-1 && y==-1)
                {
                    return;
                }

                if(x==0 && y==0)
                {
                    if(tree.size()==0)
                        System.out.printf("Case %d is a tree.\n", case_num++);
                    else
                    {
                        check(tree);
                        tree.clear();
                    }

                }
                else
                {
                    tree.add(new Point(x,y));
                }
            }


        }
    }
}