#include<bits/stdc++.h>
using namespace std;
int d[100002];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    d[1] = 1;
    for (int i = 2; i <= n; i++)
    {   
        d[i] = i;
        for (int j = 1; j <= (int)sqrt(i); j++)
        {
            d[i] = min(d[i],1+d[i-j*j]);
        }
    }


    cout << d[n];
    
    return 0;
}
