#include<bits/stdc++.h>
using namespace std;

int d[100001];
int a[100001];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n,m;
    cin >> n >> m;

    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
        d[i] = a[i] + d[i-1];
    }
    


    while (m--)
    {
        int s,e;
        cin >> s >> e;
        cout << d[e] - d[s-1] << '\n';
    
    }

    return 0;
}
