import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class b1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }
        st = new StringTokenizer(br.readLine()," ");
        int count= 0;
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            while(true){
                if(qu.getFirst() == target) {
                    qu.pollFirst();
                    break;
                } else if(qu.indexOf(target) <= qu.size()/2){
                    qu.offer(qu.poll());
                    count++;
                } else{
                    qu.offerFirst(qu.pollLast());
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
