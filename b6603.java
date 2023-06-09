import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b6603 {
    static List<Integer> arr;
    static int[] num;
    static boolean isused[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            arr = new ArrayList<>();
            num =  new int[14];
            isused = new boolean[14];;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken());
            if(n == 0) break;
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);
            func(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void func(int k, int start){
        if(k == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(arr.get(num[i])).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            if(!isused[i]){
                num[k] = i;
                isused[i] = true;
                func(k+1, num[k] + 1);
                isused[i] = false; 
            }
        }
    } 
}
