import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class b18258 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> qu = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if(command.equals("push")) qu.offer(Integer.parseInt(st.nextToken()));
            else if(!qu.isEmpty() && command.equals("pop")) sb.append(qu.poll()).append('\n');
            else if(qu.isEmpty() && command.equals("pop")) sb.append(-1).append('\n');
            else if(command.equals("size")) sb.append(qu.size()).append('\n');
            else if(qu.isEmpty() && command.equals("empty")) sb.append(1).append('\n');
            else if(!qu.isEmpty() && command.equals("empty")) sb.append(0).append('\n');
            else if(!qu.isEmpty() && command.equals("front")) sb.append(qu.element()).append('\n');
            else if(qu.isEmpty() && command.equals("front")) sb.append(-1).append('\n');
            else if(!qu.isEmpty() && command.equals("back")) sb.append(qu.getLast()).append('\n');
            else if(qu.isEmpty() && command.equals("back")) sb.append(-1).append('\n');
        }
        System.out.println(sb);
    }
}
