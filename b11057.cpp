#include<bits/stdc++.h>
using namespace std;

long long dp[1005][10];

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        dp[i][0] = 1;
        for (int j = 1; j < 10; ++j)
            dp[i][j] = (dp[i][j-1]+dp[i-1][j])%10007;
    }
    
    return 0;
}
