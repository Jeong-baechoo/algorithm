import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pair(x, y));
        }
        Collections.sort(list);

        for (Pair pair : list) {
            System.out.println(pair.x+" "+pair.y);
        }
        
    }
    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            if(y == o.y){
                return x - o.x;
            }
            return y - o.y;
        }
        
    }
}
