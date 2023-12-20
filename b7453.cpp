#include<bits/stdc++.h>
using namespace std;
int n;

int a[4002];
int b[4002];
int c[4002];
int d[4002];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> a[i] >> b[i] >> c[i] >> d[i];
    }
    
    vector<int> two;

    for (int i = 1; i <= n; i++) //O(n^2)
    {
        for (int j = 1; j <= n; j++)
        {
            two.push_back(a[i]+b[j]);
        }
    }
    
    sort(two.begin(), two.end());

    long long ans =0;
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            ans += upper_bound(two.begin(),two.end(),-(c[i]+d[j])) - lower_bound(two.begin(),two.end(),-(c[i]+d[j]));
        }
    }
    cout << ans;

    return 0;
}
