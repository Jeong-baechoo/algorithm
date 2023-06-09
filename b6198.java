import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * 모노톤 스택 문제(monotone Stack)
 * 발상은 top에 있는 숫자와 새롭게 들어오는 숫자를 비교하고, 경우에 따라 pop 하며 진행
 * 오름차, 내림차를 유지하는 스택
*/
public class b6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> building = new Stack<>();
        long count = 0; // 문제 조건 확인해서 범위 조심하기  (1 ≤ hi ≤ 1,000,000,000) int는 4바이트이므로 2^32 넘어가는 수는 오버플로우 발생 long은 2^64까지 커버 가능
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            while(!building.isEmpty()){
                if(building.peek() <= h){ //이전 빌딩의 높이보다 오른쪽 빌딩의 높이가 높다면 쓸모가 없으므로 pop
                    building.pop();
                    continue;
                }
                count += building.size();
                building.push(h);
                break;
            }
            if(building.isEmpty()){
                building.push(h);
            } 
        }
        System.out.println(count);
    }
}
