import java.util.*;
import java.io.*;
class Node{
    int value;
    Node left,right;

    public Node(int value)
    {
        this.value=value;
        left=right=null;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> preorder = new ArrayList<>();
        String line;
        while(true)
        {
            line=br.readLine();
            if(line==null || line.equals("")) break;
            preorder.add(Integer.parseInt(line.trim()));

        }

        int[] array = preorder.stream().mapToInt(Integer::intValue).toArray();

        Node root= Construct_BST(array);

        postorderTraversal(root);

    }

    public static void postorderTraversal(Node root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.value );
    }
    static Node BST(int [] preorder, int start, int end) {
        if (start > end) return null;

        Node root = new Node(preorder[start]);

        int i;
        for (i = start + 1; i <= end; i++)
        {
            if(preorder[i]> root.value) break;

        }

        root.left=BST(preorder,start+1,i-1);
        root.right=BST(preorder,i,end);

        return root;
    }

    static Node Construct_BST(int [] preorder)
    {
        if(preorder.length==0) return null;
        return BST(preorder,0,preorder.length-1);
    }
}