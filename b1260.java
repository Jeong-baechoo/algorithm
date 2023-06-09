import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1260 {
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        visit = new boolean[n+1];

        for (int i = 0; i < n+1; i++) { //정점의 개수만큼 연결리스트 추가
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }
        for (int i = 0; i < n+1; i++) {
            Collections.sort(adjList.get(i));
        }

        dfs(adjList, v);
        visit = new boolean[n+1];
        System.out.println();
        bfs(adjList, v);
    }
    static void bfs(ArrayList<ArrayList<Integer>> list,int start){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        visit[start] = true;
        while(!qu.isEmpty()){
            Integer node = qu.poll();
            for (int i = 0; i < list.get(node.intValue()).size(); i++) {
                if(visit[list.get(node).get(i)] == true) continue;
                qu.add(list.get(node.intValue()).get(i));
                visit[list.get(node.intValue()).get(i)] = true;
            }
            System.out.print(node.intValue()+" ");
        } 
    }

    static void dfs(ArrayList<ArrayList<Integer>> list,int start){
        
        System.out.print(start +" ");
        visit[start] = true;
        for (int i = 0; i <list.get(start).size() ; i++) {
            if(visit[list.get(start).get(i).intValue()]) continue;
            dfs(list, list.get(start).get(i));
        }
    }
}
