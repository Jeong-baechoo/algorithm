import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class b2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> qu = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            qu.offer(i);
        }
        while(qu.size() != 1){
            qu.poll();
            qu.offer(qu.poll());
        }
        System.out.println(qu.poll());
    }
}
