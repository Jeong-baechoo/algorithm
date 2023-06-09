import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1753 {
    /*
     * 목적: 시작 정정부터 각 정점까지의 거리를 갱신
     * 각 정점까지의 거리를 INF인 배열
     * 출발 노드로 부터 거리가 작은 순으로 방문
     * --> 우선순위 큐로 구현
     * 
     * 재귀적으로 구현할 시 메모리 초과 문제가 발생
     */
    static int distance[]; //거리
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[]list;
    static StringBuilder sb = new StringBuilder();
    static int v,e,s;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(br.readLine());
        distance = new int[v+1];
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF); // 모든 정점 초기화
        distance[s] = 0; // 출발 정점 0으로
        for (int i = 0; i < e; i++) { //간선 정보를 저장
            st = new StringTokenizer(br.readLine()," ");
            int v1 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[v1].add(new Node(v, w)); //인접 리스트
        }

        func();

        for (int i = 1; i <= v; i++) {
            if(distance[i] == INF){
                System.out.println("INF");
            } else{
                System.out.println(distance[i]);
            }
        }
        System.out.println(sb);

    } 
    private static void func(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int v = node.v;
            int weight = node.weight; 
            if(distance[v] < weight){
                continue;
            }

            for (int i = 0; i < list[v].size(); i++) {//해당 정점과 연결된 것들 탐색
                int vertex2 = list[v].get(i).v;
                int weight2 = list[v].get(i).weight + weight;
                if (distance[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }  
        }
        

    } 

    static class Node implements Comparable<Node>{
        int v;
        int weight;
        public Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
    
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
