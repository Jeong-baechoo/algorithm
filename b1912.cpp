#include<bits/stdc++.h>
using namespace std;

int a[100010], d[100010];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
        d[i] = a[i];
    }
    
    for (int i = 1; i <= n; i++)
    {
        d[i] = max(d[i], d[i-1]+ a[i]);
    }
    
    cout << *max_element(d+1,d+n+1);
    return 0;
}
