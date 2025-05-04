import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().trim().split("");

        if(input.length%2!=0)
        {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
            System.exit(0);

        }

        int rb_count =0; //round brackets

        int b_count =0; // brackets

        int b_open=0; //0 : rb- open, 1: b- open, 2:rb,b- close 이전에 괄호 상태

        //예외 처리
        for (String s : input) {
            switch (s) {
                case "(" -> {
                    rb_count++;
                    b_open = 0;
                }
                case ")" -> {
                    if (b_open == 1) {
                        bw.write(String.valueOf("0"));
                        bw.flush();
                        bw.close();
                        System.exit(0);
                    }
                    rb_count--;
                    b_open = 2;
                }
                case "[" -> {
                    b_count++;
                    b_open = 1;
                }
                case "]" -> {
                    if (b_open == 0) {
                        bw.write(String.valueOf("0"));
                        bw.flush();
                        bw.close();
                        System.exit(0);
                    }

                    b_count--;
                    b_open = 2;
                }
            }


            if (b_count < 0 || rb_count < 0) {
                bw.write(String.valueOf("0"));
                bw.flush();
                bw.close();
                System.exit(0);
            }
        }
        if(b_count!=0||rb_count!=0)
        {
            bw.write(String.valueOf("0"));
            bw.flush();
            bw.close();
            System.exit(0);

        }





    }
}