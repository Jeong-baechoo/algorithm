import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b15655 {
    static int n,m;
    static boolean[] isused = new boolean[9];
    static StringBuilder sb = new StringBuilder();
    static int[] arr = new int[9];
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        func(0,0);
        System.out.println(sb);

    }
    static void func(int k, int start){
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(list.get(arr[i])).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < n; i++) {
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                func(k+1, i +1);
                isused[i] = false;
            }
        }
    }
}
