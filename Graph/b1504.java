package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 1번 정점에서 N번 정점으로 가는 최단 거리 (다익스트라)
 * 임의로 주어진 두 정점은 반드시 지나야함
 * 이미 지나간 정점과 간선 모두 통과 가능
 * 필수 노드를 통과했는지 check
 * N과 이어져있다면 그 노드로 돌아갈수있음
 * 
 * 1. 첫번째까지 최단거리
 *  1.1 첫번째로 가는 도중 두번째를 통과했다면 첫번째에서 N까지 최단거리
 * 2. 첫번째에서 두번쨰까지 최단거리
 * 3. 두번째에서 마지막까지 최단거리
 * 4. 필수로 지나가야하는 노드들이 이어져있지않다면 -1
 */
public class b1504 {
    static ArrayList<Node> list[];
    public static int[] distance;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //목적지
        int m = scan.nextInt(); //간선의 개수
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
          list[i] = new ArrayList<>();
        } 
        for (int i = 0; i < m; i++) {
            int s = scan.nextInt();
            int v = scan.nextInt(); // 정점
            int e = scan.nextInt(); // 간선
            list[s].add(new Node(v, e));
            list[v].add(new Node(s, e));
        }
        
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        distance = new int[n + 1];
//1 -> v1 -> v2 -> N 최단 경로 구하기
        long result = shortestPath(1, v1);
        result += shortestPath(v1, v2);
        result += shortestPath(v2, n);
//1 -> v2 -> v1 -> N 최단 경로 구하기
        long temp = shortestPath(1, v2);
        temp += shortestPath(v2, v1);
        temp += shortestPath(v1, n);

        result = Math.min(result, temp);
        if(result >= Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }
    public static int shortestPath(int start, int end) {
    	Arrays.fill(distance, Integer.MAX_VALUE);
    	distance[start] = 0;		//시작 정점 거리 0으로 초기화
         /*
        우선순위 큐를 사용해서 현재 정점들에서 거리가 가장 적은 정점을
        바로 poll()을 할 수 있도록 거리가 작은 순으로 Queue에 저장되도록
        Comparator를 설정해주었습니다.
        */
    	PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.e-o2.e;
			}
		});
    	queue.add(new Node(start,0));
    	while(!queue.isEmpty()) {
    		Node temp = queue.poll();
    		int vertex = temp.v;
    		int edge = temp.e;
    
    		if(distance[vertex] < edge)
    			continue;
    		for(Node value : list[vertex]) {
            		//더 작은 경로 찾을 때
        		if(distance[value.v] > value.e + edge) {
        			distance[value.v] = value.e + edge;
        			queue.add(new Node(value.v ,value.e + edge));
        		}
    		}
    	}
    	return distance[end];	//목적지 최단경로 반환
    }
    static class Node{
        int v;
        int e;
        public Node(int v, int e){
            this.v= v;
            this.e = e;
        }
    }
}
