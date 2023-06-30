import java.util.Scanner;

public class b1074 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();
        int result = Z(n,r,c);
        System.out.println(result);
        scan.close();
    }
    static int Z(int n, int r, int c){
        if(n == 0) return 0;

        int half = 1 << (n-1);
        if(r < half && c < half) return Z(n-1,r,c);
        if(r < half && c >= half) return half*half + Z(n-1,r,c-half);
        if(r >= half && c < half) return 2*half*half + Z(n-1,r-half,c);
        else return 3*half*half + Z(n-1,r-half,c-half);
    }
}
