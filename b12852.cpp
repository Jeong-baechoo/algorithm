#include<bits/stdc++.h>
using namespace std;

int d[10000005];
int pre[10000005];
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);


    int n;
    cin >> n;
    fill(begin(d),end(d),999);
    d[1] = 0;
    for (int i = 2; i <= n; i++)
    {
        d[i] = d[i-1] + 1;
        pre[i] = i - 1;
        if(i % 2 == 0 && d[i] > d[i/2] + 1){
            d[i] = d[i/2] + 1;
            pre[i] = i/2;
        }
        if(i % 3 == 0 && d[i] > d[i/3] + 1){
            d[i] = d[i/3] + 1;
            pre[i] = i/3;
        }
    }
    
    cout << d[n] << '\n';
    int cur = n;
    while(true){
        cout << cur << ' ';
        if(cur == 1) break;
        cur = pre[cur];    
    }
    return 0;
}
