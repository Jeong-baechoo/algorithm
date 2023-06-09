import java.util.Scanner;

public class b15642 {
    static int n,m;
    static int[] arr = new int[9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        func(0, 1);
        System.out.println(sb);
    }
    static void func(int k, int start){
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = start ; i <= n; i++) {
            arr[k] = i;
            func(k+1, i); 
        }
    }
}
