#include<bits/stdc++.h>
using namespace std;

int n;
int a[51];
int b[51];

bool descendingOrder(int a, int b) {
    return a > b; // 반대로 비교
}
int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    for (int i = 0; i < n; i++)
    {
        cin >> b[i];
    }
    
    sort(a, a+n);
    sort(b, b+n, descendingOrder);

    int ans =0;
    for (int i = 0; i < n; i++)
    {
        ans += a[i] * b[i];
    }

    cout << ans;
    return 0;
}
