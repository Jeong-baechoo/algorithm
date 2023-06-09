import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16987 {
    static int n;
    static int dura[] = new int[10];
    static int weight[] = new int[10];
    static boolean isbroken[] = new boolean[10];
    static int count;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            dura[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        func(0);
        System.out.println(max);
    }


    static void func(int isSelected){
        if(isSelected == n){ 
            max = Math.max(max, count);
            return;
        }
        if(isbroken[isSelected] || count == n-1){// 선택된 계란이 부숴져있다면 다음으로
            func(isSelected + 1);
            return;
        }

        for (int i = 0; i < n; i++) { // 때릴 계란 고르기
            if(isSelected == i || isbroken[i]) continue; // 자기 자신은 패스
            dura[isSelected] -= weight[i];
            dura[i] -= weight[isSelected];
                // 만약 부셔졌다면 갯수 카운트
            if(dura[isSelected] <= 0){
                isbroken[isSelected] = true;
                count ++;
            }
            if(dura[i] <= 0){
                isbroken[i] = true;
                count++;
            }
            func(isSelected + 1);
            if(dura[isSelected] <= 0){
                isbroken[isSelected] = false;
                count--;
            }
            if(dura[i] <= 0){
                isbroken[i] = false;
                count--;
            }
            dura[isSelected] += weight[i];
            dura[i] += weight[isSelected];
        }
    }
}
