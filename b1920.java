import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b1920 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            map.put(scan.nextInt(), 0);
        }
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int key = scan.nextInt();
            if(map.containsKey(key)) System.out.println(1);
            else System.out.println(0);
        }
    }
}
