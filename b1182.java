import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 수열
 * 부분 수열의 개수는 2^n-1
 * 넣을 것인가 안 넣을것 인가
*/
public class b1182 {
    static int arr[] = new int[21];
    static int n,s,count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(s == 0){
            count--;
        }
        func(0 , 0);
        System.out.println(count);
    }

    static void func(int k, int sum){
        if(k == n){
            if(sum == s) count++;
            return;
        }
        func(k+1, sum); // 포함하지 않음
        func(k+1, sum + arr[k]); // 포함함
    }
}
