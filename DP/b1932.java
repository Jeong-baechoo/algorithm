package DP;

import java.io.IOException;
import java.util.Scanner;


/*
 * 목적: 맨 위에서부터 시작해서 아래에 이쓴ㄴ 수 중 하나를 선택하여 아래층으로 내려올떄
 * 합이 최대로 되도록
 * 
 * 설계: 아래서부터 위로 값을 비교해가며 최대가 되는 값을 구한다.
 * 
 * 재귀적으로 풀면 불필요한 반복이 너무 많아져 시간이 길어진다.
 */
public class b1932 {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][];

        for (int i = 0; i < N; i++) {
            nums[i] = new int[i + 1];

            for (int j = 0; j <= i; j++)
                nums[i][j] = sc.nextInt();
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)
                nums[i-1][j] += Math.max(nums[i][j], nums[i][j + 1]);
        }

        System.out.println(nums[0][0]);
    }
}