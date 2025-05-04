import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine().trim());
        String [] line = br.readLine().trim().split(" ");
        Integer [] crane = new Integer[n];
        for(int i=0; i<n; i++)
        {
            crane[i]=Integer.parseInt(line[i]);
        }
        int m = Integer.parseInt(br.readLine().trim());
        String [] line2 = br.readLine().trim().split(" ");
        List <Integer> box  = new ArrayList<Integer>();
        for(int i=0; i<m; i++)
        {
            box.add(Integer.parseInt(line2[i]));
        }

        Arrays.sort(crane,Collections.reverseOrder());
        box.sort(Collections.reverseOrder());
        int count=0;
        if(crane[0]< box.get(0))
        {
            System.out.println(-1);
            System.exit(0);
        }
//        System.out.println(Arrays.toString(crane));
//        System.out.println(box);
        while(!box.isEmpty())
        {
            int box_index=0;
            for(int i=0; i<n; )
            {

                if(!box.isEmpty()&&crane[i]<box.get(box.size()-1))
                {
                    n=i;
                    break;
                }
                if(box_index==box.size())
                    break;
                if(crane[i]>=box.get(box_index))
                {
                    box.remove(box_index);
                    i++;
                }
                else {
                    box_index++;
                }

            }
            count++;
        }
        System.out.println(count);





    }
}
//
//import java.util.*;
//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(br.readLine().trim());
//        String [] line = br.readLine().trim().split(" ");
//        Integer [] crane = new Integer[n];
//        for(int i=0; i<n; i++)
//        {
//            crane[i]=Integer.parseInt(line[i]);
//        }
//        int m = Integer.parseInt(br.readLine().trim());
//        String [] line2 = br.readLine().trim().split(" ");
//        List <Integer> box  = new ArrayList<Integer>();
//        for(int i=0; i<m; i++)
//        {
//            box.add(Integer.parseInt(line2[i]));
//        }
//
//        Arrays.sort(crane,Collections.reverseOrder());
//        box.sort(Collections.reverseOrder());
//        int count=0;
//        if(crane[0]< box.get(0))
//        {
//            System.out.println(-1);
//            System.exit(0);
//        }
////        System.out.println(Arrays.toString(crane));
////        System.out.println(box);
//        while(!box.isEmpty())
//        {
//            for(int i=0; i<n; i++)
//            {
//
//                if(crane[i]>=box.get(0))
//                {
//                    box.remove(0);
//                    if(box.isEmpty()) {
//                        break;
//                    }
//                }
//
//            }
//            count++;
//        }
//        System.out.println(count);
//
//
//
//
//
//    }
//}