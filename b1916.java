package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 최단거리 문제
 * 다익스트라를 이용해서 풀기
 */
public class b1916 {
    static ArrayList<Node>[] list;
    static int[] distance;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //정점의 수
        int m = scan.nextInt(); //간선의 수
        list = new ArrayList[n+1];
        distance = new int[n+1];
        for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int edge =scan.nextInt();
            list[start].add(new Node(end, edge));
        }

        int start = scan.nextInt();
        int end = scan.nextInt();

        System.out.println(shortestPath(start, end));
    }

    static private int shortestPath(int start, int end){
        Arrays.fill(distance, Integer.MAX_VALUE); //거리 초기화
        distance[start] = 0; 
        
        PriorityQueue<Node> qu = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.edge - o2.edge;
            }
        }); //우선수위 큐로 구현
        qu.add(new Node(start, 0));
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            if(distance[cur.vertex] < cur.edge) continue;
            for (Node next : list[cur.vertex]) { //연결된 정점을 모두 큐에 추가
                if(distance[next.vertex] <= distance[cur.vertex] + next.edge) continue;
                distance[next.vertex] = distance[cur.vertex] + next.edge;
                qu.add(new Node(next.vertex, distance[next.vertex]));
            }
        }
        return distance[end];
    }
    static public class Node{
        int vertex;
        int edge;
        public Node(int vertex, int edge){
            this.vertex = vertex;
            this.edge = edge;
        }
    }
}
