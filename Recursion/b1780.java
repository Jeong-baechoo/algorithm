import java.util.Scanner;

public class b1780 {
    static int N;
    static int[][] paper = new int[2200][2200];
    static int[] cnt = new int[3]; //-1, 0, 1로 채워진 종이 갯수

    // 해당 종이 내부에 같은 숫자로만 채워졌는지 확인하는 함수
    static boolean check(int x, int y, int n) {
        for (int i = x; i < x + n; i++)
            for (int j = y; j < y + n; j++)
                if (paper[x][y] != paper[i][j])
                    return false;
        return true;
    }

    static void solve(int x, int y, int z) {
        if (check(x, y, z)) {
            cnt[paper[x][y] + 1] += 1;
            return;
        }
        int n = z / 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                solve(x + i * n, y + j * n, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                paper[i][j] = sc.nextInt();
        solve(0, 0, N);
        for (int i = 0; i < 3; i++)
            System.out.println(cnt[i]);
    }
}
