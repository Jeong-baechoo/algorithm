#include<bits/stdc++.h>
using namespace std;

int h[250005];
set<int> s;
int n;
long long ans;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    h[0] = 0; s.insert(0);
    h[n+1] = 0; s.insert(n+1);

    n--;
    int a; cin >> a; a++;
    h[a] = 1; s.insert(a);
    ans = 1;

    for (int i = 0; i < n; i++)
    {
        int value;
        cin >> value; value++;
        auto it = s.lower_bound(value);
        h[value] = max(h[*prev(it)], h[*it]) + 1;
        s.insert(value);

        ans += h[value];
    }
    
   cout << ans;
    
    
    return 0;
}
