import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n= Integer.parseInt(br.readLine());
        int [] numbers = new int [n];

        int index=0;

        while(index<n)
        {
            String [] parts = br.readLine().split(" ");
            for (String part: parts){
                numbers[index++]=Integer.parseInt(part);
            }
        }

        int k = Integer.parseInt(br.readLine());

        int number=0;

        for(int i=0; i<k; i++)
        {
            String [] parts = br.readLine().split(" ");
            number=Integer.parseInt(parts[1]);
            if(parts[0].equals("1")) //남자
            {
                for(int j=number-1; j<n; j+=number)
                {
                    numbers[j]=numbers[j]==0?1:0;
                }
            }
            else //여자
            {
                int left=number-1;
                int right=number-1;
                numbers[number-1]=numbers[number-1]==0?1:0;
                while(left-1>=0 && right+1<n)
                {
                    if(numbers[left-1]==numbers[right+1])
                    {
                        numbers[left-1]=numbers[left-1]==0?1:0;
                        numbers[right+1]=numbers[right+1]==0?1:0;
                        left--;
                        right++;
                    }
                    else
                    {
                        break;
                    }
                }




            }
        }

        for (int i = 0; i < numbers.length; i++) {
            bw.write(numbers[i] + (i == numbers.length - 1 ? "" : " "));
            if ((i + 1) % 20 == 0) {
                bw.newLine();
            }
        }



        bw.flush();
        bw.close();




    }
}