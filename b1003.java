import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1003 {
    static int zero;
    static int one;
    public static void main(String[] args) throws IOException{ //재귀로 문제를 풀 경우 중복되는 경우가 많이 발생해 시간 낭비가 발생됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int fibo[][] = new int[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(fibo[n][0] + " "+ fibo[n][1]);
        }
    }
}
