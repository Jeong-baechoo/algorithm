
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class b9663 {
    static int[][] queen;
    static int n;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queen = new int[n][n];
        queen(0);
        System.out.println(count);
    }
    static void queen(int k){
        if(k == n){
            count ++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(check(k,i)){
                queen[k][i] = 1;
                queen(k+1);
                queen[k][i] = 0;
            }
        }
    }
    static boolean check(int k, int i){
        for (int j = 0; j < queen.length; j++) {
            if(queen[k][j] == 1 && j != i) return false;
            if(queen[j][i] == 1 && j != k) return false;
        }
        for (int j = 0; j < k; j++) {
            if(j == k) continue;
            for (int j2 = 0; j2 < queen.length; j2++) {
                if(i == j2) continue;
                if(queen[j][j2] == 1 && Math.abs(k - j) == Math.abs(i - j2)) return false;
            }
        }
        return true;
    }
}
