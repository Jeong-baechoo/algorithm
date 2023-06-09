import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1759 {
    static int n,m;
    static List<String> list = new ArrayList<>();
    static int num[] = new int[16];
    static boolean isused[] = new boolean[16];
    static StringBuilder sb = new StringBuilder();
    static String str = "aeiou";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            list.add(st.nextToken());
        }
        Collections.sort(list);
        func(0,0,0);
        System.out.println(sb);
    }
    public static void func(int k, int start, int count) {
        if(k == m){
            if(count >=1 && m - count >=2){
                for (int i = 0; i < m; i++) {
                    sb.append(list.get(num[i]));
                }
                sb.append('\n');
            }
            return;
        }
        for (int i = start; i < n; i++) {
            int temp = count;
            if(!isused[i]){
                num[k] = i;
                for (char c : str.toCharArray()) {
                    if(String.valueOf(c).equals(list.get(num[k]))) temp++;
                }
                isused[i] = true;
                func(k+1, num[k] +1,temp);
                isused[i] = false;
            }
        }
    }
    
}
