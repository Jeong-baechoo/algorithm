import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b15665 {
    static int n,m;
    static int num[] = new int[10];
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        func(0);
        System.out.println(sb);
        
    }
    static public void func(int k){
    
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr.get(num[i])).append(' ');
            }
            sb.append('\n');
            return;
        }
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if(temp != arr.get(i)){
                num[k] = i;
                temp = arr.get(num[k]);
                func(k+1);
            }
        }

    }
}
