import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2606 {
    static int[][] graph;
    static boolean visit[];
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        graph = new int[v+1][v+1];
        visit = new boolean[v+1];
        for (int i = 0; i < e; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph[n1][n2] = 1;
                graph[n2][n1] = 1;
        }
        dfs(1);
        System.out.println(count - 1);
    }
    static void dfs(int start){
        visit[start] = true;
        count++;
        for (int i = 1; i < graph[start].length; i++) {
            if(graph[start][i] == 0 || visit[i] == true) continue;
            dfs(i);
        }
    }
}
