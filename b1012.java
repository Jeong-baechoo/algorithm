import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        
        for (int test = 0; test < t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int map[][] = new int[m][n];
            boolean visit[][] = new boolean[m][n];
            for (int i = 0; i < k; i++) { // 배추 위치 초기화
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }
            int count = 0;

            int dy[] = {0, 1, 0, -1};
            int dx[] = {1, 0, -1, 0};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] == 0 || visit[i][j]) continue;
                    count ++;
                    Queue<Pair> qu = new LinkedList<>();
                    qu.add(new Pair(i, j));

                    while(!qu.isEmpty()){
                        Pair curPair = qu.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = curPair.x + dx[dir];
                            int ny = curPair.y + dy[dir];
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if(visit[nx][ny] == true || map[nx][ny] != 1) continue;
                            visit[nx][ny] = true;
                            qu.add(new Pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}