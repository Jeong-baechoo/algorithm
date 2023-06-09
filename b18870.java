import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 원래의 입력순서를 기억해야함
 * 정렬 후 i 반복문의 i값을 입력순서 배열에
 */
public class b18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[n];
        int[] orijin = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            orijin[i] = k;
        }
        Arrays.sort(arr);
        map.put(arr[0], 0);
        int count = 0;
        for (int i = 1; i < n; i++) {
            int temp = arr[i - 1];
            if(temp == arr[i]){
            }else{
                count ++;
            }
            map.put(arr[i], count);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(orijin[i])).append(' ');
        }
        System.out.println(sb);
    }
    
}
