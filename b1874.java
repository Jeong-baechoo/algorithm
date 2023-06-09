import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean pushed[] = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int i = 1;
        pushed[i] = true;
        StringBuilder sb = new StringBuilder();
        sb.append('+').append('\n');
        while(n --> 0){
            int target = Integer.parseInt(br.readLine());
            while(pushed[target] == false){ //타켓 정수까지 오름차순으로 스택에 푸시
                i++;
                pushed[i] = true;
                sb.append('+').append('\n');
                stack.push(i);
            }
            if(stack.peek() > target){
                System.out.println("NO");
                return;
            }
            sb.append('-').append('\n');
            stack.pop();
        }
        System.out.println(sb);
    }
}
