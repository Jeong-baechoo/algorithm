#include<bits/stdc++.h>
using namespace std;


int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;

    

    while (T--)
    {
        int n;
        cin >> n;
        long long d[105];
        d[3] = d[2] = d[1] = 1;
        d[5] = d[4] = 2;
        for (int i = 6; i <= n; i++)
        {
            d[i] = d[i-1] + d[i-5];
        }
        cout << d[n] << '\n';
        
    }
    

    return 0;
}
