import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5639 {
    /*
     * 목적: BST에서 전위 순회한 결과로 트리를 만듬
     * 후위순회
     * 
     * bufferReader 사용시 EOF하는 법 알아두기
     * 
    */
    static BufferedReader br;
    static int child;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Node node = new Node(num);
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            int child = Integer.parseInt(input);
            MakeTree(node, child); 
        }

        post(node);
        System.out.println(sb);
    }


    static void post(Node node){
        if(node.L != null){
            post(node.L);
        }
        if(node.R != null){
            post(node.R);
        }
        sb.append(node.n).append('\n');
        return;
    }

    static void MakeTree(Node node, int child){
        int parent = node.n; //부모의 값
        if(parent > child){
            if(node.L == null){
                node.L = new Node(child);
            } else{
                MakeTree(node.L, child);
            }
        } else{
            if(node.R == null){
                node.R = new Node(child);
            } else MakeTree(node.R, child);
        }

    }
    public static class Node {
        int n;
        Node L;
        Node R;
        public Node(int n){
            this.n = n;
        }
    }
}
