import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //계단의 개수
        int stairs[][] = new int[n+1][3]; //1이면 연속으로 1개 밟음 2이면 연속으로 2개 밟음
        int point[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            point[i] = Integer.parseInt(br.readLine()); //계단별 점수
        }
        if(n == 1){
            System.out.println(point[1]);
            return ;
        }
        stairs[1][1] = point[1];
        stairs[1][2] = 0;
        stairs[2][1] = point[2];
        stairs[2][2] = stairs[1][1] + point[2];
        
        for (int i = 3; i <= n; i++) {
            stairs[i][1] = Math.max(stairs[i-2][2],stairs[i-2][1]) + point[i];
            stairs[i][2] = stairs[i-1][1] + point[i];
        }

        System.out.println(Math.max(stairs[n][1], stairs[n][2]));
    }
}
