import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 행렬 차이의 절대값 = 치킨 거리
 * 최대 M개의 치킨집
 * 도시의 치킨 거리 최소가 되도록
 * 중복이 되지 않도록
 * 
*/
public class b15685 {
    static boolean isused[] = new boolean[15];
    static int n,m;
    static List<chiken> chikens = new ArrayList<>();
    static List<house> houses = new ArrayList<>();
    static int[] arr = new int[15];
    static int min = 100000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 2){
                    chikens.add(new chiken(i, j));
                } else if(num == 1){
                    houses.add(new house(i, j, 999));
                }
            }   
        }

        func(0 , 0);
        System.out.println(min);

    }
    static void func(int k, int start){
        if(k == m){
            int temp = 0;
            for (int i = 0; i < houses.size(); i++) {
                for (int j = 0; j < m; j++) {
                    houses.get(i).dst = Math.min(houses.get(i).dst, Math.abs(houses.get(i).x - chikens.get(arr[j]).x)+ Math.abs(houses.get(i).y - chikens.get(arr[j]).y));
                }
            }
            for (int i = 0; i < houses.size(); i++) {
                temp += houses.get(i).dst;
                houses.get(i).dst = 999;
            }
            if(temp < min){
                min = temp;
            }
            return;
        }
        for (int i = start; i < chikens.size(); i++) {
            if(!isused[i]){
                arr[k] = i;
                isused[i] = true;
                func(k+1, arr[k] + 1);
                isused[i] = false;
            }
        }
    }
    static class chiken{
        int x;
        int y;
        public chiken(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class house{
        int x;
        int y;
        int dst;
        public house(int x, int y, int dst){
            this.x = x;
            this.y = y;
            this.dst = dst;
        }
    }
}
