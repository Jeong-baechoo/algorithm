#include<bits/stdc++.h>
using namespace std;
int n, c;
int x[200002];

bool solve(int len){
  int idx = 0, cnt = 0;
    while(idx != n) {
      idx = lower_bound(x + idx, x + n, x[idx] + len) - x;
      cnt++;
    }
  return cnt >= c;
}

int main(){
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> c;
  for(int i = 0; i < n; i++) cin >> x[i];
  sort(x, x + n);

  int st = 1, en = 1000000000;
  int mid; // 공유기 사이의 거리
  while(st < en) {
    mid = (st + en + 1)/2;
    if(solve(mid)) st = mid;
    else en = mid - 1;
  }
  cout << st;
}