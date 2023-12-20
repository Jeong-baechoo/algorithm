#include <bits/stdc++.h>
using namespace std;

int cnt, n;
vector<int> a;

void solve(int i) {
  for (int j = 0; j < n; j++)
  {
    if(i == j) return;
    int idx = lower_bound(a.begin(), a.end(), a[i]-a[j]) - a.begin();
    while (idx < n && a[idx] = a[i]-a[j])
    {
       if(idx != i && idx != j) { cnt++; return; }
       idx++;
    }
    
  }
  
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;
  for(int i = 0; i < n; i++) {
    int x; cin >> x;
    a.push_back(x);
  }

  sort(a.begin(), a.end());

  for(int i = 0; i < n; i++) solve(i);
  cout << cnt;
}