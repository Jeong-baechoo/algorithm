import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b15663 {
    static int n,m,temp;
    static boolean[] isused = new boolean[10];
    static StringBuilder sb = new StringBuilder();
    static int[] arr = new int[10];
    static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(num);
        func(0);
        System.out.println(sb);

    }
    static void func(int k){
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        int temp = 0; // 중복 수열인지 확인 하기 위해 필요한 임시 변수
        for (int i = 0; i < n; i++) {
            if(!isused[i] && temp != num.get(i)){ //이전 수열의 마지막 항과 새로운 수열의 마지막 항이 같으면 중복
                isused[i] = true;
                arr[k] = num.get(i);
                temp = arr[k];
                func(k+1);
                isused[i] = false;
            }
        }
    }
}
