import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Seat
{
    int x,y,emptyCount , friendCount;

    public Seat(int x,int y,int emptyCount,int friendCount)
    {

        this.x=x;
        this.y=y;
        this.emptyCount=emptyCount;
        this.friendCount=friendCount;
    }
}
public class Main {

    static int N, studentNum;
    static int [][]  map;
    static HashMap <Integer,int[]> hashMap;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static int score= 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        StringTokenizer st;

        N=Integer.parseInt(br.readLine().trim());
        studentNum=N*N;
        map = new int[N][N];
        hashMap=new HashMap<>();

        for(int i=0; i<studentNum; i++)
        {
            st=new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            int [] likeFriends = new int[4];

            for(int j=0; j<4; j++)
            {
                likeFriends[j]=Integer.parseInt(st.nextToken());
            }

            hashMap.put(student,likeFriends);

            putStudentSeat(student);
        }

        getScore();

        System.out.println(score);

    }

    static void putStudentSeat(int student)
    {
        int [] friends = hashMap.get(student);

        ArrayList<Seat> seats = new ArrayList<>();


        for(int y=0; y<N; y++)
        {
            for(int x=0; x<N;x++)
            {
                int friendCnt=0;
                int emptyCnt=0;
                for(int i=0; i<4; i++)
                {
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(outOfRange(nx,ny))continue;

                    for(int j=0; j<4; j++)
                    {
                        if(map[ny][nx]==friends[j])
                            friendCnt++;
                    }

                    if(map[ny][nx]==0)emptyCnt++;

                }
                seats.add(new Seat(x,y,emptyCnt,friendCnt));
            }
        }
        //sort는 기본적으로 오름차순 return이 음수이면 바꾸지 않는다. return이 양수이면 바꾼다.
        seats.sort((s1,s2) ->{//1.좋아하는 학생 칸 2. 비어있는 칸 3.행 4.열
            if(s1.friendCount==s2.friendCount)
            {
                if(s1.emptyCount==s2.emptyCount) {
                    if (s1.y == s2.y) {
                        return s1.x - s2.x;
                    }
                    return s1.y - s2.y;
                }
                return s2.emptyCount-s1.emptyCount;
            }
            return s2.friendCount-s1.friendCount;
        });

        for(Seat s : seats)
        {
            if(map[s.y][s.x]!=0)continue;
            map[s.y][s.x]=student;
            return;
        }

    }

    static boolean outOfRange(int x,int y)
    {
        return x<0||y<0||x>=N||y>=N;
    }

    static void getScore()
    {
        for(int y=0; y<N; y++)
        {
            for(int x=0; x<N; x++)
            {
                int cnt=0;
                int [] friends = hashMap.get(map[y][x]);
                for(int i=0; i<4; i++)
                {
                    int nx=x+dx[i];
                    int ny=y+dy[i];
                    if(outOfRange(nx,ny)) continue;

                    for(int j=0; j<4;j++)
                    {
                        if(map[ny][nx]==friends[j])
                            cnt++;
                    }
                }
                if(cnt>0)
                    score+=Math.pow(10,cnt-1);
            }

        }
    }
}