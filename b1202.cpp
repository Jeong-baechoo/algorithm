#include<bits/stdc++.h>
using namespace std;

pair<int,int> jewels[300003];
multiset<int> bags;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,k;
    cin >> n >> k;

    for (int i = 0; i < n; i++)
    {
        cin >> jewels[i].second >> jewels[i].first;
    }
    
    sort(jewels, jewels + n);
    
    for (int i = 0; i < k; i++)
    {
        int m;
        cin >> m;
        bags.insert(m);
    }
    long long ans = 0;
    for (int i = n-1; i >= 0; i--)
    {
        int m,v;
        tie(v,m) = jewels[i];
        auto it = bags.lower_bound(m);
        if(it == bags.end()) continue;
        ans += v;
        bags.erase(it);
    }
    cout << ans;
    
    
    return 0;
}
