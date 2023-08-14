#include<bits/stdc++.h>
using namespace std;

int a[10005];
int d[10005][3];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
        d[i][1] = a[i];
    }
    
    for(int i = 2; i <= n; ++i){ //0: 안마셨을때 1:첫번째 잔일떄 2:두번째 잔일때
        d[i][0] = max({d[i-1][0], d[i-1][1], d[i-1][2]});
        d[i][1] = d[i-1][0] + a[i];
        d[i][2] = d[i-1][1] + a[i];
    }
    cout << max({d[n][0], d[n][1], d[n][2]});
    return 0;
}

