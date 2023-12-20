#include<bits/stdc++.h>
using namespace std;

int a[100002];
int n,s;
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> s;

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    int en=0;
    int temp = a[0];
    int Min = 0x7fffffff;
    for (int st = 0; st < n; st++)
    {
        while (en < n && temp < s)
        {
            en++;
            if(en != n) temp += a[en];
        }
        if(en == n) break;

        Min = min(Min, en - st + 1);
        temp -= a[st];
    }
    if(Min == 0x7fffffff) Min = 0;
    cout << Min;
    return 0;
}
