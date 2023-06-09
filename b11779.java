public class b11779{
    static int v;
    static int e;
    static int weight;
    static int[] parent;
    public static void main(String[] args) {
        
        
    }
}

class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;
    public Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge e) {
        return weight - e.weight;
    }
}