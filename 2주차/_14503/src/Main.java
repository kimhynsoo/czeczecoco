//import java.util.Scanner;
//
//
//public class Main {
//    public static void main(String[] args)  {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int i= sc.nextInt();
//        int j= sc.nextInt();
//        int d= sc.nextInt(); //방향 0: 북, 1: 동, 2: 남, 3: 서
//        int clean_count=0;
//        int [][] input = new int[n][m];
//        //입력
//        for(int k=0; k<n; k++)
//        {
//            for(int r=0; r<m; r++)
//            {
//                input[k][r]=sc.nextInt();
//            }
//        }
//
//
//        boolean flag = true;
//        while(flag)
//        {
//            if(input[i][j]==0)
//            {
//                input[i][j]=2;
//                clean_count++;
//            }
//
//            if(input[i-1][j]!=0&&input[i][j+1]!=0&&input[i][j-1]!=0&&input[i+1][j]!=0)
//            {
//                switch(d)
//                {
//                    case  0 :
//                    {
//                        if(input[i+1][j]!=1) // 2
//                        {
//                            i=i+1;
//                            break;
//                        }
//                        else // 1
//                        {
//                            flag=false;
//                        }
//
//
//                    }
//                    case 1 :
//                    {
//                        if(input[i][j-1]!=1)
//                        {
//                            j=j-1;
//                            break;
//                        }
//                        else
//                        {
//                            flag=false;
//                            break;
//                        }
//
//                    }
//                    case 2:
//                    {
//                        if(input[i-1][j]!=1)
//                        {
//                            i=i-1;
//                            break;
//                        }
//                        else
//                        {
//                            flag=false;
//                            break;
//                        }
//                    }
//                    case 3:
//                    {
//                        if(input[i][j+1]!=1)
//                        {
//                            j=j+1;
//                            break;
//                        }
//                        else
//                        {
//                            flag=false;
//                            break;
//                        }
//                    }
//                }
//            }
//            else
//            {
//                d=(d+3)%4;
//
//                switch(d)
//                {
//                    case  0 :
//                    {
//                        if(input[i-1][j]==0)
//                        {
//                            i=i-1;
//                        }
//                        break;
//
//                    }
//                    case  1 :
//                    {
//                        if(input[i][j+1]==0)
//                        {
//                            j=j+1;
//                        }
//                        break;
//
//                    }
//                    case  2 :
//                    {
//                        if(input[i+1][j]==0)
//                        {
//                            i=i+1;
//                        }
//                        break;
//
//                    }
//                    case  3 :
//                    {
//                        if(input[i][j-1]==0)
//                        {
//                            j=j-1;
//                        }
//                        break;
//
//                    }
//                }
//
//
//
//
//            }
//
//
//        }
//
//        System.out.print(clean_count);
//        sc.close();
//
//
//
//
//
//    }
//}



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] firstLine = br.readLine().split(" ");
        String[] secondLine= br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int i = Integer.parseInt(secondLine[0]);
        int j = Integer.parseInt(secondLine[1]);
        int d = Integer.parseInt(secondLine[2]); // 방향 0: 북, 1: 동, 2: 남, 3: 서
        int clean_count = 0;
        int[][] input = new int[n][m];

        // 입력
        for (int k = 0; k < n; k++) {
            String[] line = br.readLine().split(" ");
            for (int r = 0; r < m; r++) {
                input[k][r] = Integer.parseInt(line[r]);
            }
        }

        boolean flag = true;
        while (flag) {
            if (input[i][j] == 0) {
                input[i][j] = 2; // 청소 완료
                clean_count++;
            }

            if (input[i - 1][j] != 0 && input[i][j + 1] != 0 && input[i][j - 1] != 0 && input[i + 1][j] != 0) {
                switch (d) {
                    case 0: // 북
                        if (input[i + 1][j] != 1) {
                            i = i + 1; // 아래로 이동
                            break;
                        } else {
                            flag = false;
                        }
                    case 1: // 동
                        if (input[i][j - 1] != 1) {
                            j = j - 1; // 왼쪽으로 이동
                            break;
                        } else {
                            flag = false;
                            break;
                        }
                    case 2: // 남
                        if (input[i - 1][j] != 1) {
                            i = i - 1; // 위로 이동
                            break;
                        } else {
                            flag = false;
                            break;
                        }
                    case 3: // 서
                        if (input[i][j + 1] != 1) {
                            j = j + 1; // 오른쪽으로 이동
                            break;
                        } else {
                            flag = false;
                            break;
                        }
                }
            } else {
                d = (d + 3) % 4; // 방향 회전

                switch (d) {
                    case 0: // 북
                        if (input[i - 1][j] == 0) {
                            i = i - 1; // 위로 이동
                        }
                        break;
                    case 1: // 동
                        if (input[i][j + 1] == 0) {
                            j = j + 1; // 오른쪽으로 이동
                        }
                        break;
                    case 2: // 남
                        if (input[i + 1][j] == 0) {
                            i = i + 1; // 아래로 이동
                        }
                        break;
                    case 3: // 서
                        if (input[i][j - 1] == 0) {
                            j = j - 1; // 왼쪽으로 이동
                        }
                        break;
                }
            }
        }

        // 결과 출력
        bw.write(String.valueOf(clean_count));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
