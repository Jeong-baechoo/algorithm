#include<bits/stdc++.h>
using namespace std;

int t,n,m;
int a[1002];
int b[1002];

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> t;

    vector<int> aSum;
    vector<int> bSum;
    cin >> n;
    for (int i = 0; i < n; i++) cin >> a[i];
    cin >> m;
    for (int i = 0; i < m; i++) cin >> b[i];
    
    for (int i = 0; i < n; i++)
    {
        for (int j = i; j < n; j++)
        {
            int Sum = accumulate(a+i, a+j+1,0);
            aSum.push_back(Sum);
        }
    }
    
    for (int i = 0; i < m; i++)
    {
        for (int j = i; j < m; j++)
        {
            int Sum = accumulate(b+i, b+j+1,0);
            bSum.push_back(Sum);
        }
    }
    sort(bSum.begin(),bSum.end());

    long long ans = 0;
    for (int i = 0; i < aSum.size(); i++)
    {
        int target = t - aSum[i];
        int lo = lower_bound(bSum.begin(), bSum.end(), target) - bSum.begin();
        int hi = upper_bound(bSum.begin(), bSum.end(), target) - bSum.begin();
        ans += (hi - lo);
    }
    
    cout << ans;


    return 0;
}

