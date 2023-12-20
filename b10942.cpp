#include<bits/stdc++.h>
using namespace std;


int d[2002][2002]; //s,e 구간에서 팰린드롬을 인지
int a[2002];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
        d[i][i] = 1;
        if(i != 1 && a[i-1] == a[i]){
            d[i-1][i] = 1;
        }
    }
    
    for (int i = 2; i <= n - 1; i++)
    {
        for (int j = 1; i + j <= n; j++)
        {
            if(a[j] == a[i+j] && d[j+1][i+j-1] == 1){
                d[j][j+i] = 1;
            }
        }
        
    }
    

    int t;
    cin >> t;
    while (t--)
    {
        int s,e;
        cin >> s >> e;
        cout << d[s][e] << '\n';
    }
    
    return 0;
}
