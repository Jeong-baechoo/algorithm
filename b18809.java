import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class b18809 {
    static int N, M, G, R, can_size, ans;
    static int[][] A;
    static ArrayList<Pair<Integer, Integer>> can;
    static ArrayList<Integer> Gr, Re;
    static int[] dy = { 0, 0, 1, -1 };
    static int[] dx = { 1, -1, 0, 0 };
    static boolean[] C;
    static class Pair<T1, T2> {
        T1 first;
        T2 second;
        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }
    static class Info {
        int y, x;
        public Info(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class B {
        int color, time;
        public B(int color, int time) {
            this.color = color;
            this.time = time;
        }
    }
    static B[][] B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        G = sc.nextInt();
        R = sc.nextInt();
        A = new int[N][M];
        can = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
                if (A[i][j] == 2) can.add(new Pair<>(i, j));
            }
        }
        can_size = can.size();
        ans = 0;
        C = new boolean[can_size];
        Gr = new ArrayList<>();
        Re = new ArrayList<>();
        B = new B[N][M];
        go(0, 0, 0, 0);
        System.out.println(ans);
    }

    static boolean oob(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) return false;
        return true;
    }

    static int bfs() {
        int res = 0;
        B = new B[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = new B(-1, -1);
            }
        }
        Queue<Info> Q = new LinkedList<>();
        int y = 0, x = 0;
        for (int p : Gr) {
            y = can.get(p).first;
            x = can.get(p).second;
            B[y][x] = new B(0, 0);
            Q.offer(new Info(y, x));
        }
        for (int p : Re) {
            y = can.get(p).first;
            x = can.get(p).second;
            Q.offer(new Info(y, x));
            B[y][x] = new B(1, 0);
        }
        while (!Q.isEmpty()) {
            int cy = Q.peek().y;
            int cx = Q.peek().x;
            int color = B[cy][cx].color;
            int ct = B[cy][cx].time;
            Q.poll();
            if (B[cy][cx].color == 3) continue;
            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if (!oob(ny, nx) || A[ny][nx] == 0) continue;
                if (B[ny][nx].color == -1) {
                    B[ny][nx].color = color;
                    B[ny][nx].time = ct + 1;
                    Q.offer(new Info(ny, nx));
                } else if (B[ny][nx].color != 3) {
                    if (B[ny][nx].color != color && B[ny][nx].time == ct + 1) {
                        B[ny][nx].color = 3;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    static void go(int idx, int cnt, int g, int r) {
        if (cnt > can_size) return;
        if (g > G) return;
        if (r > R) return;
        if (g == G && r == R) ans = Math.max(ans, bfs());
        for (int i = idx; i < can_size; i++) {
            if (C[i]) continue;
            C[i] = true;
            Gr.add(i);
            go(i, cnt + 1, g + 1, r);
            Gr.remove(Gr.size() - 1);
            Re.add(i);
            go(i, cnt + 1, g, r + 1);
            Re.remove(Re.size() - 1);
            C[i] = false;
        }
    }
}
