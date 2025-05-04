import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] f_line = br.readLine().trim().split(" ");
        int n = Integer.parseInt(f_line[0]);
        int m = Integer.parseInt(f_line[1]);
        int x = Integer.parseInt(f_line[2]);
        int y = Integer.parseInt(f_line[3]);
        int k = Integer.parseInt(f_line[4]);
        int [][] map = new int[n][m];

        for (int i=0; i<n; i++)
        {
            String [] line = br.readLine().trim().split(" ");
            for(int j=0; j<m; j++)
            {
                map[i][j]=Integer.parseInt(line[j]);
            }
        }
        String [] cmd_l = br.readLine().trim().split(" ");
        int [] cmd=new int [k];
        for (int i=0; i<k; i++)
        {
            cmd[i]=Integer.parseInt(cmd_l[i]);
        }
        int command =0 ;
        int [] dice = new int[6]; //윗면 : dice[0]  밑면 : dice[2]
        int tmp=0;
        int tmp2=0;
        for (int i: dice)
        {
            dice[i]=0;
        }

        for(int i=0; i<k; i++)
        {
            command=cmd[i];
            switch (command)
            {
                case 1 :
                {
                    y=y+1;
                    if(y==m)
                    {
                        y=y-1;
                        break;
                    }
                    tmp=dice[3];
                    dice[3]=dice[2];
                    dice[2]=dice[1];
                    dice[1]=dice[0];
                    dice[0]=tmp;
                    if(map[x][y]==0)
                    {
                        map[x][y]=dice[2];
                    }
                    else
                    {
                        dice[2]=map[x][y];
                        map[x][y]=0;
                    }
                    bw.write(String.valueOf(dice[0]));
                    bw.newLine();
                    break;
                }
                case 2 :
                {
                    y=y-1;
                    if(y==-1)
                    {
                        y=y+1;
                        break;
                    }
                    tmp=dice[0];
                    dice[0]=dice[1];
                    dice[1]=dice[2];
                    dice[2]=dice[3];
                    dice[3]=tmp;
                    if(map[x][y]==0)
                    {
                        map[x][y]=dice[2];
                    }
                    else
                    {
                        dice[2]=map[x][y];
                        map[x][y]=0;
                    }
                    bw.write(String.valueOf(dice[0]));
                    bw.newLine();
                    break;
                }
                case 3 :
                {
                    x=x-1;
                    if(x==-1)
                    {
                        x=x+1;
                        break;
                    }
                    tmp=dice[0];
                    tmp2=dice[2];
                    dice[0]=dice[5];
                    dice[2]=dice[4];
                    dice[4]=tmp;
                    dice[5]=tmp2;
                    if(map[x][y]==0)
                    {
                        map[x][y]=dice[2];
                    }
                    else
                    {
                        dice[2]=map[x][y];
                        map[x][y]=0;
                    }
                    bw.write(String.valueOf(dice[0]));
                    bw.newLine();
                    break;

                }
                case 4 :
                {
                    x=x+1;
                    if(x==n)
                    {
                        x=x-1;
                        break;
                    }
                    tmp=dice[0];
                    tmp2=dice[2];
                    dice[0]=dice[4];
                    dice[2]=dice[5];
                    dice[4]=tmp2;
                    dice[5]=tmp;
                    if(map[x][y]==0)
                    {
                        map[x][y]=dice[2];
                    }
                    else
                    {
                        dice[2]=map[x][y];
                        map[x][y]=0;
                    }
                    bw.write(String.valueOf(dice[0]));
                    bw.newLine();
                    break;
                }
            }


        }
        bw.flush();
        bw.close();






    }
}