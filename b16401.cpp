#include<bits/stdc++.h>
using namespace std;

int m, n;
int a[1000002];

bool solve(int x){
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum += a[i]/x;
    }
    return sum >= m;
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    int st = 1;
    int en = *max_element(a, a+n);
    while (st < en)
    {
        int mid = (st+en+1)/2;

        if(solve(mid)) st = mid;
        else en = mid - 1;
    }
    cout << st << "\n";
    return 0;
}
