import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
public class b11279{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if(k == 0 && pq.isEmpty()) {
                System.out.println(0);
            }
            else if (k == 0){
                System.out.println(pq.peek());
                pq.poll();
            } else{
                pq.offer(k);
            }
        }

    }
}