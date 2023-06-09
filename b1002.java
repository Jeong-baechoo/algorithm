import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 값을 비교할때 Math.sqrt 함수 사용하지 않기
 * 부동소수점 때문에 연산이 정확하지 않음
*/
public class b1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

            if(x1 == x2 && y1 == y2 && r1 == r2){
                sb.append(-1).append('\n');
            } else{
                if(d > (r1 + r2) * (r1 + r2) || d < (r1 - r2) * (r1 - r2) || (x1 == x2 && y1 == y2 && r1 != r2)){
                    sb.append(0).append('\n');
                }
                if(d == (int)Math.pow((r1 - r2),2) || d == (int)Math.pow((r1 + r2),2) ){
                    sb.append(1).append('\n');
                }
                if(d > (int)Math.pow((r1 - r2),2)  && d < (int)Math.pow((r1 + r2),2) ){
                    sb.append(2).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}