import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken()); // 정점
        int e = Integer.parseInt(st.nextToken()); // 간선
        boolean[] isVisit = new boolean[v + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adj.get(n1).add(n2); //무방향 그래프
            adj.get(n2).add(n1);
        }

        int count = 0;
        for (int i = 1; i <= v; i++) {
            if (!isVisit[i]) {
                bfs(i, adj, isVisit);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] isVisit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        isVisit[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adj.get(current)) {
                if (!isVisit[next]) {
                    queue.offer(next);
                    isVisit[next] = true;
                }
            }
        }
    }
}
