import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * 이분탐색 문제 주어지는 수의 개수 범위가 100000이여서
 * O(n^2)으로 해결할 수 없다고 판다.
 * 해쉬맵을 이용하면 O(n)으로 해결할 수 있어서 해쉬로 풀었음
 */
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
