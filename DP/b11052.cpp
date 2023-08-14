#include<bits/stdc++.h>
using namespace std;

int p[1002];
int d[1002];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n; //구매하려고하는 카드의 개수
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> p[i]; // i=카드팩안의 카드의 개수 p[i]= 카드팩의 가치
        d[i] = p[i];
    }
    d[1] = p[1];

    for (int i = 2; i <= n; i++)
    {
        for (int j = 1; j <= i/2; j++)
        {
            d[i] = max(d[i-j]+d[j],d[i]);
        }
    }
    
    cout << d[n];

    return 0;
}
