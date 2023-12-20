#include<bits/stdc++.h>
using namespace std;

int n;
int a[100002];

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    
    int st = 0;
    int en = n - 1;
    pair<int,int> two = {a[st],a[en]};
    while (st < en)
    {
        int mix = a[st] + a[en];
        if(abs(mix) < abs(two.first + two.second)) two = {a[st],a[en]};
        if(mix == 0) break;
        else if(mix > 0) en --;
        else if(mix < 0) st ++;
    }
    
    cout<< two.first << " " << two.second;
    return 0;
}
