import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 *  모양의 한계 때문에 순수하게 bfs, dfs로는 풀기 힘듬 
 *  조합으로 가능한 모든 조합을 뽑고
 *  그 중에서 참인 경우만을 체크
 */
public class b1941 {
    static int n = 5;
    static int m = 7;
    static char map[][] = new char[5][5];
    static int combiX[] = new int [25];
    static int combiY[] = new int [25];
    static int count;
    static int[] num = new int[7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < 25; i++) {
            combiX[i] = i / 5;
            combiY[i] = i % 5;
        }

        func(0, 0);
        System.out.println(count);
    }
    static void func(int k, int start){
        if(k == 7){
            if(bfs()) count ++;
            return;
        }
        for (int i = start; i < 25; i++) {
            num[k] = i;
            func(k+1, num[k] + 1);
            
        }
    }
    private static boolean bfs() {
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        int Y = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (int a : num) {
            if(map[combiX[a]][combiY[a]] == 'Y') Y++;
            if(Y > 3) return false;
            temp.add(a);
        }

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(num[0]);
        while(!qu.isEmpty()){
            int cur = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = combiX[cur] + dx[i];
                int ny = combiY[cur] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
                    if(temp.contains(nx*5 + ny)){
                        temp.remove(Integer.valueOf(nx*5 + ny));
                        qu.offer(nx*5 + ny);
                    }
                }
            }
        }
        if(!temp.isEmpty()) return false;
        return true;
        
    }
}
