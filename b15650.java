import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class b15650 {
    static int n,m;
    static int arr[] = new int[9];
    static boolean isused[] = new boolean[9];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        func(0,1);
        
    }
    static void func(int k, int start){
        if(k == m){
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] +" ");
            }
            System.out.println();
        }
        for (int i = start; i <= n; i++) {
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                func(k+1,arr[k]);
                arr[k] = 0;
                isused[i] = false;
            }
        }
    }
}
