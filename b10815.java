import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b10815 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(map.get(Integer.parseInt(st.nextToken())) == null){
                sb.append(0).append(' ');
            } else{
                sb.append(1).append(' ');
            }
        }
        System.out.println(sb);
        
    }
}
