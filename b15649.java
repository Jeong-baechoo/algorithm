import java.util.Scanner;

public class b15649 {
    static int n,m;
    static int arr[] = new int[10];
    static boolean isused[] = new boolean[10];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        func(0);
    }
    public static void func(int k){
        if(k == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                func(k+1);
                isused[i] = false;
            }
        }
    }
}
