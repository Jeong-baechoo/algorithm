import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1167 {
    /*
     * 목적: 트리의 지름 중 가장 긴 것을 찾는다
     * 1. 입력된 것을 인접 리스트로 저장
     * 2. 시작 정점과 끝 정점 간의 모든 거리를 구함
     * 2.1. 이미 지나친 정점은 생략
     * 
     * 트리의 특성상 지름은 2번의 bfs로 구할 수 있음
     * 묶음 정보는 클래스로 처리하기
     * 
    */
    static int n;
    static boolean[] visit = new boolean[100001];
    static ArrayList<Node>[] list;
    static int Max;
    static int node;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1]; 
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
            int size = st.countTokens() - 1;
            for (int j = 0; j < size; j += 2) {
				int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, cost));
			}
        }
        dfs(1,0);
        dfs(node, 0);
        System.out.println(Max);
    }
    private static void dfs(int start,int score) { //시작 정점
        visit[start] = true;
        for (int i = 0; i < list[start].size(); i++) { 
            if(visit[list[start].get(i).e]) continue; // 이미 방문한 노드면 건너 뛰기
            dfs(list[start].get(i).e, score + list[start].get(i).cost);
        }
        visit[start] = false;
        if(Max < score){
            node = start;
            Max = score;
        }
        
    }
    public static class Node {
        int e;
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}
