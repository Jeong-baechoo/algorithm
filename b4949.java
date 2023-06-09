import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        while(true){
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            str = str.toLowerCase();
            if(str.charAt(0) == '.') break;
            StringTokenizer st = new StringTokenizer(str," abcdefghijklmnopqrstuvwxyz");
            
            while(st.hasMoreTokens()){
                sb.append(st.nextToken());
            }
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if(c == '.') break;
                if(!stack.isEmpty()){
                    if(stack.peek() == '(' && c == ')'){
                        stack.pop();
                        continue;
                    }
                    else if(stack.peek() == '[' && c == ']'){
                        stack.pop();
                        continue;
                    }
                }
                stack.push(c);
            }
            if(stack.isEmpty()) ans.append("yes").append("\n");
            else ans.append("no").append("\n");
        }
        System.out.println(ans);
    }
}
