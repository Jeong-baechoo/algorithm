import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class b2493R {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[0] < k){
                    stack.pop();
                } else{
                    sb.append(stack.peek()[1]).append(' ');
                    break;
                }
            }
            if(stack.empty()){
                sb.append('0').append(' ');
            }
            stack.push(new int[] {k,i+1});
        }
        System.out.println(sb);
    }
}
