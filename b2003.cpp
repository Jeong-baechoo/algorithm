#include<bits/stdc++.h>
using namespace std;

int a[10002];
int n,m;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    int en = 0;
    int ans = 0;
    int sum = a[0];
    for (int st = 0; st < n; st++)
    {
        while (sum < m)
        {
            if(en == n) break;
            en++;
            sum += a[en];
        }
        
        if(sum == m) ans++;
        sum -= a[st];
    }
    cout << ans;

    return 0;
}

