import java.util.Scanner;

public class b15651 {
    static int n,m;
    static int arr[] = new int[8];
    static boolean[] isused = new boolean[8];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        func(0);
        System.out.println(sb);
    }
    static void func(int k){
        if(k == m){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[k] = i;
            func(k+1);
        }
    }
}
