import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        node root = new node(st.nextToken(),new node(st.nextToken(), null, null),new node(st.nextToken(), null, null));
        makeTree(root);
    }
    public void makeTree(node parent){
        Scanner scanner= new Scanner(System.in);
        if(parent.leftChild.cur.equals(scanner.nextLine())){
            parent.leftChild.leftChild = new node(scanner.nextLine(), null, null);
        } else if(parent.rightChild.cur.equals(scanner.nextLine())){
            
        }

    }
    public class node{
        String cur;
        node leftChild;
        node rightChild;
        public node(String cur, node lc , node rc){
            this.cur = cur;
            this.leftChild = lc;
            this.rightChild = rc;
        }

    }
}
