import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int []R = new int[n+1];
        int []G = new int[n+1];
        int []B = new int[n+1];

        int [][]house = new int[n+1][3];
        for (int i = 1; i <= n; i++) { // RGB 초기화
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        house[1][0] = R[1];
        house[1][1] = G[1];
        house[1][2] = B[1];
        for (int i = 2; i <= n; i++) {
            house[i][0] =  Math.min(house[i-1][1],house[i-1][2]) + R[i];
            house[i][1] =  Math.min(house[i-1][0],house[i-1][2]) + G[i];
            house[i][2] =  Math.min(house[i-1][0],house[i-1][1]) + B[i];
        }
        int min =  house[n][0];
        for (int i = 1; i < 3; i++) {
            if(min > house[n][i]){
                min = house[n][i];
            }
        }

        System.out.println(min);
    }
}
