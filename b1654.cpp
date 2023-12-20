#include<bits/stdc++.h>
using namespace std;

int k, n;
int a[10002];

bool solve(long long x){
    long long sum=0;
    for (int i = 0; i < k; i++)
    {
        sum += a[i]/x;
    }
    
    return sum >= n;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> k >> n;
    for (int i = 0; i < k; i++)
    {
        cin >> a[i];
    }
    
    long long st = 1;
    long long en = 0x7FFFFFFF; // 2^31 - 1
    while (st < en)
    {
        long long mid = 0;
        mid =(st+en+1)/2;
        if(solve(mid)) st = mid;
        else en = mid - 1;
    }
    
    cout << st;
    return 0;
}
