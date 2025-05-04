import java.util.*;
import java.io.*;
public class Main {
    static void turn(int [] T, int direction)
    {
        int temp;
        if(direction==1)
        {
            temp=T[7];
            for(int i=7; i>0; i--)
            {
                T[i]=T[i-1];
            }
            T[0]=temp;

        }
        else
        {
            temp=T[0];
            for(int i=0; i<7; i++)
            {
                T[i]=T[i+1];
            }
            T[7]=temp;
        }
    }


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int []a = new int[8];
        int []b = new int[8];
        int []c = new int[8];
        int []d = new int[8];

        String [] line =br.readLine().trim().split("");
        for(int j=0; j<8; j++)
        {
            a[j]=Integer.parseInt(line[j]);
        }
        line =br.readLine().trim().split("");
        for(int j=0; j<8; j++)
        {
            b[j]=Integer.parseInt(line[j]);
        }
        line =br.readLine().trim().split("");
        for(int j=0; j<8; j++)
        {
            c[j]=Integer.parseInt(line[j]);
        }
        line =br.readLine().trim().split("");
        for(int j=0; j<8; j++)
        {
            d[j]=Integer.parseInt(line[j]);
        }

        int k =Integer.parseInt(br.readLine().trim());

        for(int i=0; i<k; i++)
        {
            st=new StringTokenizer(br.readLine().trim());

            int choice=Integer.parseInt(st.nextToken());
            int direction=Integer.parseInt(st.nextToken());
            switch (choice)
            {
                case 1 :
                    if(a[2]!=b[6])
                    {
                       if(b[2]!=c[6])
                       {
                           if(c[2]!=d[6])
                           {
                                turn(d,-direction);
                           }
                           turn(c,direction);
                       }
                       turn(b,-direction);
                    }
                    turn(a,direction);
                    break;
                case 2 :
                    if(a[2]!=b[6])
                        turn(a,-direction);
                    if(b[2]!=c[6])
                    {
                        if(c[2]!=d[6])
                        {
                            turn(d,direction);
                        }
                        turn(c,-direction);
                    }
                    turn(b,direction);
                    break;
                case 3 :
                    if(c[2]!=d[6])
                        turn(d,-direction);
                    if(b[2]!=c[6])
                    {
                        if(a[2]!=b[6])
                        {
                            turn(a,direction);
                        }
                        turn(b,-direction);
                    }
                    turn(c,direction);
                    break;
                case 4 :
                    if(c[2]!=d[6])
                    {
                        if(b[2]!=c[6])
                        {
                            if(a[2]!=b[6])
                            {
                                turn(a,-direction);
                            }
                            turn(b,direction);
                        }
                        turn(c,-direction);
                    }
                    turn(d,direction);
                    break;
            }

        }
        int score=0;
        if(a[0]==1)
            score+=1;
        if(b[0]==1)
            score+=2;
        if(c[0]==1)
            score+=4;
        if(d[0]==1)
            score+=8;

        System.out.println(score);




    }
}