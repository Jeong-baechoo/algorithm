#include<bits/stdc++.h>
using namespace std;

int a[1002];
int d[1002][32][3]; //현재시간 , 이동횟수 , 나무번호
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t,w;

    cin >> t >> w;

    for (int i = 1; i <= t; i++)
    {
        cin >> a[i];
    }
    
    d[1][1][0] = 0;

    for (int i = 1; i <= t; i++)
    {
        d[i][0][1] = d[i - 1][0][1] + (a[i] == 1 ? 1 : 0);
        for (int j = 1; j <= w; j++) { // j번 이동
            if (i < j) break; // 현재 시간보다 많이 이동할 수 없다
            if (a[i] == 1) { // 1번 나무인 경우
                d[i][j][1] = max(d[i - 1][j - 1][2], d[i - 1][j][1]) + 1;
                d[i][j][2] = max(d[i - 1][j - 1][1], d[i - 1][j][2]);
            }
            else { // 2번 나무인 경우
                d[i][j][1] = max(d[i - 1][j - 1][2], d[i - 1][j][1]);
                d[i][j][2] = max(d[i - 1][j - 1][1], d[i - 1][j][2]) + 1;
            }
        }
    }1
    
    return 0;
}
