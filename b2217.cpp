#include<bits/stdc++.h>
using namespace std;

int ropes[100002];
int n;

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> ropes[i];
    }

    sort(ropes, ropes +n); //오름차순 정렬
    
    int ans = 0;

    for (int i = 0; i < n; i++)
    {
        int rope = ropes[i];
        int sum = rope * (n-i);
        ans = max(ans, sum); 
    }
    
    cout << ans;
    
    return 0;
}
