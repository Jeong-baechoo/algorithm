#include<bits/stdc++.h>
using namespace std;

int t[1500005];
int p[1500005];
long long d[1500005];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++) cin >> t[i] >> p[i];
  
    for (int i = n; i >= 1; i--)
    {
        if(t[i]+i <= n + 1){
            d[i] = max(d[i+1],d[i+t[i]]+p[i]);
        } else{
            d[i] = d[i+1];
        }
    }
    
    
    cout << *max_element(d+1, d+1+n);
    return 0;
}

