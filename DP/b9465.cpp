#include<bits/stdc++.h>
using namespace std;

int a[100002][3];
int d[100002][3]; //n의 사이즈에 따른 최대값 0:선택x 1:1행 선택 2:2행 선택
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        for (int i = 1; i <= 2; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                cin >> a[j][i];
            }
            
        }
        d[1][0] = 0;
        d[1][1] = a[1][1];
        d[1][2] = a[1][2];
        for (int i = 2; i <= n; i++)
        {
            d[i][0] = max(d[i-1][1],d[i-1][2]); 
            d[i][1] = max(d[i-1][0]+a[i][1],d[i-1][2]+a[i][1]);
            d[i][2] = max(d[i-1][0]+a[i][2],d[i-1][1]+a[i][2]); 
        }
        cout << max(d[n][1],d[n][2]) << '\n';
    }
    return 0;
}
