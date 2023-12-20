#include<bits/stdc++.h>
using namespace std;

int a[101]; //동전의 가치
int d[10001]; // 합의 경우의 수

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n,k;

    cin >> n >> k;
    
    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
    }
    d[0] = 1;
    for (int i = 1; i <= n; i++)
    {
        for (int j = a[i]; j <= k; j++)
        {
            d[j] += d[j-a[i]];
        }
        
    }
    

    cout<< d[k];

    return 0;
}
