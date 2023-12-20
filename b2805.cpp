#include<bits/stdc++.h>
using namespace std;

int a[1000002];
int n,m;


bool solve(int x){
    long long sum = 0;
    for (int i = 0; i < n; i++)
    {
        int height = a[i];
        if(height < x) continue;
        sum += height - x;
    }
    return sum >= m;
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    long long st = 0;
    long long en = 1e9;


    while (st < en)
    {
        long long mid = (st+en+1) / 2;
        if(solve(mid)) st = mid;
        else en = mid - 1;
    }
    
    cout << st;
    return 0;
}
