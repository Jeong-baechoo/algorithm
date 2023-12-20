#include<bits/stdc++.h>
using namespace std;

int Map[1002][1002];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++)
    {
        string row;
        cin >> row;
        for (int j = 1; j <= row.length(); j++)
        {
            Map[i][j] = row[j-1] - '0';
        }
        
    }
    int ans=0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            if(Map[i][j] != 0){
                Map[i][j] = min(Map[i-1][j-1],min(Map[i-1][j],Map[i][j-1])) + 1;
                ans = max(ans,Map[i][j]);
            }
        }
    }
    
    cout << ans*ans;

    return 0;
}
