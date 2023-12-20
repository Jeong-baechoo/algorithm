#include<bits/stdc++.h>
using namespace std;

int m, n;
int ans;
int planet[102][10002];

void compress(int a[]){
    vector<int> tmp(a, a+n);
    sort(tmp.begin(), tmp.end()); // 좌표압축전 정렬
    tmp.erase(unique(tmp.begin(),tmp.end()),tmp.end()); //좌표 압축
    for (int i = 0; i < n; i++)
    {
        a[i] = lower_bound(tmp.begin(),tmp.end(),a[i])-tmp.begin();
    }
    
}

bool compare(int a[], int b[]) {
  for (int k = 0; k < n; k++)
    if (a[k] != b[k]) return false;
  return true;
}

int main(int argc, char const *argv[])
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n;

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> planet[i][j];
        }
        compress(planet[i]);
    }
    
    int ans = 0;
    for (int i = 0; i < m - 1; i++)
        for (int j = i + 1; j < m; j++)
            ans += compare(planet[i], planet[j]);
    cout << ans;
    return 0;
}
