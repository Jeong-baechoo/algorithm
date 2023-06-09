import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
/*
 * 덱을 활요한 문자열 변경
*/
public class b5430R {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        
        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"[],");
            deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(deque, p);
        }

        System.out.println(sb);
    }
    public static void AC(ArrayDeque<Integer> deque,String command){
        boolean isRight = true; //정방향

        for (char c: command.toCharArray()) {
            if(c == 'R'){
                isRight = !isRight;
                continue;
            }else if(c == 'D'){
                if(isRight == false){
                    if(deque.pollLast() == null){
                        sb.append("error\n");
                        return;
                    } 
                } else{
                    if(deque.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        MakeString(deque, isRight);
    }
    public static void MakeString(ArrayDeque<Integer> deque, boolean isRight){
        sb.append('[');
        if(deque.size() > 0){
            if(isRight){
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollFirst());
                }
            } else{
                sb.append(deque.pollLast());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

}
