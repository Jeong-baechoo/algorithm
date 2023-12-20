#include<bits/stdc++.h>
using namespace std;

int n;
long long d[1010][10];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < 10; i++)
    {
        d[1][i] = 1;
    }
    
    for (int i = 2; i <= n; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            for (int k = 0; k <= j; k++)
            {
                d[i][j] = (d[i][j] +d[i-1][k]) % 10007;
            }
            
        }
        
    }
    cout << accumulate(d[n],d[n]+10,0)%10007;    
    return 0;
}
