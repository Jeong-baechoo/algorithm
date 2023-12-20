#include<bits/stdc++.h>
using namespace std;

int a[100002];
int n,m;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie();

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    sort(a,a+n);

    int Min = 0x7fffffff;
    int idx;
    for (int i = 0; i < n; i++)
    {
        idx = lower_bound(a,a+n,m + a[i]) - a;
        if(idx != n){
            Min = min(Min, a[idx] - a[i]);
        }
    }
    
    cout << Min;
    
    return 0;
}
